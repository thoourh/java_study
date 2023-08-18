package dev.thoourh.jpa.exception;

import dev.thoourh.jpa.PostDto;

public abstract class BaseException extends RuntimeException{
    public BaseException(String message) {
        super(message);
    }

    public BaseException() {

    }
}
