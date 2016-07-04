package com.rainbow.packge.ocl.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by xiaojc on 2016/6/29.
 * 功能:类构造器注解
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.CONSTRUCTOR)
public @interface MyConstuctorAnnotation {
    String uri();
    String desc();
}
