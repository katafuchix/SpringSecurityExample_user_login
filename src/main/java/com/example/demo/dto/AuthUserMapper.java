package com.example.demo.dto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

// 認証用ユーザーのマッパー

@Mapper
public interface AuthUserMapper {

    //select文。userテーブルから、usernameが一致しているものを検索
    @Select("select * from loginuser where username = #{username}")
    public AuthUser findByUsername(String username);//識別する

}
