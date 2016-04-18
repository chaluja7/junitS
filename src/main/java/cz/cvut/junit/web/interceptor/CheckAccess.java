package cz.cvut.junit.web.interceptor;

import java.lang.annotation.*;

/**
 * Vlastni anotace pro kontrolu pristupu k metodam.
 *
 * @author jakubchalupa
 * @since 03.03.15
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Inherited
@Documented
public @interface CheckAccess {

    /**
     * nutne role pro pristup
     */
    String[] value() default {};

}
