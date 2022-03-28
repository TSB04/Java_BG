package com.estiam.gestion.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig /*extends WebSecurityConfigurerAdapter*/{
//	
//	@Autowired
//	private DataSource dataSource;
//	
//	@Bean
//	private PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth
////			.inMemoryAuthentication()
////			.withUser("Tsb")
////			.password("123")
////			.roles("ADMIN")
////			.and()
////			.withUser("Ben")
////			.password("456")
////			.roles("BANQUIER");
//			.jdbcAuthentication()
//			.dataSource(dataSource)
//			.passwordEncoder(passwordEncoder())
//			.usersByUsernameQuery("select pseudo, password, true from utilisateur where pseudo =?")
//			.authoritiesByUsernameQuery("select utilisateur_pseudo, roles_role from users_roles where utilisateur_pseudo =?")
//			.rolePrefix("ROLE_");
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.authorizeRequests()
//			.antMatchers("/",
//						"/static/**",
//						"/css/**",
//						"/js/**",
//						"/img/**").permitAll()
//			.antMatchers("/login").permitAll()
//			.antMatchers("/inscription").permitAll()
//			.antMatchers("/clients/*").hasRole("ADMIN")
//			.antMatchers("/operation/*").hasRole("BANQUIER")
//			.anyRequest().authenticated()
//			.and()
//				.csrf().disable()
//				.formLogin()
//				.loginPage("/login")
//				.permitAll()
//				.defaultSuccessUrl("/home")
//				.failureUrl("/fail")
//			.and()
//				.logout()
//				.invalidateHttpSession(true)
//				.logoutUrl("/logout")
//				.permitAll()
//				.logoutSuccessUrl("/home");
//		
//	}
//	
	

}
