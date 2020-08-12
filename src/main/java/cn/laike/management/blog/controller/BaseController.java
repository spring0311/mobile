package cn.laike.management.blog.controller;

import javax.servlet.http.HttpSession;

public class BaseController {

    public static final String OK = "2000";

    protected final Long getUidFromSession(HttpSession session) {
        return Long.valueOf(session.getAttribute("userId").toString());
    }
    protected final String getUsernameFromSession(HttpSession session) {
        return session.getAttribute("username").toString();
    }
    protected final Long getDeptIdFromSession(HttpSession session) {
        /*return session.getAttribute("deptId").toString();*/
        return  Long.valueOf(session.getAttribute("deptId").toString());
    }
    protected final String getUserEmpnoFromSession(HttpSession session) {
        return session.getAttribute("userEmpno").toString();
    }

}
