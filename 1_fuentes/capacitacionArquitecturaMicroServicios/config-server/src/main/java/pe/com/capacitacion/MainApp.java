package pe.com.capacitacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * MainApp
 * @author cguerra
 **/
 @SpringBootApplication
 @EnableConfigServer      //IMPORTANTE: 'CONFIG SERVER' 
 public class MainApp{

	    public static void main( String[] argumentos ){
		       SpringApplication.run( MainApp.class, argumentos );
	    }
	   
 }
