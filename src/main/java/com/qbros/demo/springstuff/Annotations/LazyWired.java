package com.qbros.demo.springstuff.Annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.lang.annotation.*;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */

@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Autowired
@Lazy
@Documented
public @interface LazyWired {
}
