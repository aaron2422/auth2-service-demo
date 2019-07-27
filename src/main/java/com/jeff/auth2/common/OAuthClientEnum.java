package com.jeff.auth2.common;

import lombok.Getter;

/**
 * Created by Jeff on 2019/7/27.
 */
@Getter
public enum OAuthClientEnum {

    ANDORID_APP(101,"成功"),
    IOS_APP(102,"失败"),
    MINIPROGRAM(201,"用户未登录"),
    MMS(202,"用户账号或密码错误"),
    ;

    private Integer code;

    private String message;

    OAuthClientEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static OAuthClientEnum parse(int code){
        OAuthClientEnum[] values = values();
        for (OAuthClientEnum value : values) {
            if(value.getCode() == code){
                return value;
            }
        }
        throw  new RuntimeException("Unknown code of OAuthClientEnum");
    }
}
