package com.example.exception.component;

import java.util.Map;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

@Component
public class ExErrorAttributes extends DefaultErrorAttributes {

	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
		Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
		// 从ExExceptionHandler中传递过来的额外异常信息，放入到errorAttributes中，供后续错误处理页面用。
		String msg = (String) webRequest.getAttribute("extErrorMsg", 0);
		errorAttributes.put("extErrorMsg", msg);
		return errorAttributes;
	}
}
