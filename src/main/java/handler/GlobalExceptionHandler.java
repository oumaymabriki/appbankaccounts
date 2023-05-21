package handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import Exception.ObjectToValidateExeption;
import  Exception.OperationNotPermettedException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ObjectToValidateExeption.class)
    //for expose juste the attributes not null for our clients  @JsonInclude
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handle(ObjectToValidateExeption exp){
        return  ExceptionResponse
                .builder()
                .ErrorMsg("object not valid")
                .ErrorsSources(exp.getErrorsSource())
                .build();
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handle (EntityNotFoundException exp){
        return ExceptionResponse
                .builder()
                .ErrorMsg(exp.getMessage())
                .build();
    }

    @ExceptionHandler(OperationNotPermettedException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ExceptionResponse handle (OperationNotPermettedException exp){
        return ExceptionResponse
                .builder()
                .ErrorMsg(exp.getMessage())
                .build();
    }



}
