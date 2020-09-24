package com.qixi.security.demo.config.handler;

import com.alibaba.fastjson.JSONObject;
import com.qixi.security.demo.constant.ResponseConstant;
import com.qixi.security.demo.entity.dto.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ZhengNC
 * @date 2020/9/24 16:46
 */
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json;charset=utf-8");
        ResponseEntity<String> responseEntity = new ResponseEntity<>();
        responseEntity.setCode(ResponseConstant.UNAUTHORIZED.code);
        responseEntity.setMsg(ResponseConstant.UNAUTHORIZED.msg);
        responseEntity.setData(accessDeniedException.getMessage());
        response.getWriter().write(JSONObject.toJSONString(responseEntity));
    }
}
