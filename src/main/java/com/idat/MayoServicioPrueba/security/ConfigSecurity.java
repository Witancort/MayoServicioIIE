package com.idat.MayoServicioPrueba.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;




@Configuration
@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfigurerAdapter{
	
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Diandra").password(encriptado().encode("123")).roles("ADMIN");
		auth.inMemoryAuthentication().withUser("estudiante").password(encriptado().encode("123")).roles("ESTUDIANTE");
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/producto/v1/**").access("hasRole('ADMIN')")
		.and()
		.httpBasic()
		.and()
		.csrf().disable();
		
		
	}
	
	@Bean
	public PasswordEncoder encriptado() {
		
		return new BCryptPasswordEncoder();
	}	

}
