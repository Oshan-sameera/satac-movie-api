package oshcoding.com.security;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	  @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication()
	                .withUser("user")
	                .password("123")
	                .roles("USER");
	    }
	  
	  @Bean
	    public PasswordEncoder getPasswordEEncorder(){
	        return NoOpPasswordEncoder.getInstance();
	    }


	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	       http.cors().and().csrf().disable()
	                .authorizeRequests()
	                .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
	                .anyRequest().authenticated()
	                .and()
	                .httpBasic();
	   
	    }
	
}
