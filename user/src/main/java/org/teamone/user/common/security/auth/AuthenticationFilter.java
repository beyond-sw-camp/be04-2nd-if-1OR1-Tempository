package org.teamone.user.common.security.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.teamone.user.query.domainData.vo.RequestLogin;
import org.teamone.user.query.dto.QueryUserDTO;
import org.teamone.user.query.service.QueryUserAuthService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private QueryUserAuthService queryUserAuthService;
    private Environment environment;

    public AuthenticationFilter(AuthenticationManager authenticationManager, QueryUserAuthService queryUserAuthService
                                , Environment environment) {
        super(authenticationManager);
        this.queryUserAuthService = queryUserAuthService;
        this.environment = environment;
    }

    /* 설명. 로그인 시도 시 동작하는 기능(POST방식의 /login 요청) -> request body에 담겨 온다.(stream 활용) */
    /* 설명. service 계층 손보러 가자(우리의 Service 클래스를 UserDetailsService로 만들기(Service interface로 이동) */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        try {
            RequestLogin requestLogin =
                    new ObjectMapper().readValue(request.getInputStream(), RequestLogin.class);

            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            requestLogin.getEmail(), requestLogin.getPassword(), new ArrayList<>()
                    )
            );
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }
    /* 설명. 로그인 성공 시 JWT 토큰 생성하는 기능 */
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        String userEmail = ((User) authResult.getPrincipal()).getUsername();

        /* 설명. DB를 다녀와 사용자의 고유 아이디(userId)를 가져올 예정(Principal 객체(Authentication)에는 없는 값이므로) */
        QueryUserDTO userDetails = queryUserAuthService.getUserDetailsByEmail(userEmail);
        String userId = userDetails.getUserId();

        String token = Jwts.builder()
                .setSubject(userId)
                .setExpiration(new Date(System.currentTimeMillis()
                        + Long.valueOf(environment.getProperty("token.expiration_time"))))
                .signWith(SignatureAlgorithm.HS512, environment.getProperty("token.secret"))
                .compact();

        response.addHeader("token", token);
        response.addHeader("userId", userId);
        response.addHeader("userEmail", userEmail);
    }
}
