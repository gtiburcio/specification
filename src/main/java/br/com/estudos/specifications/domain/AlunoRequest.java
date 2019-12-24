package br.com.estudos.specifications.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class AlunoRequest {

    @NotNull
    @Size(min = 1, max = 1)
    public String caracter;

}
