package com.hexaware.QuitQ.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.QuitQ.DTO.JWTAuthResponse;
import com.hexaware.QuitQ.DTO.LoginDto;
import com.hexaware.QuitQ.DTO.UserDTO;
import com.hexaware.QuitQ.service.AuthService;
//AuthController.java

@RestController
@RequestMapping("/api/authenticate")
@CrossOrigin("http://localhost:3000")
public class AuthController {
 private AuthService authService;

 public AuthController(AuthService authService) {
     this.authService = authService;
 }

 @PostMapping("/logout")
 public ResponseEntity<String> logout(@RequestHeader("Authorization") String token) {
     if (token == null || !token.startsWith("Bearer ")) {
    	 if(token==null)System.out.println("token is null");
    	 if(!token.startsWith("Bearer "))System.out.println("not start with bearer" + token);
         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No user logged in");
     }

     String authToken = token.substring(7);
     boolean isValidToken = authService.validateToken(authToken);

     if (isValidToken) {
         authService.logout();
         return ResponseEntity.ok("Logged out successfully");
     } else {
         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No user logged in");
     }
 }

 @PostMapping(value = {"/login","/signin"})
 public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDto dto) {
     JWTAuthResponse token = authService.login(dto);
     return ResponseEntity.ok(token);
 }

 @PostMapping(value = {"/register","/signup"})
 public ResponseEntity<String> register(@RequestBody UserDTO dto) {
     String value = authService.register(dto);
     return new ResponseEntity<>(value, HttpStatus.CREATED);
 }
}
