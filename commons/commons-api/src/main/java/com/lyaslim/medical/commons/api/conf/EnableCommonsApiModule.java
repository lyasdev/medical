package com.lyaslim.medical.commons.api.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import(CommonsApiConf.class)
@Configuration
public @interface EnableCommonsApiModule {

}
