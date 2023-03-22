package com.notas.ufg.security.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.notas.ufg.repocitorio.login.AdminRepoImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{


    String[] resources = new String[]{
            "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"
    };
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
	        .antMatchers(resources).permitAll()
	        .antMatchers("/recuperar").permitAll()
	        .antMatchers("/recuperar/{error}*").permitAll()
	        .antMatchers("/Recucon").permitAll()
	        .antMatchers("/enviarcon").permitAll()
	        .antMatchers("/","/index").permitAll()
	        .antMatchers("/indexA*").hasAnyRole("ADMIN","MAESTRO")
	        .antMatchers("/secciones*").access("hasRole('ADMIN')")
	        .antMatchers("/alumnos*").access("hasRole('ADMIN')")
	        .antMatchers("/notasm*").hasAnyRole("ADMIN","MAESTRO")
	        .antMatchers("/administradores*").access("hasRole('ADMIN')")
	        .antMatchers("/NuevaA*").access("hasRole('ADMIN')")
	        .antMatchers("/maestros*").access("hasRole('ADMIN')")
	        .antMatchers("/Nuevam*").access("hasRole('ADMIN')")
	        .antMatchers("/NuevaAlm*").access("hasRole('ADMIN')")
	        .antMatchers("/editars/{id}*").access("hasRole('ADMIN')")
	        .antMatchers("/NuevaS*").access("hasRole('ADMIN')")
	        .antMatchers("/NuevaS*").access("hasRole('ADMIN')")
	        .antMatchers("/eliminars/{id}*").access("hasRole('ADMIN')")
	        .antMatchers("/editarAl/{id}*").access("hasRole('ADMIN')")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/indexA")
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
            .logout()
                .permitAll()
                .logoutSuccessUrl("/login?logout");
    }
    BCryptPasswordEncoder bCryptPasswordEncoder;	
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        return bCryptPasswordEncoder;
    }
	
    @Autowired
    AdminRepoImpl userDetailsService;
	

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 

        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());     
    }
}