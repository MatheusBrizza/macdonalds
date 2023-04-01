package com.fundatec.macdonalds.controller.advice;

import com.fundatec.macdonalds.service.exception.CamposVaziosException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CamposVaziosAdvice {
    @ResponseBody
    @ExceptionHandler(CamposVaziosException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String camposVaziosHandler(CamposVaziosException ex) {
       return ex.getMessage();
    }
}
