package com.qixi.security.demo.entity.dto;

import com.qixi.security.demo.constant.ResponseConstant;
import lombok.Data;

/**
 * 统一响应实体
 *
 * @author ZhengNC
 * @date 2020/5/24 12:26
 */
@Data
public class ResponseEntity<T> {

    private String code;

    private String msg;

    private T data;

    public ResponseEntity() {}

    public ResponseEntity(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 成功的响应
     * @param data
     * @return
     */
    public static ResponseEntity success(Object data){
        return new ResponseEntity(ResponseConstant.SUCCESS.code,
                ResponseConstant.SUCCESS.msg, data);
    }

    /**
     * 服务器错误的消息响应
     * @return
     */
    public static ResponseEntity failed(){
        return new ResponseEntity(ResponseConstant.FAILED.code,
                ResponseConstant.FAILED.msg, null);
    }

    /**
     * 自定义服务器错误的消息响应
     * @param code
     * @param msg
     * @return
     */
    public static ResponseEntity failed(String code, String msg){
        return new ResponseEntity(code,msg, null);
    }

    /**
     * 默认的参数错误响应
     * @return
     */
    public static ResponseEntity paramFailed(){
        return new ResponseEntity(ResponseConstant.PARAM_FAILED.code,
                ResponseConstant.PARAM_FAILED.msg, null);
    }

    /**
     * 自定义消息的参数错误响应
     * @param message
     * @return
     */
    public static ResponseEntity paramFailed(String message){
        return new ResponseEntity(ResponseConstant.PARAM_FAILED.code,
                message, null);
    }
}
