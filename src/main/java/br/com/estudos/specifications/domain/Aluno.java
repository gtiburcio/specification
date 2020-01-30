package br.com.estudos.specifications.domain;

import br.com.estudos.specifications.converter.TipoAlunoConverter;
import br.com.estudos.specifications.domain.enumeration.TipoAluno;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "aluno")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Aluno {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String cpf;

    private String rg;

    private String telefone;

    private String nomeMae;

    private String nomePai;

    @Convert(converter = TipoAlunoConverter.class)
    private TipoAluno tipoAluno;

    @ManyToOne
    @JoinColumn(name = "id_sala")
    @JsonIgnore
    private Sala sala;
}
