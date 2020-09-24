package com.qixi.security.demo.config.handler;

import com.alibaba.fastjson.JSONObject;
import com.qixi.security.demo.constant.ResponseConstant;
import com.qixi.security.demo.entity.dto.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ZhengNC
 * @date 2020/9/24 15:05
 */
@Component
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType("application/json;charset=utf-8");
        ResponseEntity<String> responseEntity = new ResponseEntity<>();
        responseEntity.setCode(ResponseConstant.FORBIDDEN.code);
        responseEntity.setMsg(ResponseConstant.FORBIDDEN.msg);
        responseEntity.setData(authException.getMessage());
        response.getWriter().write(JSONObject.toJSONString(responseEntity));
    }
}
