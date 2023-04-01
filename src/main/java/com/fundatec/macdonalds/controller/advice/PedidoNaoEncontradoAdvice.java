package com.fundatec.macdonalds.controller.advice;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fundatec.macdonalds.service.exception.PedidoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class PedidoNaoEncontradoAdvice {

    @ResponseBody
    @ExceptionHandler(PedidoNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String pedidoNaoEncontradoHandler(PedidoNaoEncontradoException ex) {
        return ex.getMessage();
    }

}
