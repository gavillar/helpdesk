package br.com.helpdesk.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Date;

// Essa classe é responsável por gerar o token de autenticação.

@Component
public class JWTUtil {

    // Armazena o tempo de expiração em ms
    @Value("${jwt.expiration}")
    private Long expiration;

    // Armazena a string secreta
    @Value("${jwt.secret}")
    private String secret;

    // Esse método gera o token após receber o email, recebe a regra da data atual + o tempo expiração,
    // recebe a assinatura do algoritimo, recebe o padrao de token em bytes, e por ultimo compacta,
    // para deixar o jwt, para deixar a api mais performática.
    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
    }
}
