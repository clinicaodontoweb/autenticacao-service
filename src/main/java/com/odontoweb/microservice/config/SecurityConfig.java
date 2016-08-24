package com.odontoweb.microservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.odontoweb.arquitetura.security.AuthenticationTokenFilter;
import com.odontoweb.arquitetura.security.EntryPointUnauthorizedHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean
	public EntryPointUnauthorizedHandler entryPointUnauthorizedHandler(){
		return new EntryPointUnauthorizedHandler();
	}
	
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	@Bean
	public AuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
		AuthenticationTokenFilter authFilter = new AuthenticationTokenFilter();
		authFilter.setAuthenticationManager(authenticationManager());

		return authFilter;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.exceptionHandling().authenticationEntryPoint(entryPointUnauthorizedHandler())
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeRequests()
			.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
			.antMatchers("/auth/**").permitAll()
			.antMatchers("/roles**").permitAll()
			.anyRequest().authenticated();
		
		http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
	}
}
