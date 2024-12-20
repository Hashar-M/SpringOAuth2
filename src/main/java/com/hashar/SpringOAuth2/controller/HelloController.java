package com.hashar.SpringOAuth2.controller;

import com.hashar.SpringOAuth2.utils.SecurityUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    @GetMapping
    public ResponseEntity<String> greeting(HttpServletRequest request){
        System.out.println("\nrequest details: ");
        System.out.println(request.getAuthType());
        System.out.println(request.getRequestedSessionId());
        System.out.println(request.getSession().getId());
        return new ResponseEntity<String>("welcome to OAuth2",HttpStatus.OK);
    }
}

