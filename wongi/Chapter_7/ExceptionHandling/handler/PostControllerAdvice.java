package dev.thoourh.jpa.handler;

import dev.thoourh.jpa.exception.BaseException;
import dev.thoourh.jpa.exception.ErrorResponseDto;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class PostControllerAdvice {
    @ExceptionHandler(BaseException.class)
    public @ResponseBody ErrorResponseDto handleException(BaseException exception) {
        return new ErrorResponseDto(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponseDto handleValidException(
            MethodArgumentNotValidException exception
    ){
        return new ErrorResponseDto((exception.getMessage());
    }
}
