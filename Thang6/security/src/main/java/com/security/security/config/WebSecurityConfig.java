package com.security.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {
@Bean
@Override
    public UserDetailsService userDetailsService (){
        InMemoryUserDetailsManager manager = new  InMemoryUserDetailsManager();

        manager.createUser(User.withDefaultPasswordEncoder()
                .username("anh")
                .password("123456")
                .roles("USER")
                .build());
        return manager;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/","home").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin().defaultSuccessUrl("/hello").permitAll()
                .and()
            .logout().permitAll();
    }

}
