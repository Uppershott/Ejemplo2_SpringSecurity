package com.nttdata.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsService udsi;
	
	@Override //sobreescribe el método
	protected void configure(HttpSecurity http) throws Exception {
		//antMatchers indica los permisos a qué rutas tengan permisos
		//permitAll() para permitir a todos los roles
		http.authorizeRequests()
		.antMatchers("/usuario/crear", "/registro", "/", "/usuario/loginJsp", "/home").permitAll().anyRequest().authenticated()
		//.hasRole("USER")
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.and()
		.logout();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(udsi).passwordEncoder(passwordEncoder());
	}
}
