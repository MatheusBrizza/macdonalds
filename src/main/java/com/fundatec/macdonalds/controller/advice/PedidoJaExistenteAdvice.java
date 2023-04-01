package com.fundatec.macdonalds.controller.advice;

import com.fundatec.macdonalds.service.exception.PedidoJaExistenteException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PedidoJaExistenteAdvice {
    @ResponseBody
    @ExceptionHandler(PedidoJaExistenteException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String pedidoJaExistenteHandler(PedidoJaExistenteException ex) {
        return ex.getMessage();
    }

}
