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

    /**
     * Teacher增删改接口
     */
    class TeacherAPI{

        /** 添加 */
        public static final String ADD_TEACHER_URL = "teacher/add";

        /** 删除 */
        public static final String DEL_TEACHER_URL = "teacher/delete";

        /** 修改 */
        public static final String UPDATE_TEACHER_URL = "teacher/update";

        /** 查询*/
        public static final String LIST_TEACHER_URL = "teacher/list";
    }

    /**
     * 用户登陆接口
     */
    class UserLoginAPI{

        /** 登录 */
        public static final String USER_LOGIN_URL = "user/login";
    }

}