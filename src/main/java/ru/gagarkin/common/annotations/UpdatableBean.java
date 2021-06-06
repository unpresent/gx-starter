package ru.gagarkin.common.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * Аннотация помечает бины, которые содержат обновляемые свойства.
 *
 * @see UpdatableValue
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Inherited
@Bean
public @interface UpdatableBean {

    /**
     * Список названий бина.
     *
     * @return список
     */
    @AliasFor(value = "value", annotation = Bean.class)
    String[] name() default {};

    /**
     * Метод, который будет вызван после обновления всех свойств в бине.
     */
    String onUpdateMethod() default "";
}
