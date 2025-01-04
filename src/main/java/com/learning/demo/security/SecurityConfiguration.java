package com.learning.demo.security;

import com.learning.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
/**
 * @author Igor Adulyan
 * @implNote
 * SecurityConfiguration class
 * completely refactored
 * IMPORTANT:
 * if you are going to use for specific
 * endpoint more than one user role
 * always use hasAnyRole(...)
 * In order to be
 * customizable always with Thymeleaf successForwardUrl(...)
 * method
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private UserServiceImpl userDetailsService;

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userDetailsService); //set the custom user details service
        auth.setPasswordEncoder(passwordEncoder()); //set the password encoder - bcrypt
        return auth;
    }

    //beans
    //bcrypt bean definition
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }


    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(
                        (auth) -> auth
                                .requestMatchers("/", "/login*",
                                        "/css/*", "/js/*", "/sign-up", "/signup-process").permitAll()
                                .requestMatchers("/home").hasAnyRole("USER", "ADMIN")
                                .anyRequest().authenticated()
                                )

                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login") // should point to login page
                        .defaultSuccessUrl("/home") // must be in order thymeleaf security extras work
                        .failureUrl("/login?error=true")
                )
                .logout(
                        logout -> logout
                                .logoutSuccessUrl("/login?logout=true")
                                .invalidateHttpSession(true)
                                .clearAuthentication(true)
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                                .deleteCookies("JSESSIONID"));
                return http.build();
    }
}
