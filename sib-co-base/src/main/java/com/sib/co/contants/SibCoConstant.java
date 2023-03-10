package com.sib.co.contants;

import java.util.Arrays;
import java.util.List;

public class SibCoConstant {
    /*record status*/
    public static final String ACTIVE = "1";
    public static final String DEFAULT_PAGE_NUM = "0";
    public static final String DEFAULT_PAGE_SIZE = "10";

    private SibCoConstant() {
        throw new IllegalStateException("SibCoConstant class");
    }

    /*SibCoLogging*/
    public static final String SEABANK = "SEABANK";
    public static final String SIB_CO_LOG_REQUEST = "REQUEST";
    public static final String SIB_CO_LOG_RESPONSE = "RESPONSE";
    public static final String SIB_CO_LOG_EXCEPTION = "EXCEPTION";
    public static final List<String> BLACK_LIST_FIELD_LOG = Arrays.asList("password", "oldPassword", "newPassword", "renewPassword", "id_token", "body", "header");
    public static final List<String> ERROR_CODE_SSO = Arrays.asList("104", "503", "50301", "50302", "50303", "50304", "50305", "50306", "50307");

    /*Currency*/
    public static final String CCY_VND = "VND";

    //approvalMethod
    public static final String OTP_TRANS_TYPE_ACCOUNT = "ACCOUNT";
    public static final String OTP_TRANS_TYPE_CARD = "CARD";
    public static final String OTP_TRANS_TYPE_USER = "USER";

    /*SibCoApi Response*/
    /* Sea Partner message key */
    public static final String SIB_CO_NOT_INFO_CODE = "0";
    public static final String SIB_CO_EXIST_INFO_CODE = "201";
    public static final String SIB_CO_SUCCESS_CODE = "0"; //2/6/2021: update 200 -> 0 theo tài liệu
    public static final String SIB_CO_EXIST_CODE = "202";
    public static final String SIB_CO_NOT_ALLOW_CODE = "203";
    public static final String SIB_CO_NOT_LINK_CODE = "204";
    public static final String SIB_CO_BADREQUEST_CODE = "400";
    public static final String SIB_CO_SERVER_ERROR_CODE = "500";
    public static final String SIB_CO_INVALID_FORMAT = "101";
    public static final String SIB_CO_SUCCESS_MESSAGE = "sib.co.success.message";

    /*List API SeABank*/
    public static final String API_AUTH = "API_AUTH";
    public static final String API_CUST_INFO = "API_CUST_INFO";
    public static final String API_UTILITY = "API_UTILITY";
    public static final String API_T24 = "API_T24";
    public static final String API_SP_COREAI = "API_SP_COREAI";
    public static final String API_REG_SMS = "API_REG_SMS";

    public static final String API_SP_ACC_UTIL = "API_SP_ACC_UTIL";
    public static final String API_SP_SEAPAY_CUSTOMER = "API_SP_SEAPAY_CUSTOMER";
    public static final String API_SP_SEAPAY_ACCOUNT = "API_SP_SEAPAY_ACCOUNT";
    public static final String API_SP_SEND_MAIL = "API_SP_SEND_MAIL";
    public static final String API_SP_AUTH = "API_SP_AUTH";
    public static final String API_SP_T24ENQUIRY = "API_SP_T24ENQUIRY";
    public static final String API_SP_EBANK = "API_EBANK";
    public static final String SP_PERMISSION_API = "SP_PERMISSION_API";

    public static final String API_LOCATION = "API_LOCATION";
    public static final String API_COLLECT_API = "COD_COLLECT_API";
    public static final String CONTENT_TYPE = "content-type";

    /*Cache Key*/
    public static final String CACHE_CUST_INFO = "CUST_INFO"; // Customer Info
    public static final String COD_POSTMAN = "CUST_COD_POSTMAN";
    public static final String KEY_COD_POSTMAN = "CUST_KEY_COD_POSTMAN";
    public static final String CACHE_CUST_CORP = "CUST_CORP"; // Customer Info Corp
    public static final String CACHE_USER_PROFILE = "USER_PROFILE"; // User Profile
    public static final String CACHE_UTILITY_BANK = "UTILITY_BANK";
    public static final String CACHE_UTILITY_NAPAS_BANK = "UTILITY_NAPAS_BANK";
    public static final String CACHE_UTILITY_CITY = "UTILITY_CITY";
    public static final String CACHE_UTILITY_LIST_SERVICE = "UTILITY_LIST_SERVICE";
    public static final String CACHE_UTILITY_LIST_PROVIDER = "UTILITY_LIST_PROVIDER";
    public static final String ADMIN = "ADMIN";
    public static final String USER = "USER";
    public static final String PM = "PM";
    public static final String CACHE_ACCOUNT_LIST = "ACCOUNT_LIST";// list all account
    public static final String CACHE_ACCOUNT_LIST_CURRENT = "ACCOUNT_LIST_CURRENT";// list account payment
    public static final String CACHE_ACCOUNT_LC2 = "ACCOUNT_LIST_LC2";// Danh sach thu tin dung
    public static final String CACHE_ACCOUNT_LIST_CONTRACT2 = "ACCOUNT_LIST_CONTRACT2";// Danh sach thu tin dung
    public static final String CACHE_ACCOUNT_LIST_GUARANTEE2 = "ACCOUNT_LIST_GUARANTEE2"; // danh sach bao lanh
    public static final String CACHE_ACCOUNT_LIST_COLLATERALBI = "ACCOUNT_LIST_COLLATERALBI"; // danh sach tai san dam bao
    public static final String CACHE_DETAIL_DPPRODUCT_CACHE = "DETAIL_DPPRODUCT_CACHE";
    public static final String CACHE_CUS_INFO_FIELD_CACHE = "CUS_INFO_FIELD_CACHE";
    public static final String CACHE_LOGIN_ATTEMPT = "LOGIN_ATTEMPT";
    public static final String CACHE_USER_LOCK_TEMPORARY = "USER_LOCK_TEMPORARY";
    public static final String KEY_COPR_MENU_USER_PERM = "COPR_MENU_USER_PERM.{0}.{1}"; // {0}=username, {1}=app_type
    public static final String KEY_COPR_MENU_ROLE_PERM = "COPR_MENU_ROLE_PERM.{0}.{1}.{2}.{3}"; // {0}=spId, {1}=productId, {2}=roleId, {3}=app_type
    public static final String KEY_COPR_USER_CONFIG_INFO = "COPR_USER_CONFIG_INFO.{0}"; // {0}=username
    public static final String KEY_COPR_USER_CONFIG_ACCOUNT = "COPR_USER_CONFIG_ACCOUNT.{0}"; // {0}=username
    public static final String KEY_LIST_COPR_USER_APPROVAL = "LIST_COPR_USER_APPROVAL.{0}"; // {0}=cusID
    public static final String CACHE_AUTHEN_JWT = "AUTHEN_JWT";
    public static final String CACHE_INTERNAL_ACCOUNT_INFO = "INTERNAL_ACCOUNT_INFO";
    public static final String CACHE_ADMIN_CONFIG_USER = "ADMIN_CONFIG_USER";

    /*Command Key*/
    public static final String GET_ENQUIRY = "GET_ENQUIRY";

    /*Other*/
    public static final String PDF = "PDF";
    public static final String FORMAT_UTILITY_BRANCH_CITY = "UTILITY_BRANCH.%s.%s";
    public static final String FORMAT_UTILITY_BRANCH_BANK = "UTILITY_BRANCH_BANK.%s";
    public static final String X_SIB_APP_COUNT = "X-sibApp-count";
    public static final String ADMIN_USER = "admin";
    public static final String LANG_VI = "vi";
    public static final String LANG_EN = "en";

    /*TransInfo*/
    public static final String USERNAME = "USERNAME";

    /*Regex*/
    public static final String REGEX_PWD = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%*])[0-9A-Za-z!@#$%*]{6,12}$";
    public static final String REGEX_ONLY_NUMBER = "^[0-9]*$"; // Chi bao gom so
    public static final String REGEX_NUMBER_ENG = "^[0-9A-Za-z]*$";  // Tieng viet khong giau + so
    public static final String REGEX_NUMBER_ENG_WHITESP = "^[0-9A-Za-z ]*$";  // Tieng viet khong giau + so + dau cach
    public static final String REGEX_BILLING_NO = "^[0-9A-Za-z-\\/]*$";  // Tieng viet khong giau, so, /, -

    public static class ApprovalFlow {
        public static final int AUTHORIZE_LEVEL_NO_APPROVE = 0;
        public static final int AUTHORIZE_LEVEL_SAME_LEVEL = -1;
        // Trtangj thái duyệt cho bảng master ( TRANSACTION)
        public static final String TRANSACTION_STATUS_PROCESSING_APPROVAL = "PROCESSING_APPROVAL"; // Đang duyệt
        public static final String TRANSACTION_STATUS_APPROVED = "APPROVED"; // Đã duyệt


        // Loại duyệt Đồng cấp = Y (Duyệt song song) | Nhiều cấp = N (Duyệt nối tiếp)
        public static final String TRANSACTION_SAME_LEVEL = "Y";
        public static final String TRANSACTION_NO_SAME_LEVEL = "N";


        // Trạng thái giao dịch trên QUEUE
        public static final String QUEUE_STATUS_PENDING = "PENDING";
        public static final String QUEUE_STATUS_PROCESSING = "PROCESSING";


        // Trạng thái đuyệt cho bảng APPROVAL
        public static final String APPROVAL_ITEM_STATUS_PENDING_APPROVAL = "PENDING_APPROVAL"; // Chờ chuyệt tới lượt duyệt
        public static final String APPROVAL_ITEM_STATUS_WAITING_APPROVAL = "WAITING_APPROVAL"; // Đến lượt user duyệt
        public static final String APPROVAL_ITEM_STATUS_APPROVED = "APPROVED"; // Đã duyệt
        public static final String APPROVAL_ITEM_STATUS_REJECTED = "REJECTED"; // Hủy duyệt

        public static final String ACTION_CREATE = "CREATE";

        public static final String APPROVAL_TYPE_LIST = "LIST";

    }

    public static class FtType {
        public static final String OWNER = "OWNER"; // CT cung chu
    }

    public static class ACCOUNT_STATUS {
        public static final String DRAFT = "DRAFT"; // Mới gửi lên
        public static final String CHECK_OTP_STATUS = "CHECK_OTP"; // status khi gui otp thanh cong.
        public static final String ERROR_DATA_FORMAT = "ERROR_DATA_FORMAT"; // Sai định dạng dữ liệu
        public static final String ERROR_AML_INVALID = "ERROR_AML_INVALID"; // Vi phạm AML
        public static final String ERROR_CUSTOMER_EXIST = "ERROR_CUSTOMER_EXIST"; // Khách hàng đã tồn tại
        public static final String CREATE_CUSTOMER_FAIL = "CREATE_CUSTOMER_FAIL"; // Lỗi tạo mã khách hàng
        public static final String ERROR_CREATE_ACCOUNT = "ERROR_CREATE_ACCOUNT"; // Lỗi tạo tài khoản
        public static final String ERROR_REGISTER_SMS = "ERROR_REGISTER_SMS"; // Lỗi đăng ký SMS
        public static final String ERROR_REGISTER_EBANK = "ERROR_REGISTER_EBANK"; // Lỗi đăng ký Ebank
        public static final String ERROR_REGISTER_FACE = "ERROR_REGISTER_FACE"; // Lỗi đăng ký CoreAI
        public static final String COMPLETED_ALL = "COMPLETED_ALL"; // thành công tất cả
        public static final String COMPLETED_PARTIAL = "COMPLETED_PARTIAL"; // thành công một phần
        public static final String REG_SERVICE_SUCCESS = "OK"; // trạng thái đăng ký các gói dịch vụ
        public static final String VERIFY_FAIL = "VERIFY_FAIL"; // trạng thai khách hàng chưa đủ 18 tuổi
        public static final String CREATE_CUSTOMER_SUCCESS = "CREATE_CUSTOMER_SUCCESS"; // tạo customer thành công
        public static final String CREATED = "CREATED"; // thành công tất cả
        public static final String CREATE_CUSTOMER_FAIL_CODE = "1"; // Lỗi tạo mã khách hàng
        public static final String ACCOUNT_CREATED = "ACCOUNT_CREATED"; // Lỗi tạo mã khách hàng
        public static final String CHECK_OTP = "CHECK_OTP"; // lưu thông tin OTP
        public static final String CHECK_OTP_FAILED = "CHECK_OTP_FAILED"; // mã otp sai
        public static final String CHECK_OTP_SUCCESS = "Y";
        public static final String SYSTEM_ERROR = "SYSTEM_ERROR"; // mã otp sai
    }

    public static class CODE_DECODE {
        public static final String VNPOST_CODE_GROUP = "VNPOST.BUU_CUC";
        public static final String VNPOST_CODE_JOB = "SEAB.JOB.CODE.ENQ";
        public static final String VNPT_CODE_INDUSTRY_GROUP = "ENQ.SEAB.JOB.CODE.PARENT";
        public static final String VNPT_CODE_POSITION = "CHUCVU";
    }

    public static class IMAGE_TYPE {
        public static final String FACE = "face";
        public static final String TRANSACTION = "transaction";
        public static final String ID_CARD = "idcard";
        public static final String VERIFY_ID_CARD = "verify-idcard";
        public static final String DOCS = "docs";
        public static final String VERIFY_DOCS = "verify-docs";
        public static final String PHONE = "phone";
        public static final String SUB_TYPE_IMAGE_OTHERS = "others";
        public static final String VERIFY_SUB_TYPE_IMAGE_OTHERS = "verify-others";
        public static final String SUB_TYPE_IMAGE_FRONT = "front";
        public static final String VERIFY_SUB_TYPE_IMAGE_FRONT = "verify-front";
    }

    public static class USER_ROLE {
        public static final String ROLE_BANK_ADMIN = "ADMIN-SEAPARTNER";
        public static final String ROLE_MANAGEMENT_BRANCH = "AGENT-MANAGER";
        public static final String ROLE_KSV = "AGENT-KSV";
        public static final String ROLE_GDV = "AGENT-GDV";
    }


    public static final String QUEUE_NAME = "queue_name";

    public static final String EXCHANGE_NAME = "exchange_name";

    public static final String ROUTING_KEY = "rabbitmq.*";
    public static final String API_LDAP_AUTH = "API_LDAP_AUTH";

    /**
     * API CASH PICKUP
     */
    public static final String CASH_PICKUP_API = "CASH_PICKUP_API";

    /**
     * API CONTACT
     */
    public static final String CONTACT_API_SP = "CONTACT_API_SP";
    public static final String RTSBVNP = "RTSBVNP";
    public static final String MG = "MG";
    public static final String LD = "LD";
    public static final String CACHE_POST_MAN = "CACHE_POST_MAN";
    public static final String CACHE_LIST_POST_MAN = "CACHE_LIST_POST_MAN";
    public static final String CACHE_CBB_POST_MAN = "CACHE_CBB_POST_MAN";
    public static final String CACHE_LIST_LINK_POST_MAN = "CACHE_LIST_LINK_POST_MAN";
}
