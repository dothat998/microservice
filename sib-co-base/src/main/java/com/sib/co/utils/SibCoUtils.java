package com.sib.co.utils;



import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sib.co.base.BaseObj;
import com.sib.co.contants.SibCoConstant;
import com.sib.co.response.SibCoResponse;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class SibCoUtils {

    private final Logger logger = LoggerFactory.getLogger(SibCoUtils.class);

//    @Value("${jhipster.security.authentication.jwt.base64-secret}")
//    private String secret;
//
//    @Autowired
//    private SibCoAppProperties sibCoAppProperties;
//
//    @Autowired
//    private MessageSource messageSource;
//
//    @Autowired
//    private HazelcastInstance hazelcastInstance;

    private static final char[] SOURCE_CHARACTERS = {'À', 'Á', 'Â', 'Ã', 'È', 'É',
            'Ê', 'Ì', 'Í', 'Ò', 'Ó', 'Ô', 'Õ', 'Ù', 'Ú', 'Ý', 'à', 'á', 'â',
            'ã', 'è', 'é', 'ê', 'ì', 'í', 'ò', 'ó', 'ô', 'õ', 'ù', 'ú', 'ý',
            'Ă', 'ă', 'Đ', 'đ', 'Ĩ', 'ĩ', 'Ũ', 'ũ', 'Ơ', 'ơ', 'Ư', 'ư', 'Ạ',
            'ạ', 'Ả', 'ả', 'Ấ', 'ấ', 'Ầ', 'ầ', 'Ẩ', 'ẩ', 'Ẫ', 'ẫ', 'Ậ', 'ậ',
            'Ắ', 'ắ', 'Ằ', 'ằ', 'Ẳ', 'ẳ', 'Ẵ', 'ẵ', 'Ặ', 'ặ', 'Ẹ', 'ẹ', 'Ẻ',
            'ẻ', 'Ẽ', 'ẽ', 'Ế', 'ế', 'Ề', 'ề', 'Ể', 'ể', 'Ễ', 'ễ', 'Ệ', 'ệ',
            'Ỉ', 'ỉ', 'Ị', 'ị', 'Ọ', 'ọ', 'Ỏ', 'ỏ', 'Ố', 'ố', 'Ồ', 'ồ', 'Ổ',
            'ổ', 'Ỗ', 'ỗ', 'Ộ', 'ộ', 'Ớ', 'ớ', 'Ờ', 'ờ', 'Ở', 'ở', 'Ỡ', 'ỡ',
            'Ợ', 'ợ', 'Ụ', 'ụ', 'Ủ', 'ủ', 'Ứ', 'ứ', 'Ừ', 'ừ', 'Ử', 'ử', 'Ữ',
            'ữ', 'Ự', 'ự',};

    private static final char[] DESTINATION_CHARACTERS = {'A', 'A', 'A', 'A', 'E',
            'E', 'E', 'I', 'I', 'O', 'O', 'O', 'O', 'U', 'U', 'Y', 'a', 'a',
            'a', 'a', 'e', 'e', 'e', 'i', 'i', 'o', 'o', 'o', 'o', 'u', 'u',
            'y', 'A', 'a', 'D', 'd', 'I', 'i', 'U', 'u', 'O', 'o', 'U', 'u',
            'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A',
            'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'E', 'e',
            'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e', 'E',
            'e', 'I', 'i', 'I', 'i', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o',
            'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O',
            'o', 'O', 'o', 'U', 'u', 'U', 'u', 'U', 'u', 'U', 'u', 'U', 'u',
            'U', 'u', 'U', 'u',};

    private static final String FORMAT_KEY = "%s#%s";

    public <T> SibCoResponse<T> buildResponse(String code, String message, T data) {
        SibCoResponse<T> response = new SibCoResponse<>();
        response.setCode(code);
        response.setMessage(message);
        response.setData(data);

        return response;
    }

    public <T> SibCoResponse<T> buildResponse(String code, T data) {
        SibCoResponse<T> response = new SibCoResponse<>();
        response.setCode(code);
        response.setData(data);
        resolveMessage(response);

        return response;
    }

    public <T> SibCoResponse<T> buildResponse(String code) {
        SibCoResponse<T> response = new SibCoResponse<>();
        response.setCode(code);
        response.setData(null);
        resolveMessage(response);

        return response;
    }

    public <T extends BaseObj> SibCoResponse<T> buildResponseWithBaseObj(T object) {
        SibCoResponse<T> response = new SibCoResponse<>();
        if (org.apache.commons.lang3.StringUtils.isBlank(object.getErrorCode())) {
            response.setCode(SibCoConstant.SIB_CO_SUCCESS_CODE);
            response.setMessage(getMessageI18N(SibCoConstant.SIB_CO_SUCCESS_MESSAGE, null));
            response.setData(object);
        } else {
            response.setCode(object.getErrorCode());
            response.setData(null);
            String errorMessageI18N = getMessageI18N(object.getErrorCode(), null);
            if (errorMessageI18N.equalsIgnoreCase(object.getErrorCode())) {
                /*Khong khai bao I18N cho ErrorCode --> Lay message mac dinh*/
                response.setMessage(object.getErrorMessage());
            } else {
                response.setMessage(errorMessageI18N);
            }

            return response;
        }

        if (org.apache.commons.lang3.StringUtils.isNotBlank(object.getWarningCode())) {
            response.setCode(SibCoConstant.SIB_CO_SUCCESS_CODE);
            response.setWarningCode(object.getWarningCode());
            String errorMessageI18N = getMessageI18N(object.getWarningCode(), null);
            if (errorMessageI18N.equalsIgnoreCase(object.getWarningCode())) {
                /*Khong khai bao I18N cho ErrorCode --> Lay message mac dinh*/
                response.setMessage(object.getWarningCode());
            } else {
                response.setMessage(errorMessageI18N);
            }
        }

        return response;
    }

    public <T> SibCoResponse<T> buildSuccessResponse(T data) {
        SibCoResponse<T> response = new SibCoResponse<>();
        response.setCode(SibCoConstant.SIB_CO_SUCCESS_CODE);
        response.setMessage(getMessageI18N(SibCoConstant.SIB_CO_SUCCESS_MESSAGE, null));
        response.setData(data);

        return response;
    }

    public SibCoResponse<Object> buildFailedResponse(HttpStatus error) {
        SibCoResponse<Object> response = new SibCoResponse<>();
        response.setCode(String.valueOf(error.value()));
        response.setData(null);
        String errorMessageI18N = getMessageI18N(String.valueOf(error.value()), null);
        if (errorMessageI18N.equalsIgnoreCase(String.valueOf(error.value()))) {
            response.setMessage(error.getReasonPhrase());
        } else {
            response.setMessage(errorMessageI18N);
        }

        return response;
    }

    private <T> SibCoResponse<T> resolveMessage(SibCoResponse<T> response) {
        String messageI18N = getMessageI18N(response.getCode(), null);

        if (!messageI18N.equalsIgnoreCase(response.getCode())) {
            response.setMessage(messageI18N);
        }

        return response;
    }

//    public String getSessionId(String jwt) {
//        try {
//            CasToken casToken = getCasToken(jwt);
//            return casToken.getAttr01();
//
//        } catch (JwtException | ClassCastException e) {
//            return null;
//        }
//    }
//
//    public String getLDAPSecretKey(HttpServletRequest request) {
//        try {
//            CasToken casToken = getCasToken(resolveToken(request));
//            return casToken.getSecretKey();
//        } catch (JwtException | ClassCastException e) {
//            return null;
//        }
//    }
//
//    public String getLDAPJWT(HttpServletRequest request) {
//        try {
//            CasToken casToken = getCasToken(resolveToken(request));
//            return casToken.getJwt();
//        } catch (JwtException | ClassCastException e) {
//            return null;
//        }
//    }
//
//    private String decrypt(String encryptedText, String secretKey, String salt) {
//        TextEncryptor decryptor = Encryptors.text(secretKey, salt);
//        return decryptor.decrypt(encryptedText);
//    }
//
//    public String getSessionId(HttpServletRequest request) {
//        return getSessionId(resolveToken(request));
//    }
//
//    public String resolveToken(HttpServletRequest request) {
//        String bearerToken = request.getHeader(JWTConfigurer.AUTHORIZATION_HEADER);
//        String jwt = null;
//
//        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
//            jwt = bearerToken.substring(7, bearerToken.length());
//            return jwt;
//        }
//
//        jwt = request.getParameter(JWTConfigurer.AUTHORIZATION_TOKEN);
//        if (StringUtils.hasText(jwt)) {
//            return jwt;
//        }
//
//        return null;
//    }

    public String getRemoteIpAddress(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }

        return ipAddress;
    }

//    public String getCustomerId(String jwt) {
//        if (jwt == null || "null".equalsIgnoreCase(jwt) || org.apache.commons.lang3.StringUtils.isBlank(jwt)) {
//            return "";
//        }
//
//        try {
//            CasToken casToken = getCasToken(jwt);
//            return casToken.getAttr02();
//        } catch (JwtException | ClassCastException e) {
//            logger.error(e.getMessage(), e);
//            return null;
//        }
//    }

//    public String getCustomerId(HttpServletRequest request) {
//        return this.getCustomerId(resolveToken(request));
//    }

//    private Claims getClaims(String jwt) {
//        return Jwts.parser()
//                .setSigningKey(secret)
//                .parseClaimsJws(jwt)
//                .getBody();
//    }

//    public CasToken getCasToken(String jwt) {
//        try {
//            Claims body = getClaims(jwt);
//
//            String encryptedData = body.get(AuthCasUtil.TOKEN_DATA_KEY).toString();
//            String salt = body.get(AuthCasUtil.TOKEN_SALT_KEY).toString();
//            String decryptedData = decrypt(encryptedData, secret, salt);
//
//            return AuthCasUtil.covertJsonToObject(decryptedData);
//        } catch (ClassCastException | JwtException var7) {
//            return null;
//        }
//    }
//
//    public String getPackAge(HttpServletRequest request) {
//        return this.getPackAge(resolveToken(request));
//    }
//
//    public String getPackAge(String jwt) {
//        try {
//            return getCasToken(jwt).getAttr04();
//        } catch (JwtException | ClassCastException e) {
//            logger.error(e.getMessage(), e);
//            return null;
//        }
//    }
//
//    /**
//     * If the current user has a specific authority (security role).
//     * <p>
//     * The name of this method comes from the {@code isUserInRole()} method in the Servlet API.
//     *
//     * @param authority the authority to check.
//     * @return true if the current user has the authority, false otherwise.
//     */
//    public static boolean isCurrentUserInRole(String authority) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return authentication != null &&
//                authentication.getAuthorities().stream()
//                        .map(GrantedAuthority::getAuthority).anyMatch(authority::equals);
//    }
//
//    public String getUserName(String jwt) {
//        if (jwt == null || "null".equalsIgnoreCase(jwt) || org.apache.commons.lang3.StringUtils.isBlank(jwt)) {
//            return "UNKNOWN";
//        }
//
//        try {
//            CasToken casToken = getCasToken(jwt);
//            return casToken.getAttr03();
//        } catch (ClassCastException | JwtException var7) {
//            return null;
//        }
//    }

//    public String getUserName(HttpServletRequest request) {
//        return this.getUserName(resolveToken(request));
//    }

//    public String getHostName() {
//        String hostname;
//        try {
//            InetAddress ex = InetAddress.getLocalHost();
//            hostname = ex.getHostName();
//        } catch (UnknownHostException var3) {
//            hostname = "Unknown";
//        }
//
//        return hostname;
//    }

//    public String getContext(HttpServletRequest request) {
//        return request.getHeader(JWTConfigurer.CONSUMER_DEVICE);
//    }

    public String getBrowserName(HttpServletRequest request) {
        return request.getHeader("Browser-Name");
    }

    public String getLanguage(HttpServletRequest request) {
        String lang = request.getHeader("Language");
        if (SibCoConstant.LANG_EN.equalsIgnoreCase(lang)) {
            return lang;
        }

        return SibCoConstant.LANG_VI;
    }

    public String getMessageI18N(String messageCode, Object o) {
        return getMessageI18N(messageCode, null);
    }

//    public String getMessageI18N(String messageCode, Object[] parameter) {
//        return getMessageI18N(messageCode, LocaleContextHolder.getLocale(), parameter);
//    }
//
//    public String getMessageI18N_Request(String messageCode, HttpServletRequest request) {
//        return getMessageI18N(messageCode, new Locale(getLanguage(request)), null);
//    }

//    public String getMessageI18N(String messageCode, Locale locale, Object[] parameter) {
//        if (messageCode == null) {
//            return "";
//        }
//
//        try {
//            return messageSource.getMessage(messageCode, parameter, locale);
//        } catch (Exception ex) {
//            logger.debug("SibCoUtils: Cant not find message with code = {}", messageCode);
//
//            return messageCode;
//        }
//    }

    public String generateCacheKey(String username, String function) {
        return String.format(FORMAT_KEY, username, function);
    }

    public String generateCacheKey(Object... args) {
        String formatKey = "";
        for (int i = 0; i < args.length; i++) {
            formatKey += "%s#";
        }

        return String.format(formatKey, args);
    }

    public String generateTransId() {
        return java.util.UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

//    public Map<String, String> buildRequestParams(HttpServletRequest request) {
//        Map<String, String> reqMap = new HashMap<>();
//
//        try {
//            reqMap.put(SibCoApiClientConstants.API_HEADER_LOCATION, getRemoteIpAddress(request));
//            reqMap.put(SibCoApiClientConstants.API_HEADER_SESSION_ID, getSessionId(request));
//            reqMap.put(SibCoApiClientConstants.API_HEADER_USER_ID, getUserName(request));
//            reqMap.put(SibCoApiClientConstants.API_HEADER_CUSTOMER_ID, getCustomerId(request));
//            reqMap.put(SibCoApiClientConstants.API_HEADER_CONTEXT, getContext(request));
//            reqMap.put(SibCoApiClientConstants.API_HEADER_REQUEST_API, getRemoteIpAddress(request));
//            reqMap.put(SibCoApiClientConstants.API_HEADER_REQUEST_NODE, "");
//            String uuid = java.util.UUID.randomUUID().toString().replace("-", "").toUpperCase();
//            reqMap.put(SibCoApiClientConstants.API_HEADER_TRANS_ID, uuid);
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        }
//        return reqMap;
//    }

    /**
     * Validate So Tai Khoan (AccountID) cua SeABank.
     * Chi bao gom SO va toi da 25
     *
     * @param accountID
     * @return boolean true is VALID and false is INVALID
     */
    public boolean isValidInternalAccountID(String accountID) {
        if (org.apache.commons.lang3.StringUtils.isBlank(accountID)) {
            return false;
        }

        Pattern pattern = Pattern.compile(SibCoConstant.REGEX_ONLY_NUMBER);
        Matcher matcher = pattern.matcher(accountID);

        return matcher.matches() && accountID.length() <= 25;
    }

    /**
     * Validate So Tai Khoan (AccountID) ngoai SeABank.
     * Chi bao gom SO, Tieng Viet khong dau va toi da 35
     *
     * @param accountID
     * @return boolean true is VALID and false is INVALID
     */
    public boolean isValidExternalAccountID(String accountID) {
        if (org.apache.commons.lang3.StringUtils.isBlank(accountID)) {
            return false;
        }

        Pattern pattern = Pattern.compile(SibCoConstant.REGEX_NUMBER_ENG);
        Matcher matcher = pattern.matcher(accountID);

        return matcher.matches() && accountID.length() <= 35;
    }

    /**
     * Validate Ten nguoi thu huong
     * Chi bao gom SO, Tieng Viet khong dau va toi da 70
     *
     * @param benName
     * @return boolean true is VALID and false is INVALID
     */
    public boolean isValidExternalBenName(String benName) {
        if (org.apache.commons.lang3.StringUtils.isBlank(benName)) {
            return false;
        }

        Pattern pattern = Pattern.compile(SibCoConstant.REGEX_NUMBER_ENG_WHITESP);
        Matcher matcher = pattern.matcher(benName);

        return matcher.matches() && benName.length() <= 70;
    }

    /**
     * Validate So Hoa don thanh toan
     * Chi bao gom SO, Tieng Viet khong dau va toi da 35
     *
     * @param billingNo
     * @return boolean true is VALID and false is INVALID
     */
    public boolean isValidBillingNo(String billingNo) {
        if (org.apache.commons.lang3.StringUtils.isBlank(billingNo)) {
            return false;
        }

        Pattern pattern = Pattern.compile(SibCoConstant.REGEX_BILLING_NO);
        Matcher matcher = pattern.matcher(billingNo);

        return matcher.matches() && billingNo.length() <= 35;
    }

    /**
     * Format Tien te
     *
     * @param ccy
     * @param input
     * @return String
     */
    public String formatCCY(String ccy, Double input) {
        if (SibCoConstant.CCY_VND.equalsIgnoreCase(ccy)) {
            return formatInternalCCY(input);
        }

        return formatExternalCCY(input);
    }

    public String formatDouble(String format, Double input) {
        if (input == null) {
            return "0";
        }

        DecimalFormat dfInternal = new DecimalFormat(format);
        return dfInternal.format(input);
    }

    /**
     * Format NGOAI TE
     * 123,456.78
     *
     * @param input
     * @return String
     */
    public String formatExternalCCY(Double input) {
        if (input == null) {
            return "0";
        }

        DecimalFormat dfInternal = new DecimalFormat("###,###.##");
        return dfInternal.format(input);
    }

    /**
     * Format NOI te VND
     * 123,456,456
     *
     * @param input
     * @return String
     */
    public String formatInternalCCY(Double input) {
        if (input == null) {
            return "0";
        }

        DecimalFormat dfInternal = new DecimalFormat("###,###");
        return dfInternal.format(input);
    }

    /*Clear cache thong tin TK (So du,...) khi chuyen tien thanh cong*/
//    public void clearCacheAccountList(HttpServletRequest request) {
//        try {
//            String custId = getCustomerId(request);
//            String keyAccCurrent = this.generateCacheKey(custId, SibCoConstant.CACHE_ACCOUNT_LIST_CURRENT);
//            String keyAccAll = this.generateCacheKey(custId, SibCoConstant.CACHE_ACCOUNT_LIST);
//
//            hazelcastInstance.getMap(SibCoConstant.CACHE_CUST_INFO).remove(keyAccCurrent);
//            hazelcastInstance.getMap(SibCoConstant.CACHE_CUST_INFO).remove(keyAccAll);
//        } catch (Exception ex) {
//            logger.error("Clear cache account list error", ex);
//        }
//    }

    public ZonedDateTime getCurrentTime() {
        return ZonedDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
    }

    public char removeAccent(char ch) {
        int index = Arrays.binarySearch(SOURCE_CHARACTERS, ch);
        if (index >= 0) {
            ch = DESTINATION_CHARACTERS[index];
        }
        return ch;
    }

    public String convertToEnglish(String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < sb.length(); i++) {
            sb.setCharAt(i, removeAccent(sb.charAt(i)));
        }
        return sb.toString();
    }

    public Double convertStr2Double(String input) {
        try {
            return Double.parseDouble(input);
        } catch (Exception ex) {
            logger.error("Convert String to Double error", ex);
            return 0D;
        }
    }

    public BigDecimal convertStr2BigDecimal(String input) {
        try {
            return new BigDecimal(input);
        } catch (Exception ex) {
            return new BigDecimal(0);
        }
    }

    public boolean compareEqualsDate(ZonedDateTime date1, ZonedDateTime date2) {
        try {
            SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");

            return dtf.format(date1).equals(dtf.format(date2));
        } catch (Exception e) {
            return false;
        }


    }

    public boolean isValidDate(String date) {
        if (date == null || date.trim().length() == 0) {
            return false;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            sdf.parse(date);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
