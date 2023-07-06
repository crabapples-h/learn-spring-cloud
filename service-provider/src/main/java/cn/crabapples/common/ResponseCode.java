package cn.crabapples.common;

import lombok.Getter;

/**
 * http请求返回状态码
 */
public enum ResponseCode {
    SUCCESS(200),
    ERROR(500),
    AUTH_FAIL(401);
    @Getter
    private final int code;

    ResponseCode(int code) {
        this.code = code;
    }
}
