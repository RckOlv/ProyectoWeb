package com.proyectoweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()  // Permitir acceso a recursos estáticos
                .requestMatchers("/admin/**").hasRole("ADMIN")  // Solo ADMIN puede acceder
                .requestMatchers("/user/**").hasRole("USER")  // Solo USER puede acceder
                .requestMatchers("/", "/products", "/cart", "/login", "/register").permitAll()  // Permitir acceso a páginas públicas
                .anyRequest().authenticated()  // Todas las demás URLs requieren autenticación
            .and()
            .formLogin()
                .loginPage("/login")  // Página de login personalizada
                .defaultSuccessUrl("/", true) // Redirigir al inicio después del login exitoso
                .failureUrl("/login?error=true")  // URL a la que se redirige en caso de error
                .permitAll()
            .and()
            .logout()
                .permitAll();

        return http.build();
    }

    @Bean
    public UserDetailsManager userDetailsManager() {
        UserDetails user = User.withUsername("user")
                .password("{noop}password")
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password("{noop}admin")
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}
