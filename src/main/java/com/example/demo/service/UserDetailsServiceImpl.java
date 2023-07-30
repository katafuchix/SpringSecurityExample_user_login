package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AuthUser;
import com.example.demo.dto.AuthUserMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired //mapperをインスタンス化。DB接続をするMapperクラスを参照
    private AuthUserMapper authUserMapper;

    //loadUserByUsernameは実装が必要
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	/*
    	System.out.println("===========");
    	System.out.println(username);
        //findByUsernameで見つけてきたユーザ情報をmyUserに入れる
        AuthUser authUser = authUserMapper.findByUsername(username);
        System.out.println("===========");
        System.out.println(authUser);
        //UserDetailsにreturn
        return authUser;
    	 */
		AuthUser authUser = authUserMapper.findByUsername(username);
		System.out.println("===========");
        System.out.println(authUser);
		return authUser;

    }
}
