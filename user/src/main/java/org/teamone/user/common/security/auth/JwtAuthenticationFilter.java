package org.teamone.user.common.security.auth;

import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.teamone.user.query.service.QueryUserAuthService;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final QueryUserAuthService queryUserAuthService;
    private final Environment environment;

    @Autowired
    public JwtAuthenticationFilter(QueryUserAuthService queryUserAuthService,
                                   Environment environment) {
        this.queryUserAuthService = queryUserAuthService;
        this.environment = environment;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // 요청 헤더에서 토큰을 가져옵니다.
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        // 토큰이 있는지 및 형식이 올바른지 확인합니다.
        if (token != null && token.startsWith("Bearer ")) {
            try {
                // 토큰을 검증하고 페이로드에서 사용자 이메일을 추출합니다.
                String userId = Jwts.parser()
                        .setSigningKey(environment.getProperty("token.secret"))
                        .parseClaimsJws(token.replace("Bearer ", ""))
                        .getBody()
                        .getSubject();

                // userId를 기반으로 사용자 정보를 조회합니다.
                UserDetails userDetails = queryUserAuthService.loadUserByUserId(userId);

                // 사용자 정보를 기반으로 인증 토큰을 생성합니다.
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                // SecurityContext에 인증 정보를 설정합니다.
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (Exception e) {
                // 토큰이 유효하지 않은 경우 처리합니다.
                // 여기서는 간단히 로그를 출력하고 무시합니다. 필요에 따라 다른 처리 방법을 선택할 수 있습니다.
                System.out.println("Invalid token: " + e.getMessage());
            }
        }

        // 다음 필터로 요청을 전달합니다.
        filterChain.doFilter(request, response);
    }
}
