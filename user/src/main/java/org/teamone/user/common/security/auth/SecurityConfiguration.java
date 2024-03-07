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
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.teamone.user.command.Application.service.CommandUserAuthService;
import org.teamone.user.query.service.QueryUserAuthService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private CommandUserAuthService commandUserAuthService;
    private QueryUserAuthService queryUserAuthService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private Environment env;

    @Autowired
    public SecurityConfiguration(CommandUserAuthService commandUserAuthService,
                                 QueryUserAuthService queryUserAuthService,
                                 BCryptPasswordEncoder bCryptPasswordEncoder,
                                 Environment env) {
        this.commandUserAuthService = commandUserAuthService;
        this.queryUserAuthService = queryUserAuthService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.env = env;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        AuthenticationManagerBuilder commandAuthenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        commandAuthenticationManagerBuilder.userDetailsService(commandUserAuthService).passwordEncoder(bCryptPasswordEncoder);

        AuthenticationManagerBuilder queryAuthenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        queryAuthenticationManagerBuilder.userDetailsService(queryUserAuthService).passwordEncoder(bCryptPasswordEncoder);

        AuthenticationManager authenticationManager = queryAuthenticationManagerBuilder.build();

        http.csrf((csrf) -> csrf.disable());
        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers(new AntPathRequestMatcher("/auth/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/error")).permitAll()
                        .anyRequest().authenticated()
                )
                .authenticationManager(authenticationManager);
//                // 세션 관리를 상태 없이 설정
//                .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))



//        // 로그인 페이지 경로 변경
//        http
//                .formLogin(auth -> auth
//                        .loginPage("/auth/login")
//                        .permitAll());

        http.addFilter(getAuthenticationFilter(authenticationManager));

        return http.build();
    }

    private Filter getAuthenticationFilter(AuthenticationManager authenticationManager) {
        return new AuthenticationFilter(authenticationManager, queryUserAuthService, env);
    }
}
