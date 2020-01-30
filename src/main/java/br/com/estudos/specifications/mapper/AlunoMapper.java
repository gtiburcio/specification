package br.com.estudos.specifications.mapper;

import br.com.estudos.specifications.domain.Aluno;
import br.com.estudos.specifications.domain.Sala;
import br.com.estudos.specifications.domain.request.AlunoRequest;
import br.com.estudos.specifications.services.AlunoService;
import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface AlunoMapper {

    @Mapping(target = "sala", expression = "java( alunoService.convertToSala(alunoRequest.getIdSala()))")
    Aluno requestToEntity(AlunoRequest alunoRequest, @Context AlunoService alunoService);
}
