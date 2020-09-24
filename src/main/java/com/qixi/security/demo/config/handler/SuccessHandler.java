package com.qixi.security.demo.config.handler;

import com.alibaba.fastjson.JSONObject;
import com.qixi.security.demo.entity.dto.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * 登录验证成功的处理方法
 *
 * @author ZhengNC
 * @date 2020/9/24 13:12
 */
@Component
public class SuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setStatus(HttpStatus.OK.value());
        response.setContentType("application/json;charset=utf-8");
        String token = UUID.randomUUID().toString();
        response.addHeader("token", token);
        ResponseEntity<String> responseEntity = ResponseEntity.success(token);
        response.getWriter().write(JSONObject.toJSONString(responseEntity));
    }
}
