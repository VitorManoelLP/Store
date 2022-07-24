package com.project.store.utils;

import org.junit.Test;

import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidationUtilsTest {

    @Test
    public void throwObjectNull() {

        Long id = null;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> ValidationUtils.handlerIllegalWithCondition(Objects.isNull(id), "identificador nulo"));

        assertThat(exception.getMessage(), equalTo("identificador nulo"));
    }

}
