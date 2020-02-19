package pe.com.capacitacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication; 
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * MainApp
 * @author cguerra
 **/
 @SpringBootApplication
 @EnableEurekaServer     //IMPORTANTE: 'EUREKA SERVER' 
 public class MainApp{

 	    public static void main( String[] argumentos ){
		       SpringApplication.run( MainApp.class, argumentos );
	    }
	   
 } 
