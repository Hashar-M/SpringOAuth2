package com.hashar.SpringOAuth2.controller;

import com.hashar.SpringOAuth2.utils.SecurityUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/user-info")
    public Map<String, Object> getUserInfo() {
        OAuth2User oAuth2User = SecurityUtils.getCurrentUser();
        if(oAuth2User != null){
            return oAuth2User.getAttributes();
        }
        throw new RuntimeException("User not authenticated");
    }
    @PostMapping("/logout-api")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        // Clear authentication from the security context
        SecurityContextHolder.clearContext();

        // Invalidate the HTTP session
        request.getSession().invalidate();

//        // Optionally delete cookies (like JSESSIONID)
//        javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("JSESSIONID", null);
//        cookie.setMaxAge(0);
//        cookie.setPath("/");
//        response.addCookie(cookie);

        return "User logged out successfully";
    }


}
