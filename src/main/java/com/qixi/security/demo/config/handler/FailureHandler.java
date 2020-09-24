package com.qixi.security.demo.config.handler;

import com.alibaba.fastjson.JSONObject;
import com.qixi.security.demo.constant.ResponseConstant;
import com.qixi.security.demo.entity.dto.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * 登录验证失败的处理方法
 *
 * @author ZhengNC
 * @date 2020/9/24 14:05
 */
@Component
public class FailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType("application/json;charset=utf-8");
        ResponseEntity<String> responseEntity = new ResponseEntity<>();
        responseEntity.setCode(ResponseConstant.FORBIDDEN.code);
        responseEntity.setMsg(ResponseConstant.FORBIDDEN.msg);
        responseEntity.setData(exception.getMessage());
        response.getWriter().write(JSONObject.toJSONString(responseEntity));
    }
}
