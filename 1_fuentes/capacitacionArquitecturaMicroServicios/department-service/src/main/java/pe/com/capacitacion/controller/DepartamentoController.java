package pe.com.capacitacion.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; 
import lombok.extern.slf4j.Slf4j;
import pe.com.capacitacion.bean.Departamento;
import pe.com.capacitacion.dto.ResponseDepMsg; 
import pe.com.capacitacion.service.DepartamentoService; 

/**
 * DepartmentoController
 * @author cguerra
 **/
 @Slf4j      //Autogenerar LOG4J.
 @RestController
 @RequestMapping( "/departmentservice" ) //NO USAR: [server.servlet.context-path], 'BOOT-ADMIN' reconocera el 'ACTUATOR'.
 public class DepartamentoController{
 
		@Autowired
		private DepartamentoService objDepartamentoService; 
 
		
	   /**
	    * agregarDepartamento	
	    * @param  departamento
	    * @return ResponseEntity<ResponseDepMsg>
	    **/
		@PostMapping( "/post/departamentos" )
		public ResponseEntity<ResponseDepMsg> agregarDepartamento( @RequestBody Departamento departamento ){
			   log.info( "-----> Departamento 'agregarDepartamento': {}", departamento ); 
 
			   //Ejecutar: 
			   ResponseEntity<ResponseDepMsg> objResponseMsg = this.objDepartamentoService.agregarDepartamentoService( departamento );  
			   return objResponseMsg; 
		}	
	
	   /**
	    * eliminarDepartamento	
	    * @param  id
	    * @return ResponseEntity<ResponseDepMsg>
	    **/
		@DeleteMapping( "/delete/departamentos/{id}" )
		public ResponseEntity<ResponseDepMsg> eliminarDepartamento( @PathVariable( "id" ) Long id ){ 
			   log.info( "-----> Departamento 'eliminarDepartamento': {}", id ); 
 
			   //Ejecutar: 
			   ResponseEntity<ResponseDepMsg> objResponseMsg = this.objDepartamentoService.eliminarDepartamentoService( id );  
			   return objResponseMsg; 
		}
		
		/**
		 * consultarDepartamentosAll	
		 * @return ResponseEntity<ResponseDepMsg>
		 **/
		@GetMapping( "/get/departamentos" )
		public ResponseEntity<ResponseDepMsg> consultarDepartamentosAll(){ 
			   log.info( "-----> Departmento 'consultarDepartamentosAll'" );
 
			   //Ejecutar: 
			   ResponseEntity<ResponseDepMsg> objResponseMsg = this.objDepartamentoService.consultarDepartamentosAllService(); 
			   return objResponseMsg; 
		}	
		
	   /**
	    * consultarDepartamentosPorId	
	    * @param  id
	    * @return ResponseEntity<ResponseDepMsg>
	    **/ 
		@GetMapping( "/get/departamentos/{id}" )
		public ResponseEntity<ResponseDepMsg> consultarDepartamentosPorId( @PathVariable( "id" ) Long id ){ 
			   log.info( "-----> Departamento 'consultarDepartamentosPorId': id={}", id );
 
			   //Ejecutar: 
			   ResponseEntity<ResponseDepMsg> objResponseMsg = this.objDepartamentoService.consultarDepartamentosPorIdService( id ); 
			   return objResponseMsg; 
		}		
		
	   /**
	    * consultarDepartamentosPorOrganizacion	
	    * @param  idOrg
	    * @return ResponseEntity<ResponseDepMsg>
	    **/
		@GetMapping( "/get/departamentos-organizacion/{idOrg}" )
		public ResponseEntity<ResponseDepMsg> consultarDepartamentosPorOrganizacion( @PathVariable( "idOrg" ) Long idOrg ){
			   log.info( "-----> Departamento 'consultarDepartamentosPorOrganizacion': idOrg={}", idOrg );
 
			   //Ejecutar:  
			   ResponseEntity<ResponseDepMsg> objResponseMsg = this.objDepartamentoService.consultarDepartamentosPorOrganizacionService( idOrg ); 
			   return objResponseMsg; 
		}
 
 }

 