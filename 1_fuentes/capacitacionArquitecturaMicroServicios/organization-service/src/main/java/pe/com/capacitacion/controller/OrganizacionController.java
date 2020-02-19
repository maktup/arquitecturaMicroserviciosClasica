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
import pe.com.capacitacion.bean.Organizacion;
import pe.com.capacitacion.dto.ResponseOrgMsg; 
import pe.com.capacitacion.service.OrganizacionService;

/**
 * OrganizacionController
 * @author cguerra
 **/
 @Slf4j      //Autogenerar LOG4J.
 @RestController 
 @RequestMapping( "/organizationservice" ) //NO USAR: [server.servlet.context-path], 'BOOT-ADMIN' reconocera el 'ACTUATOR'.
 public class OrganizacionController{
 
		@Autowired
		private OrganizacionService objOrganizacionService;
		
		
	   /**
	    * agregarOrganizacion 	
	    * @param  organizacion
	    * @return ResponseEntity<ResponseOrgMsg>
	    **/
		@PostMapping( "/post/organizaciones" )
		public ResponseEntity<ResponseOrgMsg> agregarOrganizacion( @RequestBody Organizacion organizacion ){ 
			   log.info( "-----> Organizacion 'agregarOrganizacion': {}", organizacion );
 
			   //Ejecutar: 
			   ResponseEntity<ResponseOrgMsg> objResponseOrgMsg = this.objOrganizacionService.agregarOrganizacionService( organizacion ); 
			   return objResponseOrgMsg; 
		}
		
	   /**
	    * eliminarOrganizacion 	
	    * @param  id
	    * @return ResponseEntity<ResponseOrgMsg>
	    **/
		@DeleteMapping( "/delete/organizaciones/{id}" )
		public ResponseEntity<ResponseOrgMsg> eliminarOrganizacion( @PathVariable( "id" ) Long id ){  
			   log.info( "-----> Organizacion 'eliminarOrganizacion': {}", id );
 
			   //Ejecutar: 
			   ResponseEntity<ResponseOrgMsg> objResponseOrgMsg = this.objOrganizacionService.eliminarOrganizacionService( id ); 
			   return objResponseOrgMsg; 
		}
		
	   /**
	    * consultarOrganizacionesAll	
	    * @return ResponseEntity<ResponseOrgMsg>
	    **/ 
		@GetMapping( "/get/organizaciones" ) 
		public ResponseEntity<ResponseOrgMsg> consultarOrganizacionesAll(){
			   log.info( "-----> Organizacion 'consultarOrganizacionesAll'" );
	 
			   //Ejecutar: 
			   ResponseEntity<ResponseOrgMsg> objResponseOrgMsg = this.objOrganizacionService.consultarOrganizacionesAllService(); 
			   return objResponseOrgMsg; 
		}
	
	   /**
	    * consultarOrganizacionesPorId	
	    * @param  id
	    * @return ResponseEntity<ResponseOrgMsg>
	    **/   
		@GetMapping( "/get/organizaciones/{id}" ) 
		public ResponseEntity<ResponseOrgMsg> consultarOrganizacionesPorId( @PathVariable( "id" ) Long id ){ 
			   log.info( "-----> Organizacion 'consultarOrganizacionesPorId': id={}", id ); 
 
			   //Ejecutar: 
			   ResponseEntity<ResponseOrgMsg> objResponseOrgMsg = this.objOrganizacionService.consultarOrganizacionesPorIdService( id ); 
			   return objResponseOrgMsg; 
		}
		 
 }
 
