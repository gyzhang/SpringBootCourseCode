package com.example.security.db.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.security.db.service.CustomUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}	
	
	@Bean
    UserDetailsService customUserService(){
        return new CustomUserService();
    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserService()); 
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin()
			.loginPage("/login")
			.usernameParameter("login_username")
			.passwordParameter("login_password")
			.failureUrl("/login?error")
			.defaultSuccessUrl("/index")
			.permitAll()
		.and().logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/login?logout")
			.clearAuthentication(true)
			.invalidateHttpSession(true)
			.permitAll()
		.and().authorizeRequests()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/user/**").hasRole("USER")
			.anyRequest()
			.authenticated();
	}
	
	@Override
    public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/config/**", "/css/**", "/images/**", "/js/**");
    }
	
}