package com.gxf.user.handler;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.gxf.common.entity.MsgResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
@Slf4j
public class ResponseBodyHandler implements ResponseBodyAdvice<Object> {

    /**
     * 判断是否执行 beforeBodyWrite 方法，true 为执行，false 为不执行
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return MappingJackson2HttpMessageConverter.class.isAssignableFrom(converterType);
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class aClass,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {

        if (Unpackaged.class.isAssignableFrom(methodParameter.getParameterType())) {
            log.info("不经过三段式");
            response.getHeaders().set("famffmaf", StringPool.ZERO);
            return body;
        }
        MsgResponse msgResponse = new MsgResponse();
        msgResponse.setCode(HttpStatus.OK.value());
        msgResponse.setMsg(HttpStatus.OK.name());
        msgResponse.setData(body);
        return msgResponse;
    }
}
