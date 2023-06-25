package com.security2.secuirty2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    @Override
        public UserDetailsService userDetailsService(){
            InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
            userDetailsManager.createUser(User.withDefaultPasswordEncoder().username("anh").password("123456").roles("USERS").build());
            System.out.println(userDetailsManager);
            return userDetailsManager;
        }
        @Override
        protected void configure(HttpSecurity http) throws  Exception{

            http.authorizeRequests().antMatchers("/","/home").permitAll()
                    .anyRequest().authenticated().and()
                    .formLogin().defaultSuccessUrl("/user").permitAll().and()
                    .logout().permitAll();
        }


}
