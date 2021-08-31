package cn.auroraOps04.react_demo_api.entity.response;

/**
 * @author AuroraOps04
 * @date 2021-08-31 14:07:32
 * @description 响应码
 */
public enum ApiResponseCode {
    SUCCESS(200, "OK"),
    CREATED(201, "Entity Created"),
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHENTICATED(401, "UNAUTHENTICATED")
    ;
    private Integer code;
    private String message;

    ApiResponseCode() {
    }

    ApiResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
