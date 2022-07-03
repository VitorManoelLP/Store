package com.project.store.configuration.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class IllegalArgumentExceptionDTO {

    private String message;
    private String name;

    public static IllegalArgumentExceptionDTO of(IllegalArgumentException exception) {

        return IllegalArgumentExceptionDTO.builder()
                .message(exception.getMessage())
                .name("Algo deu errado!")
                .build();
    }

}
