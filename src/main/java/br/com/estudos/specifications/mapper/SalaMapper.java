package br.com.estudos.specifications.mapper;

import br.com.estudos.specifications.domain.Sala;
import br.com.estudos.specifications.domain.request.SalaRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SalaMapper {

    Sala requestToEntity(SalaRequest request);
}
