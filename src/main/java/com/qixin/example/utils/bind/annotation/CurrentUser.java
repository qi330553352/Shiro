package com.qixin.example.utils.bind.annotation;

import com.qixin.example.utils.Constants;

import java.lang.annotation.*;

/** 绑定当前登录的用户
 * 文    件     名： CurrentUser
 * 包           名： com.qixin.example.utils.bind.annotation
 * 创  建   时  间： 2018/1/18 14:47
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 * 公           司: 广州专利保姆有限公司
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {

    String value() default Constants.CURRENT_USER;
}
