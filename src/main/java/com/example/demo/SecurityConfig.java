package com.example.demo;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean //パスワードのエンコード
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    
		//ログイン処理の実装
		http.formLogin(login -> login //フォーム認証の設定
		    .loginProcessingUrl("/login") //ログイン処理のパス
			.loginPage("/login") //ログインページの指定
			.defaultSuccessUrl("/hello") //ログイン成功後の遷移先（任意で「/hello」とする）
			.failureUrl("/login?error=true") //ログイン失敗時の遷移先（任意で「/login?error」とする）
			.permitAll()
		).logout(logout -> logout //ログアウトの設定記述開始
			.logoutSuccessUrl("/login") //ログアウト成功後のリダイレクト先URL
		).authorizeHttpRequests(authz -> authz //URLごとの認可設定
			.requestMatchers(PathRequest.toStaticResources().atCommonLocations())
			.permitAll() //css,jsなどへのアクセス許可
		    .anyRequest().authenticated() //ログインページ以外のURLへはログイン後のみアクセス可能
		);
		
		return http.build();
	}
}