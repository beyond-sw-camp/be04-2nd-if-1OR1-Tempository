package org.teamone.user.common.security.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    // application.properties에서 설정한 jwt.public.key와 jwt.private.key 값을 가져옵니다.
//    @Value("${jwt.public.key}")
//    RSAPublicKey key;
//
//    @Value("${jwt.private.key}")
//    RSAPrivateKey priv;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
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
