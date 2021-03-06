package com.adn.ejercicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.adn.ejercicio.services.UsuarioService;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	static final String LOGIN_URL = "/login";
	
	@Autowired
	private UsuarioService userDetailService; 
	
	BCryptPasswordEncoder bcrypt;
	
	String[] resources = new String[]{
            "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"
    };
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		 bcrypt =  new BCryptPasswordEncoder();
		 return bcrypt;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) 
			throws Exception{
		auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
	}

	 @Override
	 protected void configure(HttpSecurity http) throws Exception {
		 http.authorizeRequests()
         .antMatchers(resources).permitAll()
         .antMatchers(LOGIN_URL).permitAll()
         .antMatchers("/mutation/**").permitAll()
         .antMatchers("/cadenaAdn/**").permitAll()
         .anyRequest().authenticated()
         .and()
             .formLogin()
             .loginPage(LOGIN_URL)
             .defaultSuccessUrl("/inicio")
             .failureUrl("/login?error=true")
             .permitAll()
         .and()
             .logout()
             .logoutUrl("/logout")   
             .logoutSuccessUrl(LOGIN_URL)
             .invalidateHttpSession(true)
             .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
             .permitAll()
          .and()
             .csrf()
                 .ignoringAntMatchers("/mutation/**");
	 }

	

}
