package org.example.rayanpardaz.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.example.rayanpardaz.exceptionHandler.InvalidCredentialsException;
import org.example.rayanpardaz.model.User;
import org.example.rayanpardaz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class AuthController {

    private UserService userService;

    @Value("${token.validity.duration}")
    private long TOKEN_VALIDITY_DURATION;

    @Value("${secret.key}")
    private String SECRET_KEY;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) throws InvalidCredentialsException {
        User user = userService.findByUserName(loginRequest);
        if (user != null) {
            return this.generateToken(user);
        }
        throw new InvalidCredentialsException("Username or password is wrong!!");
    }

    private String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getUserName())
                .claim("name", user.getName())
                .claim("familyName", user.getFamilyName())
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY_DURATION))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }
}
