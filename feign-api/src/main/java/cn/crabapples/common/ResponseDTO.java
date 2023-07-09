package cn.crabapples.common;

import com.alibaba.fastjson.JSONObject;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
public class ResponseDTO implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    private int status;
    private String message;
    private Object data;
    private long time;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    private ResponseDTO(ResponseCode status, String message, Object data) {
        this.status = status.getCode();
        this.message = message;
        this.data = data;
        this.time = System.currentTimeMillis();
    }

    private ResponseDTO(ResponseCode status, String message) {
        this.status = status.getCode();
        this.message = message;
        this.time = System.currentTimeMillis();
    }

    private ResponseDTO(int code, String message, Object data) {
        this.status = code;
        this.message = message;
        this.data = data;
        this.time = System.currentTimeMillis();
    }

    /*---------------- SUCCESS -------------*/

    public static ResponseDTO returnSuccess(String message, Object data) {
        return new ResponseDTO(ResponseCode.SUCCESS, message, data);
    }

    public static ResponseDTO returnSuccess(Object data) {
        return returnSuccess(DIC.BASE_SUCCESS_MESSAGE, data);
    }

    public static ResponseDTO returnSuccess() {
        return returnSuccess(DIC.BASE_SUCCESS_MESSAGE, null);
    }


    /*---------------- ERROR -----------------*/
    public static ResponseDTO returnError(String message) {
        return new ResponseDTO(ResponseCode.ERROR, message);
    }

    /*---------------- AUTH_FAIL -------------*/

    public static ResponseDTO returnAuthFail(String message) {
        return new ResponseDTO(ResponseCode.AUTH_FAIL, message);
    }

    /*---------------- CUSTOM ----------------*/
    public static ResponseDTO returnCustom(int status, String message, Object data) {
        return new ResponseDTO(status, message, data);
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    @Override
    public ResponseDTO clone() {
        try {
            ResponseDTO clone = (ResponseDTO) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
