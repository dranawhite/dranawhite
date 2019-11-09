package com.dranawhite.distributed.exception;

import com.dranawhite.common.exception.GenericResultCode;
import com.dranawhite.common.text.JsonUtil;
import com.dranawhite.distributed.model.Response;
import com.dranawhite.distributed.model.ResponseBuilder;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * Dubbo统一异常处理
 *
 * @author dranawhite
 * @version [1.0, 2018/5/31 15:59]
 */

@Slf4j
@Component("exceptionAdvice")
public class ExceptionAdvice {

    @SuppressWarnings("unchecked")
    public <T> Response<T> exceptionIntercept(ProceedingJoinPoint joinPoint) {
        try {
            Object response = joinPoint.proceed();
            if (response instanceof Response) {
                return (Response<T>) response;
            } else {
                return ResponseBuilder.buildResponse(GenericResultCode.SYSTEM_ERROR.getCode(),
                        GenericResultCode.SYSTEM_ERROR.getDesc());
            }
        } catch (Throwable tw) {
            final String methodName = joinPoint.getSignature().getDeclaringTypeName() + "#" +
                    joinPoint.getSignature().getName();
            final String methodArg = buildMethodArgs(joinPoint);
            log.error("系统异常, 业务方法:{}, 方法入参: {}", methodName, methodArg, tw);
            return ResponseBuilder.buildResponse(GenericResultCode.SYSTEM_ERROR.getCode(),
                    GenericResultCode.SYSTEM_ERROR.getDesc());
        }
    }

    private String buildMethodArgs(ProceedingJoinPoint joinPoint) {
        Object[] argObjs = joinPoint.getArgs();
        String methodArg = "";
        StringBuilder args = new StringBuilder();
        if (argObjs != null && argObjs.length > 0) {
            for (Object arg : argObjs) {
                args.append(arg.getClass()).append(JsonUtil.toJsonString(arg)).append(",");
            }
            methodArg = args.substring(0, args.length() - 1);
        }
        return methodArg;
    }

}
