package com.example.todo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))  // CORS設定の適用
                .csrf(csrf -> csrf
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())  // CSRFトークンの設定
                        .ignoringRequestMatchers("/api/csrf_token", "/api/signup", "/api/login")  // 特定のエンドポイントを除外
                )
                // TODO: 「"/api/signup", "/api/login"」以外は認証必要ありに変更する（現時点では認証機能を未実装のため追加している）
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/csrf_token", "/api/signup", "/api/login","/api/todos","/api/todos/**").permitAll() // これらのエンドポイントを認証不要に設定
                        .anyRequest().authenticated() // 他のすべてのリクエストを認証が必要
                );

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:3000");  // 許可するオリジンを指定
        configuration.addAllowedMethod("*");  // 許可するHTTPメソッドを指定
        configuration.addAllowedHeader("*");  // 許可するヘッダーを指定
        configuration.setAllowCredentials(true);  // クッキーを許可

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}