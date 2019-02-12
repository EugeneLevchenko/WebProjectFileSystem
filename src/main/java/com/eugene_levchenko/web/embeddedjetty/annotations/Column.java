package com.eugene_levchenko.web.embeddedjetty.annotations;

import com.eugene_levchenko.web.embeddedjetty.ormController.EDataType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Column {
    String name();
    EDataType type();
}
