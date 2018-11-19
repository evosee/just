package com.my.lang;

import jdk.nashorn.internal.runtime.logging.Logger;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Logger
public @interface TestAn {
}
