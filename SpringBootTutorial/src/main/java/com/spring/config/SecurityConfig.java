package com.spring.config;

import com.sib.co.contants.SibCoConstant;
import com.spring.security.jwt.JwtAuthEntryPoint;
import com.spring.security.jwt.JwtProvider;
import com.spring.security.jwt.JwtTokenFilter;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = false, jsr250Enabled = false)
//kích hoạt cả 3 cách phân quyền phương thức. Thực tế trong bài viết này, tôi chỉ ví dụ cách mới nhất là
// prePostEnabled = true sử dụng Spring Expression Language.
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired(required = true)
    private UserService userService;
    @Autowired
    JwtProvider jwtConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .cors()
                .and()
                .authorizeRequests() //khi co-author dang nhap thi bat dau bat quyen truy cap
                .antMatchers(HttpMethod.POST, "/api/sibspring/signup").permitAll()
                .antMatchers(HttpMethod.POST, "/api/sibspring/signing").permitAll()
                .antMatchers(HttpMethod.GET,"/i18n").permitAll()
                .antMatchers( "/api/sibspring/search").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtAuthEntryPoint())
                .and()
                .addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class) // kiểm tra all request cần xác thực, co jwt token hợp lệ ms truy vấn đc
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Xac thuc db
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Bean
    protected JwtTokenFilter jwtTokenFilter() {
        return new JwtTokenFilter();
    }

    @Bean
    protected JwtAuthEntryPoint jwtAuthEntryPoint() {
        return new JwtAuthEntryPoint();
    }
}
