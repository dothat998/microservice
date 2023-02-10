package com.spring.security.jwt;

import com.spring.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Tim kiem token trong request
 */
public class JwtTokenFilter extends OncePerRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;

    /**
     * Chặn và kiểm tra request cần xác thực có jwt hợp lệ hay ko
     *
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = getJwt(request, jwtProvider); //lay token tu request ra
            if (jwt != null && jwtProvider.validationToken(jwt)) {
                String username = jwtProvider.getUsernameFromJwtToken(jwt);
                UserDetails userDetails = userService.loadUserByUsername(username); //truyen vao user detail he thong
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); //set token len web
                SecurityContextHolder.getContext().setAuthentication(authentication); // xac nhan token
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        filterChain.doFilter(request, response);
    }

    /**
     * Lay token tren request
     *
     * @param request
     * @param jwtConfig
     * @return
     */
    public static String getJwt(HttpServletRequest request, JwtProvider jwtConfig) {
        String jwtHeader = request.getHeader(jwtConfig.getHeader());
        if (jwtHeader != null && jwtHeader.startsWith(jwtConfig.getPrefix())) {
            return jwtHeader.replace(jwtConfig.getPrefix() + " ", "");
        }
        return null;
    }
}
