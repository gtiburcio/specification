package br.com.estudos.specifications.converter;

import br.com.estudos.specifications.domain.enumeration.TipoAluno;

import javax.persistence.AttributeConverter;
import java.util.Optional;
import java.util.stream.Stream;

public class TipoAlunoConverter implements AttributeConverter<TipoAluno, Integer> {
    @Override
    public Integer convertToDatabaseColumn(TipoAluno tipoAluno) {
        return Optional.ofNullable(tipoAluno).map(TipoAluno::getCode).orElse(null);
    }

    @Override
    public TipoAluno convertToEntityAttribute(Integer integer) {
        return Stream.of(TipoAluno.values()).filter(t -> t.getCode().equals(integer)).findFirst().orElse(null);
    }
}
