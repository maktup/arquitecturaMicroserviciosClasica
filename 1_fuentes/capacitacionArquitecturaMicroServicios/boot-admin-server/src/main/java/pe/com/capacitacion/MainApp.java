package pe.com.capacitacion;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
@SpringBootApplication
@EnableAdminServer       //IMPORTANTE: 'BOOT-ADMIN' (SERVER) 
public class MainApp{

	   public static void main( String[] argumentos ){
		      SpringApplication.run( MainApp.class, argumentos );
	   }
	
}
