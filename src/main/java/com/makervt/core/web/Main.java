package com.makervt.core.web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.makervt.core.domain.ResponseMessage;
import com.makervt.core.exception.AppException;

public class Main {

	public static void main(String[] args)
	{
		//PropertyUtils.loadProperty("mq.properties");
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-core.xml");
			
			System.out.println(ResponseMessage.createSuccessResponse("0003", "用戶")
					.toJSonString());
			System.out.println(ResponseMessage.createErrorResponse("1003",
					AppException.getException("1001",  new Exception("操作错误"), "用戶"))
					.toJSonString());
			System.out.println(ResponseMessage.createInfoResponse("1001", "用戶")
					.toJSonString());
			System.out.println(ResponseMessage.createErrorResponse("1001", "用戶")
					.toJSonString());
			System.out.println(ResponseMessage.createWarnResponse("1001", "用戶")
					.toJSonString());
	}
}
