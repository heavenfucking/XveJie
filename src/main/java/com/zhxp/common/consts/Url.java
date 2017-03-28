package com.zhxp.common.consts;

/**
 * Created by zhu on 2017/3/28.
 */
public interface Url {
    /**
     * Student增删改接口
     */
    class StudentAPI{

        /** 添加 */
        public static final String ADD_STUDENT_URL = "student/add";

        /** 删除 */
        public static final String DEL_STUDENT_URL = "student/delete";

        /** 修改 */
        public static final String UPDATE_STUDENT_URL = "student/update";

        /** 查询*/
        public static final String LIST_STUDENT_URL = "student/list";
    }
}