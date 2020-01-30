package br.com.estudos.specifications.domain.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoAluno {

    PRESENCIAL(20, "Presencial"),
    ONLINE(21, "ONLINE");

    private Integer code;
    private String description;
}
