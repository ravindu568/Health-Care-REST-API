package com.rudevelopers.healthcare.adviser;

import com.rudevelopers.healthcare.exceptions.EntryNotFoundException;
import com.rudevelopers.healthcare.utill.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWiderExceptionHandler{
    @ExceptionHandler(EntryNotFoundException.class)
    public ResponseEntity<StandardResponse> handleEntryNotFound(EntryNotFoundException e){
return new ResponseEntity<>(
        new StandardResponse(404,e.getMessage(),e), HttpStatus.NOT_FOUND
);
    }
}
