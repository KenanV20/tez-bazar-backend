package com.ads.advertisement.service.auth;

import com.ads.advertisement.dao.entity.UserEntity;
import com.ads.advertisement.dao.repository.UserRepository;
import com.ads.advertisement.dto.AuthenticationDto;
import com.ads.advertisement.dto.requests.AuthRequestDto;
import com.ads.advertisement.dto.requests.UserRegisterRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;
    public AuthenticationDto register(UserRegisterRequestDto requestDto) {
        //TODO: unique check exception
        var user = UserEntity.builder()
                .fullName(requestDto.getFullName())
                .phoneNumberOne(requestDto.getPhoneNumberOne())
                .email(requestDto.getEmail())
                .gender(requestDto.getGender())
                .password(passwordEncoder.encode(requestDto.getPassword()))
                .build();

        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationDto.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationDto authenticate(AuthRequestDto authRequestDto) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequestDto.getEmail(),
                        authRequestDto.getPassword()
                )
        );

        UserEntity user = userRepository.findUserByEmail(authRequestDto.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationDto.builder()
                .token(jwtToken)
                .build();
    }
}