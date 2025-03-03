package br.com.pistorio.exception;

import java.util.Date;

public record ExceptionResponse(String timestamp, String message, String details) {

}
