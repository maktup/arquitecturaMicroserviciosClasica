package pe.com.capacitacion.exception;
 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component; 
import lombok.extern.slf4j.Slf4j;
import pe.com.capacitacion.bean.Auditoria;
import pe.com.capacitacion.bean.Departamento;
import pe.com.capacitacion.dto.ResponseDepMsg; 
import pe.com.capacitacion.util.Constantes;
 
/**
 * AuditoriaDepException IMPORTANTE: los parametros deben ser EXACTAMENTE a los mismos del metodo que lo llama. 
 * @cguerra
 **/
 @Slf4j      //Autogenerar LOG4J.
 @Component
 public class AuditoriaDepException{
	 
	   /**
	    * lanzarExceptionWS 
	    * @param  objetoParam
	    * @param  e
	    * @return ResponseEntity<ResponseDepMsg>
	    **/
	    public ResponseEntity<ResponseDepMsg> lanzarExceptionWS( Departamento objetoParam, Throwable e ){
		       log.error( "------> 'lanzarExceptionWS' " );
		       
		       ResponseDepMsg objResponseDepMsg = new ResponseDepMsg();	 
		       Auditoria      objAuditoria      = this.cargarDatosAuditoriaException( e ); 
		       
			   //Agregando:  			   
		       objResponseDepMsg.setAuditoria( objAuditoria );  

			   ResponseEntity<ResponseDepMsg> objRetorno = new ResponseEntity<ResponseDepMsg>( objResponseDepMsg, HttpStatus.BAD_REQUEST ); 
			   return objRetorno;
	    } 
    
	   /**
	    * lanzarExceptionWS 
	    * @param  id
	    * @param  e
	    * @return ResponseEntity<ResponseDepMsg>
	    **/
	    public ResponseEntity<ResponseDepMsg> lanzarExceptionWS( Long id, Throwable e ){
		       log.error( "------> 'lanzarExceptionWS' " );
 
		       ResponseDepMsg objResponseDepMsg = new ResponseDepMsg();	 
		       Auditoria      objAuditoria      = this.cargarDatosAuditoriaException( e ); 
		       
			   //Agregando:  			   
		       objResponseDepMsg.setAuditoria( objAuditoria );  

			   ResponseEntity<ResponseDepMsg> objRetorno = new ResponseEntity<ResponseDepMsg>( objResponseDepMsg, HttpStatus.BAD_REQUEST ); 
			   return objRetorno;
	    } 
	    
	   /**
	    * lanzarListaExceptionWS 
	    * @param  e
	    * @return ResponseEntity<ResponseDepMsg>
	    **/
	    public ResponseEntity<ResponseDepMsg> lanzarListaExceptionWS( Throwable e ){
		       log.error( "------> 'lanzarListaExceptionWS' " );
 
		       ResponseDepMsg objResponseDepMsg = new ResponseDepMsg();	 
		       Auditoria      objAuditoria      = this.cargarDatosAuditoriaException( e );
		  
			   //Agregando:  			   
		       objResponseDepMsg.setAuditoria( objAuditoria );  

			   ResponseEntity<ResponseDepMsg> objRetorno = new ResponseEntity<ResponseDepMsg>( objResponseDepMsg, HttpStatus.BAD_REQUEST ); 
			   return objRetorno;
	    }  
   
	   /**
	    * lanzarListaExceptionWS 
	    * @param  organizationId
        * @param  e
	    * @return ResponseEntity<ResponseDepMsg>
	    **/
	    public ResponseEntity<ResponseDepMsg> lanzarListaExceptionWS( Long organizationId, Throwable e ){
		       log.error( "------> 'lanzarListaExceptionWS' " );
 
		       ResponseDepMsg objResponseDepMsg = new ResponseDepMsg();	  
		       Auditoria      objAuditoria      = this.cargarDatosAuditoriaException( e );
		  
			   //Agregando:  			   
			   objResponseDepMsg.setAuditoria( objAuditoria );  

			   ResponseEntity<ResponseDepMsg> objRetorno = new ResponseEntity<ResponseDepMsg>( objResponseDepMsg, HttpStatus.BAD_REQUEST ); 
			   return objRetorno;
	    } 
	    
	   /**
	    * cargarDatosAuditoriaException 
	    * @param  e
	    * @return Auditoria
	    **/
	    private Auditoria cargarDatosAuditoriaException( Throwable e ){ 
		        log.error( "------> 'cargarDatosAuditoriaException' " );
 
		        Auditoria objAuditoria = new Auditoria();
		        
		        objAuditoria.setIpApp(      Constantes.IP_APP_NOK );
		        objAuditoria.setNombreApp(  Constantes.NOMBRE_APP_NOK  );
		        objAuditoria.setUsuarioApp( Constantes.USUARIO_APP_NOK ); 
		        objAuditoria.setMensajeApp( Constantes.MSJ_APP_NOK + ": " + e.getMessage() ); 
		        objAuditoria.setCodigoApp(  Constantes.COD_APP_NOK ); 
		        objAuditoria.setCodigoHttp( HttpStatus.BAD_REQUEST + "" );  //VALIDAR EL TIPO DE POSIBLE EXCEPTION.
        
			    return objAuditoria;
	    } 
	    
	   /**
	    * cargarDatosAuditoria 
	    * @param  vIpApp
	    * @param  vNombreApp
	    * @param  vUsuarioApp
	    * @param  vCodigoApp
	    * @param  vMensajeApp
	    * @return Auditoria
	    **/
	    public Auditoria cargarDatosAuditoria( String vIpApp, String vNombreApp, String vUsuarioApp, String vCodigoApp, String vMensajeApp ){ 
		       log.info( "------> 'cargarDatosAuditoria' " );
 
		       Auditoria objAuditoria = new Auditoria();
 
		       objAuditoria.setIpApp( vIpApp );
		       objAuditoria.setNombreApp(  vNombreApp );
		       objAuditoria.setUsuarioApp( vUsuarioApp );
		       objAuditoria.setMensajeApp( vMensajeApp ); 
		       objAuditoria.setCodigoApp(  Constantes.COD_APP_OK ); 
		       objAuditoria.setCodigoHttp( HttpStatus.OK + "" );  
        
			   return objAuditoria;
	    } 
	    
 }
 