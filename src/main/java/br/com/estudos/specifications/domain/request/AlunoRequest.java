package br.com.estudos.specifications.domain.request;

import br.com.estudos.specifications.domain.enumeration.TipoAluno;
import lombok.Data;

@Data
public class AlunoRequest {

    private String nome;

    private String email;

    private String cpf;

    private String rg;

    private String telefone;

    private String nomeMae;

    private String nomePai;

    private Long idSala;

    private TipoAluno tipoAluno;
}
