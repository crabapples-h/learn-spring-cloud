package cn.crabapples.wechatofficial.common;

import cn.crabapples.common.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@ControllerAdvice
public class CustomExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler
    @ResponseBody
    protected ResponseDTO applicationExceptionHandler(Exception e) {
        logger.warn("XHR出现异常:[{}]", e.getMessage(), e);
        return ResponseDTO.returnError("操作失败", e.getMessage());
    }
}
