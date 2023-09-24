package com.kajsoftware.movies.controllers.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MovieRestExceptionHandler {

    /*
     * EXCEPTION HANDLER FOR 'NOT FOUND'
     */
    @ExceptionHandler
    public ResponseEntity<MovieErrorResponse> handleException(MovieNotFoundException exception) {

        MovieErrorResponse error = new MovieErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    /*
     * THIS EXCEPTION HANDLER FOR ANY TYPE OF GENERIC EXCEPTION (like, passing string to the PathVariable instead of number)
     */
    @ExceptionHandler
    public ResponseEntity<MovieErrorResponse> handleException(Exception exception) {

        MovieErrorResponse error = new MovieErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
