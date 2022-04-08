package com.edu.SpringBootHotelReservationApp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import com.edu.SpringBootHotelReservationApp.serviceImpl.MyUserDetailsService;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
		public UserDetailsService userDetailsService() {
			return new MyUserDetailsService();
		
		}
	
	@Bean
		public NoOpPasswordEncoder passwordEncoder() {
			return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
		 
		}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
	DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	authProvider.setUserDetailsService(userDetailsService());
	authProvider.setPasswordEncoder(passwordEncoder());
	
	return authProvider ;

	}

	@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
		}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.csrf().disable()

		.authorizeRequests()
		.antMatchers("/admin/*").hasAuthority("ROLE_ADMIN")
		.antMatchers("/user/*").hasAuthority("ROLE_USER")
		
		.antMatchers("/").permitAll()// index.html
		//.antMatchers("/**").authenticated()

		.and().httpBasic()
		
		.and().formLogin()
		 .permitAll()
		.and().logout()
		.logoutSuccessUrl("/")
		.permitAll()
		
		;

	}

		
}
