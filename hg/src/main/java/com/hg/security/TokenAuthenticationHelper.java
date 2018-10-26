package com.hg.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static java.util.Collections.emptyList;

/**
 * @Auther: Xiaochuan Wang
 * @Date: 2018/9/26 18:53
 * @Description:
 */


class TokenAuthenticationHelper {
    /**
     * Token expiration time: 2 hours
     */
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 2L;
    private static final String SECRET = "ThisIsASecret";
    private static final String COOKIE_BEARER = "cookie-bearer";

    static void addAuthentication(HttpServletRequest req, HttpServletResponse res, String username) {
        String jwt = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        Cookie cookie = new Cookie(COOKIE_BEARER, jwt);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        res.addCookie(cookie);
        res.addHeader(COOKIE_BEARER, jwt);
    }

    private static String getTokenFromHeader(HttpServletRequest request) {
        return request.getHeader(COOKIE_BEARER);
    }

    static Authentication getAuthentication(HttpServletRequest request) {
        String token = null;
        Cookie cookie = WebUtils.getCookie(request, COOKIE_BEARER);
        if (cookie != null) {
            token = cookie.getValue();
        }

        token = getTokenFromHeader(request);

        if (token != null) {
            String userName = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
            return userName != null ? new UsernamePasswordAuthenticationToken(userName, null, emptyList()) : null;
        }
        return null;
    }
}