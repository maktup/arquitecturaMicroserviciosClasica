package pe.com.capacitacion;
 
import de.codecentric.boot.admin.server.config.AdminServerProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

/**
 * WebSecurityConfig
 * @author cguerra
 **/
 @Configuration
 public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	    private String adminContextPath;
	    
	    public WebSecurityConfig( AdminServerProperties adminServerProperties ){
	           this.adminContextPath = adminServerProperties.getContextPath();
	    }
	
	    @Override
	    protected void configure( HttpSecurity http ) throws Exception{
	    	
	        SavedRequestAwareAuthenticationSuccessHandler objHandler = new SavedRequestAwareAuthenticationSuccessHandler(); 
	        objHandler.setTargetUrlParameter( "redirectTo" );
	 
	        http.authorizeRequests()
	            .antMatchers( this.adminContextPath + "/assets/**" ).permitAll()
	            .antMatchers( this.adminContextPath + "/login" ).permitAll()
	            //.anyRequest().authenticated()
	            .and()
	            .formLogin().loginPage( this.adminContextPath + "/login" ).successHandler( objHandler ).and()
	            .logout().logoutUrl( this.adminContextPath + "/logout" ).and()
	            .httpBasic().and()
	            .csrf().disable(); 
	    }
    
 }

 