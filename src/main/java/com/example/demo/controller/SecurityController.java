package com.example.demo.controller;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/login") //configのloginPageでloginに来るように指定したので
    public String login() {
    	/*
    	// パスワード暗号化のコード例
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = "12345678";
        String encodedPassword = passwordEncoder.encode(password);

        System.out.println();
        System.out.println("Password is         : " + password);
        System.out.println("Encoded Password is : " + encodedPassword);
        System.out.println();

        boolean isPasswordMatch = passwordEncoder.matches(password, encodedPassword);
        System.out.println("Password : " + password + "   isPasswordMatch    : " + isPasswordMatch);
    	// パスワード暗号化のコード例 end   
        */
        return "login";
    }

    @GetMapping("/hello") //configのdefaultSuccessUrlでhelloに来るように指定したので
    public String hello(Authentication loginUser, Model model) {

        /*AuthenticationでログインUserの情報を使うことができるので
        modelを使って、"username"にusernameを詰める*/

        model.addAttribute("username", loginUser.getName());

        return "hello";
    }

}