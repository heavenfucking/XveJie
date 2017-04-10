package com.zhxp.common.consts;

/**
 * Created by zhu on 2017/3/28.
 */
public interface App {

    /**
     * 接口相应代码
     */
    class ResponseCode{

        /** 所有接口成功时返回的CODE值 */
        public static final int API_RESULT_CODE_FOR_SUCCEES = 0;
        /** 所有接口成功时返回的MSG值 */
        public static final String API_RESULT_MSG_FOR_SUCCEES = "操作成功";

        /** 所有接口异常情况时返回的CODE值 */
        public static final int API_RESULT_CODE_FOR_FAIL = -1;
        /** 所有接口异常情况时返回的MSG值 */
        public static final String API_RESULT_MSG_FOR_FAIL = "系统繁忙，请稍后再试";



    }

    class SessionExceptionCode{

        /** 未登录异常代码 */
        public static final int IS_NOT_LOGON_CODE = 100;
        /** 为登录异常信息 */
        public static final String IS_NOT_LOGON_MSG = "未登录";

    }

    class Session{

        /** 用户登陆session存储键 */
        public static final String SESSION_USER_LOGIN_OBJ_KEY = "session_user_login_obj_key";

        /** 用户登陆类型  1 学生登录 2 教师登录 2 管理员登陆 */
        public static final String SESSION_USER_LOGIN_TYPE_KEY ="session_user_login_type_key";

    }
}
