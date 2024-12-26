package org.example.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Anna").password("{noop}Anna").authorities("age", "fullname")
                .and()
                .withUser("user").password("{noop}password").roles("READ")
                .and()
                .withUser("dev").password("{noop}devpass").roles("WRITE")
                .and()
                .withUser("admin").password("{noop}pass").roles("DELETE", "WRITE");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .authorizeRequests().antMatchers("/persons/by-city").permitAll()
                .and()
                .authorizeRequests().antMatchers("/persons/by-age").hasAuthority("age")
                .and()
                .authorizeRequests().antMatchers("/persons/by-fullname").hasAuthority("fullname")
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }
}

