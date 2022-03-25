package br.com.adjafsaobraz.adjaf.exceptions.handler;

import br.com.adjafsaobraz.adjaf.exceptions.ExceptionResponse;
import br.com.adjafsaobraz.adjaf.exceptions.NotFoundExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handlerAllException(Exception ex , WebRequest request){
        ExceptionResponse exeption = new ExceptionResponse(new Date(), ex.getMessage(),request.getDescription(false));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exeption);

    }
    @ExceptionHandler(NotFoundExeption.class)
    public final ResponseEntity<ExceptionResponse> handlerNotFoundException(Exception ex , WebRequest request){
        ExceptionResponse exeption = new ExceptionResponse(new Date(), ex.getMessage(),request.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exeption);

    }
}
