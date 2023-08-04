package com.example.demo.auth;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.LoginUser;

// UserDetailsを継承して定義
public class AuthUserDetails implements UserDetails {

	// 認証するユーザー情報
	private final LoginUser loginUser;
	private final Collection<? extends GrantedAuthority> authorities;
	
	// コンストラクタ 認証したい任意のユーザー情報を指定
	public AuthUserDetails(LoginUser loginUser) {
		// ここでユーザー情報を持たせる
		this.loginUser = loginUser;
		// 仮の処理
		List<String> list = new ArrayList<String>(Arrays.asList(loginUser.getUsername()));
		this.authorities = list
				.stream()
				.map(role -> new SimpleGrantedAuthority(role))
				.toList();
	}
	
	// テンプレート内で ${#authentication.principal.loginUser} アクセスできるようにするため
	public LoginUser getLoginUser() {
		return loginUser;
	}
	
	// 各メソッドをオーバーライド Booleanはすべてtrueで
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO 自動生成されたメソッド・スタブ
		//return null;
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO 自動生成されたメソッド・スタブ
		//return null;
		return loginUser.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO 自動生成されたメソッド・スタブ
		//return null;
		return loginUser.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO 自動生成されたメソッド・スタブ
		//return false;
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO 自動生成されたメソッド・スタブ
		//return false;
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO 自動生成されたメソッド・スタブ
		//return false;
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO 自動生成されたメソッド・スタブ
		//return false;
		return true;
	}

}
