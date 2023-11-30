package com.example.quanlychua.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandel {

    // TODO Sử dụng để hiển thị ra một list các lỗi
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Map<String, List<String>>> exceptionHandel(MethodArgumentNotValidException exception) {
//        List<String> errors = exception.getBindingResult().getFieldErrors()
//                .stream().map(FieldError::getDefaultMessage).toList();
//        return new ResponseEntity<>(getMapError(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
//    }
//
//    public Map<String, List<String>> getMapError(List<String> error) {
//        Map<String, List<String>> errorResponse = new HashMap<>();
//        errorResponse.put("error", error);
//        return errorResponse;
//    }

    // TODO Lỗi nào trước hiển thị lỗi đó trước
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handlerInvalidationArgument(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return errorMap;
    }
}