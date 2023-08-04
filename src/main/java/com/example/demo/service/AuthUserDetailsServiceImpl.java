package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.auth.AuthUserDetails;
import com.example.demo.entity.LoginUser;
import com.example.demo.entity.LoginUserMapper;

import lombok.RequiredArgsConstructor;

// UserDetailsService 拡張認証用サービスクラス

@RequiredArgsConstructor
@Service
public class AuthUserDetailsServiceImpl implements UserDetailsService {

    @Autowired 
    private LoginUserMapper loginUserMapper;

    // loadUserByUsername のオーバーライド UserDetails オブジェクトを返却する
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
    	//System.out.println("===========");
    	//System.out.println(username);
        //findByUsernameで見つけてきたユーザ情報
        LoginUser loginUser = loginUserMapper.findByUsername(username);
        //System.out.println("===========");
        //System.out.println(loginUser);
        
    	AuthUserDetails user = new AuthUserDetails(loginUser);
    	//System.out.println(user);
		return user;

    }
}
