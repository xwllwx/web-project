package com.xwl.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

//当前注解什么时候生效
@Retention(RetentionPolicy.RUNTIME)
//当前注解作用在哪些地方
@Target(ElementType.METHOD)
public @interface Log {
}
