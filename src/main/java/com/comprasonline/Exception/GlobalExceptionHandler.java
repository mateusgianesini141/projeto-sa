package com.comprasonline.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Usuário
    @ExceptionHandler(UsuarioException.class)
    public ResponseEntity<Object> handleUsuarioException(UsuarioException ex) {
        return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    // Loja
    @ExceptionHandler(LojaException.class)
    public ResponseEntity<Object> handleLojaException(LojaException ex) {
        return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    // Compra Online
    @ExceptionHandler(CompraOnlineException.class)
    public ResponseEntity<Object> handleCompraOnlineException(CompraOnlineException ex) {
        return buildResponse(HttpStatus.CONFLICT, ex.getMessage());
    }

    // Exceções não esperadas
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneralException(Exception ex) {
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno no servidor: " + ex.getMessage());
    }

    // MÉTODO UTILITÁRIO
    private ResponseEntity<Object> buildResponse(HttpStatus status, String message) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", status.value());
        body.put("erro", message);
        body.put("timestamp", LocalDateTime.now());

        return ResponseEntity.status(status).body(body);
    }
}
