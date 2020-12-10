package com.gxf.user.back.handler;

import com.gxf.common.entity.MsgResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

//@RestControllerAdvice
//public class JsonBackHandler implements ResponseBodyAdvice<Object> {

    /**
     * 判断是否执行 beforeBodyWrite 方法，true 为执行，false 为不执行
     */
//    @Override
//    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
//        System.out.println("returnType::::" + returnType);
//        return MappingJackson2HttpMessageConverter.class.isAssignableFrom(converterType);
////        return true;
//    }

//    @Override
//    public Object beforeBodyWrite(Object o,
//                                  MethodParameter methodParameter,
//                                  MediaType mediaType,
//                                  Class aClass,
//                                  ServerHttpRequest serverHttpRequest,
//                                  ServerHttpResponse serverHttpResponse) {
//        System.out.println("caocaocao");
//        MsgResponse msgResponse = new MsgResponse();
//        msgResponse.setCode(HttpStatus.OK.value());
//        msgResponse.setMsg(HttpStatus.OK.name());
//        msgResponse.setData(o);
//        return msgResponse;
//    }
//}
