package pe.com.capacitacion;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * WebSecurityConfig
 * @author cguerra
 **/
 @EnableWebSecurity
 public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	    @Override
	    protected void configure( HttpSecurity http ) throws Exception{
	
	              http.csrf()
	                  .disable()
	                  .authorizeRequests()
	                  .anyRequest()
	                  .authenticated()
	                  .and()
	                  .httpBasic();
	    }
	    
 }


