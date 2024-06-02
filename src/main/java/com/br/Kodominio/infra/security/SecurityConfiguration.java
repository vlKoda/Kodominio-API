package com.br.Kodominio.infra.security;

import com.br.Kodominio.controllers.AuthenticationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    SecurityFilter securityFilter;


    //configurando as autorizações de todas as roles
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/usuario/cadastrar").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/registerowner").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.GET, "/auth/hello").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/loginowner").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/usuario/editar").permitAll()
                        .requestMatchers(HttpMethod.POST, "/ocorrencia/inserir").hasAnyRole("MORADOR", "PORTEIRO")
                        .requestMatchers(HttpMethod.GET, "/ocorrencia/listar").hasAnyRole("ADMIN", "SINDICO")
                        .requestMatchers(HttpMethod.GET, "/usuario/listar").hasAnyRole("ADMIN", "SINDICO")
                        .requestMatchers(HttpMethod.POST, "/condominio/cadastrar").hasAnyRole("ADMIN", "OWNER")
                        .requestMatchers(HttpMethod.DELETE, "/condominio").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/ocorrencia").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/ocorrencia/status").hasRole("SINDICO")
                        .requestMatchers(HttpMethod.DELETE, "/usuario/deletar").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
