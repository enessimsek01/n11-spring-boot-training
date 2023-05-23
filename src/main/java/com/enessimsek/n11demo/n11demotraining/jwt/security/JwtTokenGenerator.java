package com.enessimsek.n11demo.n11demotraining.jwt.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

public class JwtTokenGenerator {

    @Value("${com.enessimsek.n11demo.n11demotraining.jwt.security.app.key}")
    private String APP_KEY;
    @Value("${com.enessimsek.n11demo.n11demotraining.jwt.security.expire.time}")
    private Long EXPIRE_TIME;


//    public String generateJwtToken(Authentication authentication){
//
//    }
}
