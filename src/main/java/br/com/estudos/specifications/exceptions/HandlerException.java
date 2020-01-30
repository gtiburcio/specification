package br.com.estudos.specifications.exceptions;

import br.com.estudos.specifications.exceptions.model.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class HandlerException {

    @ExceptionHandler(AlunoNotFoundException.class)
    @ResponseBody
    public ResponseEntity<ExceptionResponse> alunoNotFoundException(AlunoNotFoundException alunoNotFoundException) {
        return ResponseEntity.status(NOT_FOUND).body(ExceptionResponse.builder()
                .code(NOT_FOUND.value())
                .status(NOT_FOUND.getReasonPhrase())
                .date(LocalDateTime.now())
                .description(alunoNotFoundException.getMsg())
                .build());
    }

    @ExceptionHandler(SalaNotFoundException.class)
    @ResponseBody
    public ResponseEntity<ExceptionResponse> salaNotFoundException(SalaNotFoundException ex) {
        return ResponseEntity.status(NOT_FOUND).body(ExceptionResponse.builder()
                .code(NOT_FOUND.value())
                .status(NOT_FOUND.getReasonPhrase())
                .date(LocalDateTime.now())
                .description(ex.getMessage())
                .build());
    }
}
