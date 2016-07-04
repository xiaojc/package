package com.rainbow.packge.ocl.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by xiaojc on 2016/7/1.
 * 功能:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Greeting {

    public enum FontColor{RED,YELLOW,BLUE};

    String name();

    FontColor fontColor() default FontColor.RED;
}
