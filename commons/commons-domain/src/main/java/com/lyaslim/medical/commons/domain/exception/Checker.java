package com.lyaslim.medical.commons.domain.exception;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class Checker {
    private Checker() {

    }

    public static <T, R> void check(List<T> errors, T t, boolean condition) {
        if (condition) {
            errors.add(t);
        }

    }
    public static void throwException(List<String> errors){
        if (errors.size() > 0) {
            String errorMessage = errors.stream().collect(Collectors.joining(","));
            throw new InvalidEntityException(errorMessage);
        }
    }
}
