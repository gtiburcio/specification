package br.com.estudos.specifications.domain.filters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoFilter {

    private String nome;

    private String email;

    private String cpf;

    private String rg;

    private String telefone;
}
