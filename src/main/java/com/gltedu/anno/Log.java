package com.gltedu.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 巩乐天
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)//注解运行时有效
@Target(ElementType.METHOD)//作用在方法上
public @interface Log {

}
