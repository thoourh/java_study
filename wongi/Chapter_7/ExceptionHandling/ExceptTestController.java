package dev.thoourh.jpa;

import dev.thoourh.jpa.exception.BaseException;
import dev.thoourh.jpa.exception.ErrorResponseDto;
import dev.thoourh.jpa.exception.PostNotInBoardException;
import dev.thoourh.jpa.exception.PostNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("except")
public class ExceptTestController {
    @GetMapping("{id}")
    public void throwException(@PathVariable int id) {
        switch (id) {
            case 1:
                throw new PostNotExistException();
            case 2:
                throw new PostNotInBoardException();
            default:
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @ExceptionHandler(BaseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDto handleBaseException(BaseException exception){
        return new ErrorResponseDto(exception.getMessage());
    }
}
