package com.fundatec.macdonalds.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PedidoJaExistenteException extends ResponseStatusException {

    public PedidoJaExistenteException(HttpStatus status, String message) { super(status, message);}
}
