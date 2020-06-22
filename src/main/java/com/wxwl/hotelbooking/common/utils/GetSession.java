package com.wxwl.hotelbooking.common.utils;

import com.wxwl.hotelbooking.common.domain.Users;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GetSession {
    public static HttpSession getSession() {
        HttpSession session = null;
        try {
            session = getRequest().getSession();
        } catch (Exception e) {}
        return session;
    }

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getRequest();
    }

    public static Users getUserBySession(HttpSession session){
        Users user = new Users();
        user.setId(Integer.valueOf(session.getAttribute("id").toString()));
        user.setPwd(session.getAttribute("pwd").toString());
        user.setPhone((String) session.getAttribute("phone"));
        return user;
    }
}
