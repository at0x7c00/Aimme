package com.huqiao.smartadmin.tag.fns;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.context.WebApplicationContext;

import com.huqiao.smartadmin.i18n.MySessionLocaleRsolver;
import com.huqiao.smartadmin.listener.InitApplicationAttributeListener;

/**
 * 国际化
 * @author NOVOTS
 * @version Version 1.0
 */
public class I18nMessageGetter {

	public static String i18nMessage(HttpServletRequest request,String code){
		WebApplicationContext wac = InitApplicationAttributeListener.wac;
		ResourceBundleMessageSource messageSource  = (ResourceBundleMessageSource)wac.getBean("messageSource");
		MySessionLocaleRsolver localeResolver =(MySessionLocaleRsolver) wac.getBean("localeResolver");
		return messageSource.getMessage(code,null,localeResolver.resolveLocale(request));
	}
}
