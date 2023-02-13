package com.spring.security.jwt;

import com.spring.model.UserModel;
import com.spring.service.UserService;
import io.jsonwebtoken.*;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

/*
 * @author: ThatND
 * @since: 7/2/2023 4:10 PM
 * @description: tao ra chuoi token
 * @update:
 *
 * */
@Component
@Getter
public class JwtProvider {
    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    @Autowired
    UserService userService;

    //key truyen vao chuoi jwt
    @Value("${jwt.secret}")
    private String secret;

    //thoi gian song cua token  - 1day = 86400s
    @Value("${jwt.expiration}")
    private int expiration;
    @Value("${jwt.header}")
    private String header;
    @Value("${jwt.prefix}")
    private String prefix;
    @Value("${jwt.auth-uri}")
    private String authUri;


    /**
     * Tao ra token
     *
     * @param authentication
     * @return
     */
    public String createToken(Authentication authentication) {
        Date present = new Date();
        UserModel userPrincipal = (UserModel) authentication.getPrincipal(); // lay ra user hien tai
        System.out.println(userPrincipal.toString());
        return Jwts.builder()
                .setSubject(userPrincipal.getUsername()) //set cac thuoc tinh vao jwt
                .claim("admin_account", userPrincipal.getAuthorities())
                .claim("userID", userPrincipal.getId())
                .claim("name", userPrincipal.getName())
                .claim("role", userPrincipal.getRoles())
                .claim("email", userPrincipal.getEmail())
                .setIssuedAt(present)
                // thì phải set cung vao dadayspring ko khuyến khích lm vậy vì mai này muswuawr nó rát khó khăn, cái này ms chỉ ở 1 file java,
                // có những giá trị cứng như vậy dùng ở nhiều file sauwr sẽ rất lâu nên spring tập hộp các giá trị cứng lại 1 nơi
                .setExpiration(new Date(present.getTime() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * kiểm tra token co hop le hay khong
     *
     * @param token
     * @return
     */
    public boolean validationToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature -> Message: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid Format JWT token -> Message: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("Expired JWT token -> Message: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("Unsupported JWT token -> Message: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty -> Message: {}", e.getMessage());
        }
        return false;
    }

    /**
     * Trả về username trong jwt => tu jwt tra nguoc lai user cho class khac dung
     *
     * @param token
     * @return
     */
    public String getUsernameFromJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody().getSubject();
    }

    /**
     * Trả về thời gian hết hạn của jwt
     *
     * @param token
     * @return
     */
    public Date getExpiryDate(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
    }
}
