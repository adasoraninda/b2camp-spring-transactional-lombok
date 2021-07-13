package com.adasoraninda.transactional.controller;

import com.adasoraninda.transactional.exception.StudentException;
import com.adasoraninda.transactional.model.BaseResponse;

public class HandleResponse {

    public static <T> BaseResponse<T> saveHandle(HandleResponseCallback<T> callback) {
        try {
            return BaseResponse.success(200, callback.body());
        } catch (StudentException e) {
            return BaseResponse.error(401, e.getMessage(), null);
        }
    }

}
