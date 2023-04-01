package com.fundatec.macdonalds.controller.advice;

import com.fundatec.macdonalds.service.exception.ListaPedidosVaziaException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ListaPedidosVaziaAdvice {

    @ResponseBody
    @ExceptionHandler(ListaPedidosVaziaException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    String listaPedidosVaziaHandler(ListaPedidosVaziaException ex) {
        return ex.getMessage();
    }
}
