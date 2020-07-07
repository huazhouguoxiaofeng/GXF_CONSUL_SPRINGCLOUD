package com.gxf.user.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 所有发生的全局异常都走这里哦
 */
@RestControllerAdvice
@Slf4j
public class CustomExtHandler {

	/*
	捕获全局异常,处理所有不可知的异常，一定要加这个注解哦
	 */
	@ExceptionHandler(value=Exception.class)
    Object handleException(Exception e,HttpServletRequest request){
		log.error("url {}, msg {}",request.getRequestURL(), e.getMessage());
		Map<String, Object> map = new HashMap<>(3);
		map.put("code", 100);
		map.put("msg", e.getMessage());
		map.put("url", request.getRequestURL());
		map.put("exception", "handleException");
		return map;
    }

	/**
	 * 功能描述：处理自定义异常
	 * @return
	 */
	@ExceptionHandler(value= MyException.class)
	Object handleMyException(MyException e, HttpServletRequest request){

//		返回json数据，由前端去判断加载什么页面
		Map<String, Object> map = new HashMap<>();
		map.put("code", e.getCode());
		map.put("msg", e.getMsg());
		map.put("url", request.getRequestURL());
		map.put("exception", "handleMyException");
		return map;

	}

}
