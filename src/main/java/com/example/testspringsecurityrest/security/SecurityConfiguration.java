package com.example.testspringsecurityrest.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.testspringsecurityrest.repository.UserRepository;
import com.example.testspringsecurityrest.security.jwt.JWTAuthorizationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private UserPricipleDetailsServices userPriDetails;
	private UserRepository userRepository;

	public SecurityConfiguration(UserPricipleDetailsServices userPriDetails, UserRepository userRepository) {

		this.userPriDetails = userPriDetails;
		this.userRepository = userRepository;
	}

	@Override

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.authenticationProvider(doaAuthProvider());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				// .addFilter(new JWTAuthenticationFilter(authenticationManager()))
				.addFilter(new JWTAuthorizationFilter(authenticationManager(), this.userRepository)).authorizeRequests()
				.antMatchers(HttpMethod.POST, "/signup").permitAll().antMatchers("/api/us").permitAll()
				.antMatchers("/api/add-user", "/api/select-all-user", "/api/select-one-user/{id}",
						"/api/delete-one-user/{id}", "/api/add-role", "/api/update-role", "/api/select-all-role",
						"/api/select-one-role/{id}", "/api/delete-one-role/{id}", "/api/add-auth", "/api/update-auth",
						"/api/select-all-auth", "/api/select-one-auth/{id}", "/api/delete-one-auth/{id}")
				.hasAnyRole("ADMIN", "MANAGER").antMatchers("/profile").hasAnyRole("ADMIN", "MANAGER", "USER")
				.anyRequest().authenticated();
	}

	@Bean(BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {

		return super.authenticationManagerBean();
	}

	@Bean
	DaoAuthenticationProvider doaAuthProvider() {
		DaoAuthenticationProvider daoAu = new DaoAuthenticationProvider();
		daoAu.setPasswordEncoder(passwordEncoder());
		daoAu.setUserDetailsService(userPriDetails);
		return daoAu;
	}

	@Bean
	PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();

	}
}
