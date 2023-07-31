package br.com.victor;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)

public @interface Tabela {

    String value();

}
