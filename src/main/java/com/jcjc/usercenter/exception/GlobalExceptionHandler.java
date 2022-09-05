package com.jcjc.usercenter.exception;

import com.jcjc.usercenter.common.BaseResponse;
import com.jcjc.usercenter.common.ErrorCode;
import com.jcjc.usercenter.common.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public BaseResponse businessExceptionHandler(BusinessException e){
        log.error("businessException:"+e.getMessage(),e);
        return ResultUtils.error(e.getCode(), e.getMessage(),e.getDescription());
    }
    @ExceptionHandler(RuntimeException.class)
    public BaseResponse RuntimeExceptionHandler( RuntimeException e){
        log.error("RuntimeException",e);
      return ResultUtils.error(ErrorCode.SYSTEM_ERROR, e.getMessage(),"");
    }
}
