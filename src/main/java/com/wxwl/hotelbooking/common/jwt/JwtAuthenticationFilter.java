package com.wxwl.hotelbooking.common.jwt;

import com.alibaba.fastjson.JSONObject;
import com.wxwl.hotelbooking.common.utils.Result;
import com.wxwl.hotelbooking.common.utils.ResultCode;
import com.wxwl.hotelbooking.mapper.RolesMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j

@WebFilter(filterName = "JwtFilter", urlPatterns = {"/reserves/*","/hotels/*","/test/*"})

public class JwtAuthenticationFilter extends GenericFilterBean {

    @Autowired
    RolesMapper rolesMapper;
    @Autowired
    JwtTokenMsg jwtTokenMsg;
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest)req;
        final HttpServletResponse response = (HttpServletResponse) resp;
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        //从Http请求获取授权
        final String authHeader = request.getHeader("authorization");
        //如果Http请求是Options,只需要返回状态码200（探测性请求
        //除options外，其它请求全部过滤
        if("OPTIONS".equals(request.getMethod())){
            response.setStatus(HttpServletResponse.SC_OK);
        }
        else {
            //检测授权，Bearer为认证类型
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
               //无令牌访问
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write(failureJson());
                return;
            }
            //获取jwt令牌
            final  String token = authHeader.substring(7);
            try{
                final Claims claims = Jwts.parser().setSigningKey(JwtMsg.SECRET).parseClaimsJws(token).getBody();
                jwtTokenMsg.storeToRedis(claims,token);
                //尾
            }catch (final SignatureException | MalformedJwtException e){
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write(failureJson());
                return;
            }
            chain.doFilter(req,resp);
        }
    }

    private String failureJson(){
        JSONObject jObj = new JSONObject();
        Result res = new Result();
        res.setResultCode(ResultCode.PERMISSION_NO_ACCESS);
        jObj.put("code",res.getCode());
        jObj.put("msg",res.getMsg());
        jObj.put("data",res.getData());
        return jObj.toJSONString();
    }
}
