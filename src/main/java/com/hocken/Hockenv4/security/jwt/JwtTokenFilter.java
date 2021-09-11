package com.hocken.Hockenv4.security.jwt;

import com.hocken.Hockenv4.security.services.UsuarioDetailImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*Valida token*/
public class JwtTokenFilter extends OncePerRequestFilter {
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    UsuarioDetailImpl usuarioDetail;

    private final static Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
    try{
    String token = getToken(req);
    if(token !=null && jwtProvider.validateToken(token)){
        String correo = jwtProvider.getusuarioFromToken(token);
        UserDetails userDetails = usuarioDetail.loadUserByUsername(correo);
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null,
                userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
    }catch(Exception e){
        logger.error("Error en método do filter :c" + e.getMessage());
    }
    filterChain.doFilter(req,res);
    }
    private String getToken(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        if(header != null && header.startsWith("Bearer")){
            return header.replace("Bearer", "");
        }
        return null;
    }
}
