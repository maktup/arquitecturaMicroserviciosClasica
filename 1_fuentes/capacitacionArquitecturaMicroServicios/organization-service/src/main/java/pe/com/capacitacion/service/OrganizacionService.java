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
import pe.com.capacitacion.bean.Organizacion; 
import pe.com.capacitacion.dto.ResponseOrgMsg;
import pe.com.capacitacion.exception.AuditoriaException;
import pe.com.capacitacion.properties.ConfigurationData_01;
import pe.com.capacitacion.util.Constantes;

/**
 * OrganizacionService
 * @author cguerra
 **/
 @Slf4j      //Autogenerar LOG4J.
 @Service
 public class OrganizacionService extends AuditoriaException{
 
		@Autowired
		private Constantes constantes; 
		
		@Autowired
		private ConfigurationData_01 objConfigurationData01;  //ACCESO: inicia con [grupoconfig01]  
 
		@Autowired
		private EurekaClient objClient;
		
		@Autowired
		private RestTemplateBuilder objTemplate;  
		
		
	   /**
	    * agregarOrganizacionService 	
	    * @param  organizacion
	    * @return ResponseEntity<ResponseOrgMsg>
	    **/ 
		@HystrixCommand( fallbackMethod = "lanzarExceptionWS" )   //ANTE UNA FALLA LANZARPA EL M�TODO: [lanzarExceptionWS].
		public ResponseEntity<ResponseOrgMsg> agregarOrganizacionService( Organizacion organizacion ){ 
			   log.info( "------> Organizacion 'agregarOrganizacionService': {}", organizacion );
			   
			   Gson   objGson = new Gson();
			   String vURI    = "/organizaciones";
			   
			   //Variables de Entorno: 
			   this.mostrarVariablesEntorno( this.constantes, this.objConfigurationData01 );
			    
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
			   String vParamRequestJSON = objGson.toJson( organizacion );
			   log.info( "========>: vParamRequestJSON: " + vParamRequestJSON ); 
			   	       
			   //Definiendo Entity: 
			   HttpHeaders objHeader = new HttpHeaders(); 
			   objHeader.setContentType( MediaType.APPLICATION_JSON );		 
			   HttpEntity<Object> objEntityRequest = new HttpEntity<Object>( organizacion, objHeader ); 
			   
			   //Enviar mensaje POST: 
			   ResponseEntity<String> vCadenaJSON_01 = objRspTmp.postForEntity( vURL01, objEntityRequest, String.class );
			   log.info( "========>: vCadenaJSON_01 [" + vCadenaJSON_01.getBody() + "]" );
			   
			   //Transformar de JSON a OBJETO:   
			   pe.com.capacitacion.dto.ResponseOrgMsg objResponseOrgMsg = objGson.fromJson( vCadenaJSON_01.getBody(), pe.com.capacitacion.dto.ResponseOrgMsg.class );
			   log.info( "========>: ResponseOrgMsg: " + objResponseOrgMsg ); 
 
			   //Objeto Return: 
			   ResponseEntity<ResponseOrgMsg> objRetorno = new ResponseEntity<ResponseOrgMsg>( objResponseOrgMsg, HttpStatus.OK ); 
			   return objRetorno;			   
		}		
	
	   /**
	    * eliminarOrganizacionService 	
	    * @param  id
	    * @return ResponseEntity<ResponseOrgMsg>
	    **/ 
		@HystrixCommand( fallbackMethod = "lanzarExceptionWS" )   //ANTE UNA FALLA LANZARPA EL M�TODO: [lanzarExceptionWS].
		public ResponseEntity<ResponseOrgMsg> eliminarOrganizacionService( Long id ){
			   log.info( "------> Organizacion 'eliminarOrganizacionService': {}", id );
	 
			   String vURI = "/organizaciones/";
			   
			   //Variables de Entorno: 
			   this.mostrarVariablesEntorno( this.constantes, this.objConfigurationData01 ); 
			    
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
			   ResponseOrgMsg objResponseOrgMsg = new ResponseOrgMsg();
			   objResponseOrgMsg.setAuditoria( objAuditoria );
 
			   //Objeto Return: 
			   ResponseEntity<ResponseOrgMsg> objRetorno = new ResponseEntity<ResponseOrgMsg>( objResponseOrgMsg, HttpStatus.OK ); 
			   return objRetorno;				   
		}
		
	   /**
	    * consultarOrganizacionesAllService	
	    * @return ResponseEntity<ResponseOrgMsg>
	    **/ 
		@HystrixCommand( fallbackMethod = "lanzarListaExceptionWS" )   //ANTE UNA FALLA LANZARPA EL M�TODO: [lanzarListaExceptionWS].
		public ResponseEntity<ResponseOrgMsg> consultarOrganizacionesAllService(){
			   log.info( "------> Organizacion 'consultarOrganizacionesAllService'" );
  
			   Gson   objGson = new Gson();
			   String vURI_01 = "/organizaciones";
			   String vURI_02 = "/departamentos-organizacion/";
			   
			   //Variables de Entorno: 
			   this.mostrarVariablesEntorno( this.constantes, this.objConfigurationData01 );
			   
			   RestTemplate objRspTmp  = this.objTemplate.build(); 
	 
			   //Conectar con 'EUREKA' (UTL-CAPADB):
			   InstanceInfo vIdIstanciaEureka_04 = this.objClient.getNextServerFromEureka( Constantes.INSTANCIA_EUREKA_04, false ); 		   
			   log.info( "========>: vIdIstanciaEureka_04 [" + vIdIstanciaEureka_04 + "]" );	 
 
			   //Conectar con 'EUREKA' (DEPARTMENT-SERVICE):
			   InstanceInfo vIdIstanciaEureka_01 = this.objClient.getNextServerFromEureka( Constantes.INSTANCIA_EUREKA_01, false ); 		   
			   log.info( "========>: vIdIstanciaEureka_01 [" + vIdIstanciaEureka_01 + "]" );	 
			   
			   
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
			   pe.com.capacitacion.dto.ResponseOrgMsg objResponseOrgMsg = objGson.fromJson( vCadenaJSON_01, pe.com.capacitacion.dto.ResponseOrgMsg.class );
			   log.info( "========>: objResponseOrgMsg: " + objResponseOrgMsg ); 
			   //----------------------------------------------------------- [UTL-CAPADB] -----------------------------------------------------------//
			   
			   
			   List<Organizacion> listaOrganizaciones = objResponseOrgMsg.getListaOrganizaciones();   
			   Organizacion       objOrganizacion     = null;
			   int                idOrg               = 0;
			   
			   //Validacion: 
			   if(  (listaOrganizaciones != null) && (listaOrganizaciones.size() > 0) ){
				   
				    for( int i=0; i<listaOrganizaciones.size(); i++ ){
					     objOrganizacion = listaOrganizaciones.get( i );
					     idOrg           = objOrganizacion.getId().intValue(); 
					   
					     //------------------------------------------------------ [DEPARTMENT-SERVICE] -------------------------------------------------------//
					     //Obtener INSTANCIA de 'EUREKA': 
					     String  vURLInst02 = vIdIstanciaEureka_01.getHomePageUrl();  
					     log.info( "========>: vURLInst02 [" + vURLInst02 + "]" ); 
					   
					     //Armando URI: 
					     String vURL02 = (vURLInst02 + Constantes.SERVICE_NAME_01 + "/" + Constantes.HTTP_METHOD_01 + vURI_02 + idOrg); 
					     log.info( "========>: vURL02 [" + vURL02 + "]" );
					   
					     //Enviar mensaje GET: 
					     String vCadenaJSON_02 = objRspTmp.getForObject( vURL02, String.class );  
					     log.info( "========>: vCadenaJSON_02 [" + vCadenaJSON_02 + "]" ); 
					   
					     //Transformar de JSON a OBJETO:  
					     pe.com.capacitacion.dto.ResponseDepMsg objResponseDepMsg = objGson.fromJson( vCadenaJSON_02, pe.com.capacitacion.dto.ResponseDepMsg.class );
					     log.info( "========>: objResponseDepMsg: " + objResponseDepMsg );  
					     //-----------------------------------------------------------------------------------------------------------------------------------//
					   
					     //AGREGANDO:
					     List<Departamento> listaDepartamento = null; 
					   
					     try{
						     listaDepartamento = objResponseDepMsg.getListaDepartamentos(); 
					     }
					     catch( Exception e){ 
					     }  
					   
					     if( (listaDepartamento != null) && (listaDepartamento.size() > 0) ){ 
						     log.info( "========>: TAMANIO 'listaDepartamento' [" + listaDepartamento.size() + "]" ); 
						     objOrganizacion.getListaDepartamentos().addAll( listaDepartamento );
					     }
				   } 
				   
			   }			   
			   
			   //Objeto Return:
			   ResponseEntity<ResponseOrgMsg> objRetorno = new ResponseEntity<ResponseOrgMsg>( objResponseOrgMsg, HttpStatus.OK ); 
			   return objRetorno;	
		}	
		
	   /**
	    * consultarOrganizacionesPorIdService	
	    * @param  id
	    * @return ResponseEntity<ResponseOrgMsg>
	    **/ 
		@HystrixCommand( fallbackMethod = "lanzarExceptionWS" )   //ANTE UNA FALLA LANZARPA EL M�TODO: [lanzarExceptionWS].
		public ResponseEntity<ResponseOrgMsg> consultarOrganizacionesPorIdService( Long id ){
			   log.info( "------> Organizacion 'consultarOrganizacionesPorId': id={}", id ); 
			   
			   Gson   objGson = new Gson();
			   String vURI_01 = "/organizaciones/";
			   String vURI_02 = "/departamentos-organizacion/";
			   
			   //Variables de Entorno: 
			   this.mostrarVariablesEntorno( this.constantes, this.objConfigurationData01 );
			   
			   RestTemplate objRspTmp = this.objTemplate.build(); 
 
			   //Conectar con 'EUREKA' (UTL-CAPADB):
			   InstanceInfo vIdIstanciaEureka_04 = this.objClient.getNextServerFromEureka( Constantes.INSTANCIA_EUREKA_04, false ); 		   
			   log.info( "========>: vIdIstanciaEureka_04 [" + vIdIstanciaEureka_04 + "]" );	 
 
			   //Conectar con 'EUREKA' (DEPARTMENT-SERVICE):
			   InstanceInfo vIdIstanciaEureka_01 = this.objClient.getNextServerFromEureka( Constantes.INSTANCIA_EUREKA_01, false ); 		   
			   log.info( "========>: vIdIstanciaEureka_01 [" + vIdIstanciaEureka_01 + "]" );	 
			   
			   
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
			   pe.com.capacitacion.dto.ResponseOrgMsg objResponseOrgMsg = objGson.fromJson( vCadenaJSON_01, pe.com.capacitacion.dto.ResponseOrgMsg.class );
			   log.info( "========>: objResponseOrgMsg: " + objResponseOrgMsg ); 
			   //----------------------------------------------------------- [UTL-CAPADB] -----------------------------------------------------------//
			   
			   
			   List<Organizacion> listaOrganizaciones = objResponseOrgMsg.getListaOrganizaciones();   
			   Organizacion       objOrganizacion     = null;
			   int                idOrg               = 0;
			   
			   //Validacion: 
			   if(  (listaOrganizaciones != null) && (listaOrganizaciones.size() > 0) ){
				   
				    for( int i=0; i<listaOrganizaciones.size(); i++ ){
					     objOrganizacion = listaOrganizaciones.get( i );
					     idOrg           = objOrganizacion.getId().intValue(); 
					   
					     //------------------------------------------------------ [DEPARTMENT-SERVICE] -------------------------------------------------------//
					     //Obtener INSTANCIA de 'EUREKA':
					     String  vURLInst02 = vIdIstanciaEureka_01.getHomePageUrl();  
					     log.info( "========>: vURLInst02 [" + vURLInst04 + "]" ); 
					   
					     //Armando URI:
					     String vURL02 = (vURLInst02 + Constantes.SERVICE_NAME_01 + "/" + Constantes.HTTP_METHOD_01 + vURI_02 + idOrg); 
					     log.info( "========>: vURL02 [" + vURL02 + "]" );
					   
					     //Enviar mensaje GET:
					     String vCadenaJSON_02 = objRspTmp.getForObject( vURL02, String.class );
					     log.info( "========>: vCadenaJSON_02 [" + vCadenaJSON_02 + "]" ); 
					   
					     //Transformar de JSON a OBJETO: 
					     pe.com.capacitacion.dto.ResponseDepMsg objResponseDepMsg = objGson.fromJson( vCadenaJSON_02, pe.com.capacitacion.dto.ResponseDepMsg.class );
					     log.info( "========>: objResponseDepMsg: " + objResponseDepMsg );  
					     //-----------------------------------------------------------------------------------------------------------------------------------//
					   
					     //AGREGANDO:
					     List<Departamento> listaDepartamento = null; 
					   
					     try{
						     listaDepartamento = objResponseDepMsg.getListaDepartamentos(); 
					     }
					     catch( Exception e){ 
					     } 				    
					   
					     if( (listaDepartamento != null) && (listaDepartamento.size() > 0) ){ 
						     log.info( "========>: TAMANIO 'listaDepartamento' [" + listaDepartamento.size() + "]" ); 
						     objOrganizacion.getListaDepartamentos().addAll( listaDepartamento );
					     }
				   } 
			   }
			   
			   
			   //Objeto Return:
			   ResponseEntity<ResponseOrgMsg> objRetorno = new ResponseEntity<ResponseOrgMsg>( objResponseOrgMsg, HttpStatus.OK ); 
			   return objRetorno;	 
		}
	 
	   /**
	    * mostrarVariablesEntorno
	    * @param constantesParam
	    * @param objConfigurationData01Param 
	    **/
        private void mostrarVariablesEntorno( Constantes constantesParam, ConfigurationData_01 objConfigurationData01Param ){
        	    log.info( "-----> Organizacion 'mostrarVariablesEntorno'" );
        	 
			    String vNombreServicio = constantesParam.nombreServicio; 
			    String vValor_01       = constantesParam.valor01; 
			    String vNombres        = objConfigurationData01Param.getNombres();
			    String vDni            =  objConfigurationData01Param.getDni(); 			
			    log.info( "vNombreServicio: [" + vNombreServicio + "], vValor_01: [" + vValor_01 + "], vNombres: [" + vNombres + "], vDni: [" + vDni + "]" ); 
        }
        
 }
 
