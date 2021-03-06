package net.timeline.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/**")
				.authorizeRequests()
				.antMatchers("/","/css/**", "/js/**", "/img/**", "/lib/**","/h2-console/**","/favicon.ico","/users/**","/swagger-ui.html").permitAll()
				.anyRequest().authenticated()
				.and().formLogin().loginPage("/users/loginForm").permitAll()
				.and().logout().logoutSuccessUrl("/").permitAll()
				.and().headers().frameOptions().sameOrigin()
                .and().csrf().disable();
	}
	
	

}
