package org.example.yanacooplife.controller;

import lombok.RequiredArgsConstructor;
import org.example.yanacooplife.dto.LoginDto;
import org.example.yanacooplife.dto.TokenResponseDto;
import org.example.yanacooplife.dto.UserCreateDto;
import org.example.yanacooplife.dto.UserResponseDto;
import org.example.yanacooplife.security.CustomUserDetailsService;
import org.example.yanacooplife.security.JwtUtil;
import org.example.yanacooplife.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@RequestBody UserCreateDto userCreateDto) {
        return ResponseEntity.ok(userService.createUser(userCreateDto));
    }

    public ResponseEntity<TokenResponseDto> login(@RequestBody LoginDto loginDto){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.email(),
                        loginDto.password()
                )
        );

        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginDto.email());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new TokenResponseDto(jwt));
    }


}
