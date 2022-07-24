package com.project.store.utils;

public final class ValidationUtils {

    private ValidationUtils() {
    }

    public static void handlerIllegalWithCondition(Boolean condition, String message) {

        if (condition) {
            throw new IllegalArgumentException(message);
        }

    }

}
