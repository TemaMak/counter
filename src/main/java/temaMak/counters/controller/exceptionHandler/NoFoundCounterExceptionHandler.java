package temaMak.counters.controller.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import temaMak.counters.exception.NoFoundCounterException;

@ControllerAdvice
public class NoFoundCounterExceptionHandler {

    @ExceptionHandler(value = NoFoundCounterException.class)
    protected ResponseEntity handle(RuntimeException ex) {
        return ResponseEntity
           .status(HttpStatus.NOT_FOUND).build();
    }
}
