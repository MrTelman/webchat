package com.example.webchat.handlers;

import com.example.webchat.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {

        handle(request, response, authentication);
        clearAuthenticationAttributes(request);

    }

    protected void handle(HttpServletRequest request,
                          HttpServletResponse response, Authentication authentication)
            throws IOException {
        response.setStatus(HttpStatus.OK.value());
        /**
         * this changes in db field active to true by login
         * still has no clue how to change this value after logout
         */
        userRepository.markAsActive(authentication.getName());
        response.getWriter().flush();
        response.getWriter().close();
    }

    protected void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
}
