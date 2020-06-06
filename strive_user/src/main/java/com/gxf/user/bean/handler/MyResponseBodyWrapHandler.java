package com.gxf.user.bean.handler;

import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
public class MyResponseBodyWrapHandler implements HandlerMethodReturnValueHandler{

    private final HandlerMethodReturnValueHandler delegate;

    public MyResponseBodyWrapHandler(HandlerMethodReturnValueHandler delegate){

        this.delegate = delegate;

    }

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {

        return delegate.supportsReturnType(returnType);

    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest) throws Exception {
        RtnMsg rtnMsg = null;
        if(returnValue instanceof RtnMsg){
            rtnMsg = (RtnMsg)returnValue;
        }else{
            rtnMsg = new RtnMsg(RtnCode.STATUS_OK,"",returnValue);
        }

        delegate.handleReturnValue(rtnMsg, returnType, mavContainer, webRequest);;


    }

}
