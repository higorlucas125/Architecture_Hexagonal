package com.hexagonal.create_app_hexagonal.adapters.persistence.utils;

public class EnumsMapper {
    public static <T extends Enum<T>, U extends Enum<U>> U mapEnum(T source, Class<U> targetClass) {
        return source == null ? null : Enum.valueOf(targetClass, source.name());
    }
}
