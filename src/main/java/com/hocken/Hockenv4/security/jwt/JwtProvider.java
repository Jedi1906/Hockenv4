package com.hocken.Hockenv4.security.jwt;

import com.hocken.Hockenv4.security.entity.UsuarioPrincipal;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/*Genera token*/
@Component
public class JwtProvider {

    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
        @Value("${jwt.secret}")
        private String secret;
        @Value("${jwt.expiration}")
        private int expiration;
    public String generateToken(Authentication authentication){
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
        int id = usuarioPrincipal.getId();
        String nombre = usuarioPrincipal.getNombre();
        List<String> roles = usuarioPrincipal.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
    return Jwts.builder().setSubject(usuarioPrincipal.getUsername())
            .claim("nombre",nombre)
            .claim("roles",roles)
            .claim("id",id)
            .setIssuedAt(new Date())
            .setExpiration
            (new Date(new Date().getTime() + expiration * 1000)).signWith(SignatureAlgorithm.HS512,secret.getBytes()).compact();
    }
    public String getusuarioFromToken(String token){
        return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody().getSubject();
    }
    public boolean validateToken(String token){
       try{
            Jwts.parser().setSigningKey(secret.getBytes()   ).parseClaimsJws(token);
            return true;
       }catch (MalformedJwtException e){
        logger.error("Token mal formado");
       }catch (UnsupportedJwtException e){
           logger.error("Token no soportado");
       }catch (ExpiredJwtException e){
           logger.error("Token expiro");
       }catch (IllegalArgumentException e){
           logger.error("Token vacio");
       }catch (SignatureException e){
           logger.error("firma erronea");
       }
       return false;
    }

}
