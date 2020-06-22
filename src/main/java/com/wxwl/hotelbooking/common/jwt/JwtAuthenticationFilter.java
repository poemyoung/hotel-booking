package com.wxwl.hotelbooking.common.jwt;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

    }

    /**
     * 检查请求的url是否需要被保护起来
     * @param request 请求
     * @return 返回值
     */
//    private boolean isUrlProtected(HttpServletRequest request){
//
//    }
}
