package com.fundatec.macdonalds.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CamposVaziosException extends ResponseStatusException {

    public CamposVaziosException(HttpStatus status, String message) { super(status, message);}

}
