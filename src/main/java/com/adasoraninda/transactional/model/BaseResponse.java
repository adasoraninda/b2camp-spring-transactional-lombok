package com.adasoraninda.transactional.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BaseResponse<T> {

    private int code;
    private String message;
    private T data;

    private BaseResponse() {
    }

    public static <T> BaseResponse<T> success(int code, T data) {
        return new BaseResponse<T>(code, "Success", data);
    }

    public static <T> BaseResponse<T> error(int code, String message, T data) {
        return new BaseResponse<T>(code, message, data);
    }

}
