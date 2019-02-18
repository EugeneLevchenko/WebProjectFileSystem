package com.eugene_levchenko.web.embeddedjetty.annotations;
import com.eugene_levchenko.web.embeddedjetty.ormController.EDataType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

public @interface ColumnSetter {
    EDataType type();
}
