package com.givemewish.giftweb.controller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    public void onAuthenticationSuccess(HttpServletRequest req,
            HttpServletResponse resp, Authentication auth) throws IOException,
            ServletException {
        Set<String> roles = AuthorityUtils.authorityListToSet(auth.getAuthorities());
        
        if(roles != null && !roles.isEmpty()) {
            resp.sendRedirect(req.getContextPath()+"/user/"+auth.getName());
        } else {
            resp.sendError(404);
        }
    }

}
