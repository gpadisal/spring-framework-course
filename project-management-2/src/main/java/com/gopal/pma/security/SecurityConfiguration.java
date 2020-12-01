package com.gopal.pma.security;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource datasource;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//In-memory authentication
//		auth.inMemoryAuthentication()
//			.withUser("user")
//				.password("pass")
//					.roles("USER").and()
//			.withUser("gopal")
//				.password("pass")
//					.roles("USER").and()
//			.withUser("admin")
//				.password("adminpass")
//					.roles("ADMIN");
		
//		auth.jdbcAuthentication().dataSource(datasource)  // user jdbcAuthenticaiton
//		.withDefaultSchema() // use default schema to store authentication and autherization details
//		//default schema applicable only for H2, default schema will not work Postgres
//		.withUser("user")
//			.password("pass")
//				.roles("USER").and()
//		.withUser("gopal")
//			.password("pass")
//				.roles("USER").and()
//		.withUser("admin")
//			.password("adminpass")
//				.roles("ADMIN");
		
		auth.jdbcAuthentication()
			.usersByUsernameQuery("select username, password, enabled from user_accounts where username = ?")
			.authoritiesByUsernameQuery("select username, role from user_accounts where username = ?")
			.dataSource(datasource)
			.passwordEncoder(bCryptPasswordEncoder);
					
	}
	
	//We need password encoder to encode the password. with out pass encoder , we will get exception
	// There is no PasswordEncoder mapped for the id "null", temporarily create an instance of NoOpPasswordEncoder
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/projects/new").hasRole("ADMIN") // expects ROLE_ADMIN or ROLE_USER , role name prefixed with ROLE_
			.antMatchers("/projects").hasRole("ADMIN")
			.antMatchers("/employees/new").hasRole("ADMIN")
			.antMatchers("/employees").hasRole("ADMIN")			
//			.antMatchers("/employees/new").hasAuthority("ADMIN")
//			.antMatchers("/employees").hasAuthority("ADMIN") // looks for ADMIN or USER in role name field with out ROLE_
//			.antMatchers("/h2_console/**").permitAll()
//			.antMatchers("/").authenticated().and().formLogin();
			.antMatchers("/").permitAll().and()  // permit all means not protected.
			.formLogin();

		
		http.csrf().disable();
		http.headers().frameOptions().disable();
	}
	
}
