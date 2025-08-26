package com.url.url_shortner_sb.security.jwt;


import lombok.Data;

@Data

public class JwtAuthenticationResponse {
    private String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }
}
