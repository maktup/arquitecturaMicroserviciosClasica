package pe.com.capacitacion.service;

import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;  
import com.google.gson.Gson;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand; 
import lombok.extern.slf4j.Slf4j;
import pe.com.capacitacion.bean.Auditoria;
import pe.com.capacitacion.bean.Departamento;
import pe.com.capacitacion.bean.Empleado;
import pe.com.capacitacion.dto.ResponseDepMsg; 
import pe.com.capacitacion.exception.AuditoriaException;
import pe.com.capacitacion.properties.ConfigurationData_01;
import pe.com.capacitacion.util.Constantes;

/**
 * DepartamentoService
 * @author cguerra
 **/
 @Slf4j      //Autogenerar LOG4J.
 @Service
 public class DepartamentoService extends AuditoriaException{
	 
		@Autowired
		private Constantes constantes; 
		
		@Autowired
		private ConfigurationData_01 objConfigurationData01;  //ACCESO: inicia con [grupoconfig01]  		 
	  		
		@Autowired
		private RestTemplateBuilder objTemplate;  
		
		@Autowired
		private EurekaClient objClient;
 
	   /**	
	    * agregarDepartamentoService	
	    * @param  departamento
	    * @return ResponseEntity<ResponseDepMsg>
	    **/ 
		@HystrixCommand( fallbackMethod = "lanzarExceptionWS" )   //ANTE UNA FALLA LANZARPA EL MÉTODO: [lanzarExceptionWS].
		public ResponseEntity<ResponseDepMsg> agregarDepartamentoService( Departamento departamento ){
			   log.info( "-----> Departamento 'agregarDepartamentoService': {}", departamento );
			   
			   Gson   objGson = new Gson();
			   String vURI    = "/departamentos";
			   
			   //---------------------------------------------------------------------------------------------------------------------------------------------//
			   String vNombreServicio = this.constantes.nombreServicio; 
			   String vValor_01       = this.constantes.valor01; 
			   String vNombres        = this.objConfigurationData01.getNombres();
			   String vDni            = this.objConfigurationData01.getDni(); 		
			   log.info( "vNombreServicio: [" + vNombreServicio + "], vValor_01: [" + vValor_01 + "], vNombres: [" + vNombres + "], vDni: [" + vDni + "]" ); 
			   //---------------------------------------------------------------------------------------------------------------------------------------------// 
			    
			   RestTemplate objRspTmp = this.objTemplate.build(); 
		 		 
			   //Conectar con 'EUREKA': 
			   InstanceInfo vIdIstanciaEureka_04 = this.objClient.getNextServerFromEureka( Constantes.INSTANCIA_EUREKA_04, false ); 		   
			   log.info( "========>: vIdIstanciaEureka_04 [" + vIdIstanciaEureka_04 + "]" );	 
			   
			   //Obtener INSTANCIA de 'EUREKA': 
			   String  vURLInst04 = vIdIstanciaEureka_04.getHomePageUrl();  
			   log.info( "========>: vURLInst [" + vURLInst04 + "]" ); 
 
			   //Armando URI: 
			   String vURL01 = (vURLInst04 + Constantes.SERVICE_NAME_04 + "/" + Constantes.HTTP_METHOD_02 + vURI); 
			   log.info( "========>: vURL01 [" + vURL01 + "]" );
			   
			   //Transformar de OBJETO a JSON:                                         
			   String vParamRequestJSON = objGson.toJson( departamento );
			   log.info( "========>: vParamRequestJSON: " + vParamRequestJSON ); 
			   	       
			   //Definiendo Entity: 
			   HttpHeaders objHeader = new HttpHeaders(); 
			   objHeader.setContentType( MediaType.APPLICATION_JSON );		 
			   HttpEntity<Object> objEntityRequest = new HttpEntity<Object>( departamento, objHeader ); 
			   
			   //Enviar mensaje POST: 
			   ResponseEntity<String> vCadenaJSON_01 = objRspTmp.postForEntity( vURL01, objEntityRequest, String.class );
			   log.info( "========>: vCadenaJSON_01 [" + vCadenaJSON_01.getBody() + "]" );
			    
			   //Transformar de JSON a OBJETO:   
			   pe.com.capacitacion.dto.ResponseDepMsg objResponseDepMsg = objGson.fromJson( vCadenaJSON_01.getBody(), pe.com.capacitacion.dto.ResponseDepMsg.class );
			   log.info( "========>: ResponseDepMsg: " + objResponseDepMsg ); 
 
			   //Objeto Return: 
			   ResponseEntity<ResponseDepMsg> objRetorno = new ResponseEntity<ResponseDepMsg>( objResponseDepMsg, HttpStatus.OK ); 
			   return objRetorno;
		}
	
	   /**	
	    * eliminarDepartamentoService	
	    * @param  id
	    * @return ResponseEntity<ResponseDepMsg>
	    **/ 
		@HystrixCommand( fallbackMethod = "lanzarExceptionWS" )   //ANTE UNA FALLA LANZARPA EL MÉTODO: [lanzarExceptionWS].
		public ResponseEntity<ResponseDepMsg> eliminarDepartamentoService( Long id ){ 
			   log.info( "-----> Departamento 'eliminarDepartamentoService': {}", id );
		 
			   String vURI = "/departamentos/";
			   
			   //---------------------------------------------------------------------------------------------------------------------------------------------//
			   String vNombreServicio = this.constantes.nombreServicio; 
			   String vValor_01       = this.constantes.valor01; 
			   String vNombres        = this.objConfigurationData01.getNombres();
			   String vDni            = this.objConfigurationData01.getDni(); 		
			   log.info( "vNombreServicio: [" + vNombreServicio + "], vValor_01: [" + vValor_01 + "], vNombres: [" + vNombres + "], vDni: [" + vDni + "]" ); 
			   //---------------------------------------------------------------------------------------------------------------------------------------------// 
			    
			   RestTemplate objRspTmp = this.objTemplate.build(); 
		 		 
			   //Conectar con 'EUREKA':
			   InstanceInfo vIdIstanciaEureka_04 = this.objClient.getNextServerFromEureka( Constantes.INSTANCIA_EUREKA_04, false ); 		   
			   log.info( "========>: vIdIstanciaEureka_04 [" + vIdIstanciaEureka_04 + "]" );	 
			   
			   //Obtener INSTANCIA de 'EUREKA': 
			   String  vURLInst04 = vIdIstanciaEureka_04.getHomePageUrl();  
			   log.info( "========>: vURLInst [" + vURLInst04 + "]" ); 
 
			   //Armando URI: 
			   String vURL01 = (vURLInst04 + Constantes.SERVICE_NAME_04 + "/" + Constantes.HTTP_METHOD_03 + vURI + id); 
			   log.info( "========>: vURL01 [" + vURL01 + "]" );
			   
			   //Enviar mensaje DELETE: 
			   objRspTmp.delete( vURL01 );  //Es VOID. 
               
			   //Armando estructura RESPONSE: 
			   Auditoria      objAuditoria      = super.cargarDatosAuditoria( Constantes.IP_APP_NOK, Constantes.MSJ_APP_OK, Constantes.USUARIO_APP_NOK, Constantes.MSJ_APP_OK ); 
			   ResponseDepMsg objResponseDepMsg = new ResponseDepMsg();
			   objResponseDepMsg.setAuditoria( objAuditoria );
			 
			   //Objeto Return: 
			   ResponseEntity<ResponseDepMsg> objRetorno = new ResponseEntity<ResponseDepMsg>( objResponseDepMsg, HttpStatus.OK ); 
			   return objRetorno; 
		}
		
	   /**
		* consultarDepartamentosAllService	 
	    * @return ResponseEntity<ResponseDepMsg>
		**/ 
		@HystrixCommand( fallbackMethod = "lanzarListaExceptionWS" )   //ANTE UNA FALLA LANZARPA EL MÉTODO: [lanzarListaExceptionWS].
		public ResponseEntity<ResponseDepMsg> consultarDepartamentosAllService(){ 
			   log.info( "-----> Departmento 'consultarDepartamentosAllService'" );
			   
			   Gson   objGson = new Gson();
			   String vURI_01 = "/departamentos";
			   String vURI_02 = "/empleados/";
			   
			   //---------------------------------------------------------------------------------------------------------------------------------------------//
			   String vNombreServicio = this.constantes.nombreServicio; 
			   String vValor_01       = this.constantes.valor01; 
			   String vNombres        = this.objConfigurationData01.getNombres();
			   String vDni            = this.objConfigurationData01.getDni(); 		
			   log.info( "vNombreServicio: [" + vNombreServicio + "], vValor_01: [" + vValor_01 + "], vNombres: [" + vNombres + "], vDni: [" + vDni + "]" ); 
			   //---------------------------------------------------------------------------------------------------------------------------------------------//
			   
			   RestTemplate objRspTmp = this.objTemplate.build(); 
		 		 
			   //Conectar con 'EUREKA' (UTL-CAPADB):
			   InstanceInfo vIdIstanciaEureka_04 = this.objClient.getNextServerFromEureka( Constantes.INSTANCIA_EUREKA_04, false ); 		   
			   log.info( "========>: vIdIstanciaEureka_04 [" + vIdIstanciaEureka_04 + "]" );	 
 
			   //Conectar con 'EUREKA' (EMPLOYEE-SERVICE):
			   InstanceInfo vIdIstanciaEureka_02 = this.objClient.getNextServerFromEureka( Constantes.INSTANCIA_EUREKA_02, false ); 		   
			   log.info( "========>: vIdIstanciaEureka_02 [" + vIdIstanciaEureka_02 + "]" );	 
			   
			   
			   //----------------------------------------------------------- [UTL-CAPADB] -----------------------------------------------------------//
			   //Obtener INSTANCIA de 'EUREKA':
			   String  vURLInst04 = vIdIstanciaEureka_04.getHomePageUrl();  
			   log.info( "========>: vURLInst [" + vURLInst04 + "]" ); 
               
			   //Armando URI:
			   String vURL01 = (vURLInst04 + Constantes.SERVICE_NAME_04 + "/" + Constantes.HTTP_METHOD_01 + vURI_01); 
			   log.info( "========>: vURL01 [" + vURL01 + "]" );
			   
			   //Enviar mensaje GET: 
			   String vCadenaJSON_01 = objRspTmp.getForObject( vURL01, String.class );
			   log.info( "========>: vCadenaJSON_01 [" + vCadenaJSON_01 + "]" ); 
			   
			   //Transformar de JSON a OBJETO: 
			   pe.com.capacitacion.dto.ResponseDepMsg objResponseDepMsg = objGson.fromJson( vCadenaJSON_01, pe.com.capacitacion.dto.ResponseDepMsg.class );
			   log.info( "========>: objResponseDepMsg: " + objResponseDepMsg ); 
			   //----------------------------------------------------------- [UTL-CAPADB] -----------------------------------------------------------//
			   
			   
			   List<Departamento> listaDepartamentos = objResponseDepMsg.getListaDepartamentos(); 
			   Departamento       objDepartamento    = null;
			   int                idDep              = 0;
			   
			   //Validacion: 
			   if(  (listaDepartamentos != null) && (listaDepartamentos.size() > 0) ){
				   
				    for( int i=0; i<listaDepartamentos.size(); i++ ){
					     objDepartamento = listaDepartamentos.get( i );
					     idDep           = objDepartamento.getId().intValue(); 
					   
					     //----------------------------------------------------------- [EMPLOYEE-SERVICE] -----------------------------------------------------------//
					     //Obtener INSTANCIA de 'EUREKA':
					     String  vURLInst02 = vIdIstanciaEureka_02.getHomePageUrl();  
					     log.info( "========>: vURLInst02 [" + vURLInst02 + "]" ); 
					   
					     //Armando URI:
					     String vURL02 = (vURLInst02 + Constantes.SERVICE_NAME_02 + "/" + Constantes.HTTP_METHOD_01 + vURI_02 + idDep); 
					     log.info( "========>: vURL02 [" + vURL02 + "]" );
					   
					     //Enviar mensaje GET: 
					     String vCadenaJSON_02 = objRspTmp.getForObject( vURL02, String.class );
					     log.info( "========>: vCadenaJSON_02 [" + vCadenaJSON_02 + "]" ); 
					   
					     //Transformar de JSON a OBJETO: 
					     pe.com.capacitacion.dto.ResponseEmplMsg objResponseEmpMsg = objGson.fromJson( vCadenaJSON_02, pe.com.capacitacion.dto.ResponseEmplMsg.class );
					     log.info( "========>: objResponseEmpMsg: " + objResponseEmpMsg );  
					     //-----------------------------------------------------------------------------------------------------------------------------------//
					   
					     //AGREGANDO:
					     List<Empleado> listaEmpleado = null;
					   
					     try{
						     listaEmpleado = objResponseEmpMsg.getListaEmpleados(); 	 
					     }
					     catch( Exception e){ 
					     } 				    
					   
					     if( (listaEmpleado != null) && (listaEmpleado.size() > 0) ){ 
						     log.info( "========>: TAMANIO 'listaEmpleado' [" + listaEmpleado.size() + "]" ); 
						     objDepartamento.getListaEmpleados().addAll( listaEmpleado );
					     }
				     } 
			     } 
			   
			     //Objeto Return:
			     ResponseEntity<ResponseDepMsg> objRetorno = new ResponseEntity<ResponseDepMsg>( objResponseDepMsg, HttpStatus.OK ); 
			     return objRetorno;   
		}
				
	   /**
	    * consultarDepartamentosPorIdService	
	    * @param  id
	    * @return ResponseEntity<ResponseDepMsg>
	    **/  
		@HystrixCommand( fallbackMethod = "lanzarExceptionWS" )   //ANTE UNA FALLA LANZARPA EL MÉTODO: [lanzarExceptionWS].
		public ResponseEntity<ResponseDepMsg> consultarDepartamentosPorIdService( Long id ){ 
			   log.info( "-----> Departamento 'consultarDepartamentosPorIdService': id={}", id );
			   
			   Gson   objGson = new Gson();
			   String vURI_01 = "/departamentos/";
			   String vURI_02 = "/empleados/";
			   
			   //---------------------------------------------------------------------------------------------------------------------------------------------//
			   String vNombreServicio = this.constantes.nombreServicio; 
			   String vValor_01       = this.constantes.valor01; 
			   String vNombres        = this.objConfigurationData01.getNombres();
			   String vDni            = this.objConfigurationData01.getDni(); 		
			   log.info( "vNombreServicio: [" + vNombreServicio + "], vValor_01: [" + vValor_01 + "], vNombres: [" + vNombres + "], vDni: [" + vDni + "]" ); 
			   //---------------------------------------------------------------------------------------------------------------------------------------------//
			   
			   RestTemplate objRspTmp = this.objTemplate.build(); 
		 		 
			   //Conectar con 'EUREKA' (UTL-CAPADB):
			   InstanceInfo vIdIstanciaEureka_04 = this.objClient.getNextServerFromEureka( Constantes.INSTANCIA_EUREKA_04, false ); 		   
			   log.info( "========>: vIdIstanciaEureka_04 [" + vIdIstanciaEureka_04 + "]" );	 
 
			   //Conectar con 'EUREKA' (EMPLOYEE-SERVICE):
			   InstanceInfo vIdIstanciaEureka_02 = this.objClient.getNextServerFromEureka( Constantes.INSTANCIA_EUREKA_02, false ); 		   
			   log.info( "========>: vIdIstanciaEureka_02 [" + vIdIstanciaEureka_02 + "]" );	 
			   
			   
			   //----------------------------------------------------------- [UTL-CAPADB] -----------------------------------------------------------//
			   //Obtener INSTANCIA de 'EUREKA': 
			   String  vURLInst04 = vIdIstanciaEureka_04.getHomePageUrl();  
			   log.info( "========>: vURLInst [" + vURLInst04 + "]" ); 
 
			   //Armando URI:
			   String vURL01 = (vURLInst04 + Constantes.SERVICE_NAME_04 + "/" + Constantes.HTTP_METHOD_01 + vURI_01 + id); 
			   log.info( "========>: vURL01 [" + vURL01 + "]" );
			   
			   //Enviar mensaje GET:
			   String vCadenaJSON_01 = objRspTmp.getForObject( vURL01, String.class );
			   log.info( "========>: vCadenaJSON_01 [" + vCadenaJSON_01 + "]" ); 
			   
			   //Transformar de JSON a OBJETO: 
			   pe.com.capacitacion.dto.ResponseDepMsg objResponseDepMsg = objGson.fromJson( vCadenaJSON_01, pe.com.capacitacion.dto.ResponseDepMsg.class );
			   log.info( "========>: objResponseDepMsg: " + objResponseDepMsg );  
			   //----------------------------------------------------------- [UTL-CAPADB] -----------------------------------------------------------//
			   
			   
			   List<Departamento> listaDepartamentos = objResponseDepMsg.getListaDepartamentos(); 
			   Departamento       objDepartamento    = null;
			   int                idDep              = 0;
			   
			   //Validacion: 
			   if(  (listaDepartamentos != null) && (listaDepartamentos.size() > 0) ){
				   
				    for( int i=0; i<listaDepartamentos.size(); i++ ){
					     objDepartamento = listaDepartamentos.get( i );
					     idDep           = objDepartamento.getId().intValue(); 
					   
					     //------------------------------------------------------- [EMPLOYEE-SERVICE] -------------------------------------------------------//
					     //Obtener INSTANCIA de 'EUREKA': 
					     String  vURLInst02 = vIdIstanciaEureka_02.getHomePageUrl();  
					     log.info( "========>: vURLInst02 [" + vURLInst02 + "]" ); 
					   
					     //Armando URI:
					     String vURL02 = (vURLInst02 + Constantes.SERVICE_NAME_02 + "/" + Constantes.HTTP_METHOD_01 + vURI_02 + idDep); 
					     log.info( "========>: vURL02 [" + vURL02 + "]" );
					   
					     //Enviar mensaje GET:
					     String vCadenaJSON_02 = objRspTmp.getForObject( vURL02, String.class );
					     log.info( "========>: vCadenaJSON_02 [" + vCadenaJSON_02 + "]" ); 
					   
					     //Transformar de JSON a OBJETO: 
					     pe.com.capacitacion.dto.ResponseEmplMsg objResponseEmpMsg = objGson.fromJson( vCadenaJSON_02, pe.com.capacitacion.dto.ResponseEmplMsg.class );
					     log.info( "========>: objResponseEmpMsg: " + objResponseEmpMsg );  
					     //-----------------------------------------------------------------------------------------------------------------------------------//
					   
					     //AGREGANDO:
					     List<Empleado> listaEmpleado = null;
					   
					     try{
						     listaEmpleado = objResponseEmpMsg.getListaEmpleados(); 	 
					     }
					     catch( Exception e){ 
					     } 				    
					   
					     if( (listaEmpleado != null) && (listaEmpleado.size() > 0) ){ 
						     log.info( "========>: TAMANIO 'listaEmpleado' [" + listaEmpleado.size() + "]" ); 
						     objDepartamento.getListaEmpleados().addAll( listaEmpleado );
					     }
				     } 
			    }
			    			   
			    //Objeto Return:
			    ResponseEntity<ResponseDepMsg> objRetorno = new ResponseEntity<ResponseDepMsg>( objResponseDepMsg, HttpStatus.OK ); 
			    return objRetorno;   
		}		
			
	   /**
	    * consultarDepartamentosPorOrganizacionService	
	    * @param  idOrg
	    * @return ResponseDepMsg
	    **/ 
		@HystrixCommand( fallbackMethod = "lanzarListaExceptionWS" )   //ANTE UNA FALLA LANZARPA EL MÉTODO: [lanzarListaExceptionWS].
		public ResponseEntity<ResponseDepMsg> consultarDepartamentosPorOrganizacionService( Long idOrg ){ 
			   log.info( "-----> Departamento 'consultarDepartamentosPorOrganizacionService': id={}", idOrg );
			   
			   Gson   objGson = new Gson();
			   String vURI_01 = "/departamentos-organizacion/";
			   String vURI_02 = "/empleados/";
			   
			   //---------------------------------------------------------------------------------------------------------------------------------------------//
			   String vNombreServicio = this.constantes.nombreServicio; 
			   String vValor_01       = this.constantes.valor01; 
			   String vNombres        = this.objConfigurationData01.getNombres();
			   String vDni            = this.objConfigurationData01.getDni(); 		
			   log.info( "vNombreServicio: [" + vNombreServicio + "], vValor_01: [" + vValor_01 + "], vNombres: [" + vNombres + "], vDni: [" + vDni + "]" ); 
			   //---------------------------------------------------------------------------------------------------------------------------------------------// 
			  
			   RestTemplate objRspTmp = this.objTemplate.build(); 
		 
			   //Conectar con 'EUREKA' (UTL-CAPADB):
			   InstanceInfo vIdIstanciaEureka_04 = this.objClient.getNextServerFromEureka( Constantes.INSTANCIA_EUREKA_04, false ); 		   
			   log.info( "========>: vIdIstanciaEureka_04 [" + vIdIstanciaEureka_04 + "]" );	 
 
			   //Conectar con 'EUREKA' (EMPLOYEE-SERVICE):
			   InstanceInfo vIdIstanciaEureka_02 = this.objClient.getNextServerFromEureka( Constantes.INSTANCIA_EUREKA_02, false ); 		   
			   log.info( "========>: vIdIstanciaEureka_02 [" + vIdIstanciaEureka_02 + "]" );	 
			   
			   
			   //----------------------------------------------------------- [UTL-CAPADB] -----------------------------------------------------------//
			   //Obtener INSTANCIA de 'EUREKA':
			   String  vURLInst04 = vIdIstanciaEureka_04.getHomePageUrl();  
			   log.info( "========>: vURLInst04 [" + vURLInst04 + "]" ); 
 
			   //Armando URI:
			   String vURL01 = (vURLInst04 + Constantes.SERVICE_NAME_04 + "/" + Constantes.HTTP_METHOD_01 + vURI_01 + idOrg); 
			   log.info( "========>: vURL01 [" + vURL01 + "]" );
			   
			   //Enviar mensaje GET:
			   String vCadenaJSON_01 = objRspTmp.getForObject( vURL01, String.class );
			   log.info( "========>: vCadenaJSON_01 [" + vCadenaJSON_01 + "]" ); 
			   
			   //Transformar de JSON a OBJETO:  	
			   pe.com.capacitacion.dto.ResponseDepMsg objResponseDepMsg = objGson.fromJson( vCadenaJSON_01, pe.com.capacitacion.dto.ResponseDepMsg.class );
			   log.info( "========>: objResponseDepMsg: " + objResponseDepMsg );  
			   //-----------------------------------------------------------------------------------------------------------------------------------//
			   
			   
			   List<Departamento> listaDepartamentos = objResponseDepMsg.getListaDepartamentos(); 
			   Departamento       objDepartamento    = null;
			   int                idDep              = 0;
			   
			   //Validacion: 
			   if(  (listaDepartamentos != null) && (listaDepartamentos.size() > 0) ){
				   
				    for( int i=0; i<listaDepartamentos.size(); i++ ){
					     objDepartamento = listaDepartamentos.get( i );
					     idDep           = objDepartamento.getId().intValue(); 
					   
					     //-------------------------------------------------------- [EMPLOYEE-SERVICE] -------------------------------------------------------//
					     //Obtener INSTANCIA de 'EUREKA':
					     String  vURLInst02 = vIdIstanciaEureka_02.getHomePageUrl();  
					     log.info( "========>: vURLInst02 [" + vURLInst02 + "]" ); 
					   
					     //Armando URI:
					     String vURL02 = (vURLInst02 + Constantes.SERVICE_NAME_02 + "/" + Constantes.HTTP_METHOD_01 + vURI_02 + idDep); 
					     log.info( "========>: vURL02 [" + vURL02 + "]" );
					   
					     //Enviar mensaje GET:
					     String vCadenaJSON_02 = objRspTmp.getForObject( vURL02, String.class );
					     log.info( "========>: vCadenaJSON_02 [" + vCadenaJSON_02 + "]" ); 
					   
					     //Transformar de JSON a OBJETO: 	
					     pe.com.capacitacion.dto.ResponseEmplMsg objResponseEmpMsg = objGson.fromJson( vCadenaJSON_02, pe.com.capacitacion.dto.ResponseEmplMsg.class );
					     log.info( "========>: objResponseEmpMsg: " + objResponseEmpMsg );  
					     //-----------------------------------------------------------------------------------------------------------------------------------//
					   
					     //AGREGANDO:
					     List<Empleado> listaEmpleado = null;
					   
					     try{
						     listaEmpleado = objResponseEmpMsg.getListaEmpleados(); 	 
					     }
					     catch( Exception e){ 
					     } 				    
					   
					     if( (listaEmpleado != null) && (listaEmpleado.size() > 0) ){ 
						     log.info( "========>: TAMANIO 'listaEmpleado' [" + listaEmpleado.size() + "]" ); 
						     objDepartamento.getListaEmpleados().addAll( listaEmpleado );
					     }
				     } 
			    }
			      
			    //Objeto Return:
			    ResponseEntity<ResponseDepMsg> objRetorno = new ResponseEntity<ResponseDepMsg>( objResponseDepMsg, HttpStatus.OK ); 
			    return objRetorno;  
		}
	 
 }
 
