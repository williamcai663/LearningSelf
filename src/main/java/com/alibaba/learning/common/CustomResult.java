package com.alibaba.learning.common;

import lombok.Data;

@Data
public class CustomResult {
    private String code;
    private String message;
    private Object data;

    public static CustomResult success(String message) {
        CustomResult result = new CustomResult();
        result.setCode("0000");
        result.setMessage(message);
        return result;
    }

    public static CustomResult fail(String message, Object data) {
        CustomResult result = new CustomResult();
        result.setCode("0001");
        result.setMessage(message);
        result.setData(data);
        return result;
    }
}
