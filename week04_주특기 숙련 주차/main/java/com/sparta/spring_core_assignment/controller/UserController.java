package com.sparta.spring_core_assignment.controller;

import com.sparta.spring_core_assignment.dto.UserDto;
import com.sparta.spring_core_assignment.security.UserDetailsImpl;
import com.sparta.spring_core_assignment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 로그인 페이지
    @GetMapping("/user/login")
    public String login() {
        return "login";
    }

    // 로그인 정보 받기
    @PostMapping("/user/userinfo")
    @ResponseBody
    public String getUserInfo(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        String username = userDetails.getUser().getUsername();
        return username;
    }

    // 회원가입 페이지
    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }

    // 회원가입
    @PostMapping("/user/signup")
    public String registerUser(UserDto requestDto) {
        userService.registerUser(requestDto);
        return "redirect:/user/login";
    }
}
