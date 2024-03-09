package org.teamone.user.common.security.auth;

import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.teamone.user.query.service.QueryUserAuthService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final QueryUserAuthService queryUserAuthService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private Environment env;

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    public SecurityConfiguration(QueryUserAuthService queryUserAuthService,
                                 BCryptPasswordEncoder bCryptPasswordEncoder,
                                 Environment env, JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.queryUserAuthService = queryUserAuthService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.env = env;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(queryUserAuthService).passwordEncoder(bCryptPasswordEncoder);

        AuthenticationManager authenticationManager = authenticationManagerBuilder.build();

        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);


        http.csrf((csrf) -> csrf.disable());
        http
                .authorizeHttpRequests((auth) -> auth
                                .requestMatchers(new AntPathRequestMatcher("/auth/**")).permitAll()
                                .anyRequest().authenticated()
                )
                .authenticationManager(authenticationManager)

                // 세션 관리를 상태 없이 설정
                .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilter(getAuthenticationFilter(authenticationManager));

        return http.build();
    }

    private Filter getAuthenticationFilter(AuthenticationManager authenticationManager) {
        return new AuthenticationFilter(authenticationManager, queryUserAuthService, env);
    }
}
