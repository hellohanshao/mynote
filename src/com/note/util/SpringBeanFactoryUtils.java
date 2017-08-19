package com.note.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.note.model.Task;
import com.note.service.IData;

public class SpringBeanFactoryUtils implements ApplicationContextAware {

	 	private static ApplicationContext appCtx;

	    /**
	     * 此方法可以把ApplicationContext对象inject到当前类中作为一个静态成员变量。
	     *
	     */
	    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	        SpringBeanFactoryUtils.appCtx = applicationContext;
	    }

	    public static ApplicationContext getApplicationContext() {
	        return appCtx;
	    }

	    @SuppressWarnings("unchecked")
		public static Object getBean(Class cls) {
	        return appCtx.getBean(cls);
	    }

		public static <T> T getObject(Class<T> class1) {
			 return appCtx.getBean(class1);
		}
		
}
