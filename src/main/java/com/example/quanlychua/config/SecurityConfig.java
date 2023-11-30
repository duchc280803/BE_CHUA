package com.example.quanlychua.config;

import com.example.quanlychua.enums.QuyenHanEnums;
import com.example.quanlychua.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationProvider authenticationProvider;

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/api/v1/auth/**"
                        ).permitAll()
                        .requestMatchers(
                                "/api/v1/loai-bai-viet/",
                                "/api/v1/binh-luan/",
                                "/api/v1/like-bai/",
                                "/api/v1/like-binh-luan/**",
                                "/api/v1/phat-tu-dao-trang/**",
                                "/api/user/bai-viet/**",
                                "/api/user/dao-trang/**",
                                "/api/user/don-dang-ky/**"
                        ).hasAnyAuthority(QuyenHanEnums.USER.name())
                        .requestMatchers("/api/v1/chua/**").hasAnyAuthority(
                                QuyenHanEnums.MANAGER_PAGODA.name(),
                                QuyenHanEnums.ADMIN.name())
                        .requestMatchers("/api/v1/bai-viet/**").hasAnyAuthority(
                                QuyenHanEnums.MANAGER_BAI_VIET.name(),
                                QuyenHanEnums.ADMIN.name())
                        .requestMatchers("/api/v1/dao-trang/**").hasAnyAuthority(
                                QuyenHanEnums.MANAGER_ASHRAM.name(),
                                QuyenHanEnums.ADMIN.name())
                        .requestMatchers("/api/v1/don-dang-ky/**").hasAnyAuthority(
                                QuyenHanEnums.MANAGER_DON_DANG_KY.name(),
                                QuyenHanEnums.ADMIN.name())
                        .requestMatchers("/api/v1/phat-tu/**").hasAnyAuthority(
                                QuyenHanEnums.ADMIN.name())
                        .anyRequest()
                        .authenticated())
                .sessionManagement(sessionManager -> sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH"));
        configuration.addAllowedOrigin("*");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
