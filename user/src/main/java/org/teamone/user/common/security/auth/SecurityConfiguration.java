package org.teamone.user.common.security.auth;

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
import org.teamone.user.command.Application.service.UserAuthService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private UserAuthService userAuthService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private Environment env;

    @Autowired
    public SecurityConfiguration(UserAuthService userAuthService, BCryptPasswordEncoder bCryptPasswordEncoder, Environment env) {
        this.userAuthService = userAuthService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.env = env;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userAuthService).passwordEncoder(bCryptPasswordEncoder);
//
//        AuthenticationManager authenticationManager = authenticationManagerBuilder.build();

        http
                .authorizeHttpRequests((authorize) -> authorize

                        // 경로가 /auth 인 경우 인증 요청 X
                        .requestMatchers(new AntPathRequestMatcher("/auth/**")).permitAll()

                        // 외의 모든 요청에 대해 인증 요구
                        .anyRequest().authenticated()
                )
                // session이 아닌 jwt를 이용해 로그인을 할 것이므로 CSRF 처리 off
                .csrf((csrf) -> csrf.disable())
                // 세션 관리를 상태 없이 설정합니다.
                .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        // 로그인 페이지 경로 변경
        http
                .formLogin(auth -> auth
                        .loginPage("/auth/login")
                        .permitAll());

        return http.build();
    }
}
