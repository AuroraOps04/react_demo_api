package cn.auroraOps04.react_demo_api.utils;

import cn.auroraOps04.react_demo_api.entity.response.ApiResponse;
import cn.auroraOps04.react_demo_api.entity.response.ApiResponseCode;

/**
 * @author AuroraOps04
 * @date 2021-08-31 14:11:41
 * @description
 */

public class ApiResponseUtil {
    public static ApiResponse success(){
        return new ApiResponse(ApiResponseCode.SUCCESS);
    }

    public static ApiResponse success(Boolean success){
        return new ApiResponse(ApiResponseCode.SUCCESS, success);
    }

    public static ApiResponse success(Boolean success, String message){
        return new ApiResponse(ApiResponseCode.SUCCESS.getCode(), success, message);
    }

    public static ApiResponse success(Object data){
        return new ApiResponse(ApiResponseCode.SUCCESS, data);
    }

    public static ApiResponse success(Boolean success, Object data){
        return new ApiResponse(ApiResponseCode.SUCCESS, success, data);
    }

    public static ApiResponse created(){
        return new ApiResponse(ApiResponseCode.CREATED);
    }

    public static ApiResponse badRequest(){
        return new ApiResponse(ApiResponseCode.BAD_REQUEST, false);
    }
    public static ApiResponse badRequest(String message){
        return new ApiResponse(ApiResponseCode.BAD_REQUEST.getCode(), false, message);
    }
}
