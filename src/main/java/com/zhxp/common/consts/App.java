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
}
