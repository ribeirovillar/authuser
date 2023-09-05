package com.ead.authuser.services.impl.validations;

public interface Validations<T> {
    void validate(T t) throws Exception;
}
