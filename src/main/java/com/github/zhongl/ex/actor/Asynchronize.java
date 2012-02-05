package com.github.zhongl.ex.actor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** @author <a href="mailto:zhong.lunfu@gmail.com">zhongl<a> */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Asynchronize { }
