package br.com.estudos.specifications.services;

import br.com.estudos.specifications.domain.Aluno;
import br.com.estudos.specifications.domain.filters.AlunoFilter;
import br.com.estudos.specifications.exceptions.AlunoNotFoundException;
import br.com.estudos.specifications.exceptions.CaracterBadRequestException;
import br.com.estudos.specifications.repositories.AlunoRepository;
import br.com.estudos.specifications.repositories.spc.AlunoSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository repository;

    public Aluno save(Aluno aluno) {
        return repository.saveAndFlush(aluno);
    }

    public List<Aluno> findAll() {
        return repository.findAll();
    }

    public Aluno findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new AlunoNotFoundException("Aluno com id ".concat(id.toString()).concat(" não foi encontrado!")));
    }

    public List<Aluno> findFilter(AlunoFilter alunoFilter) {
        return repository.findAll(new AlunoSpecification(alunoFilter));
    }

    public char convertToChar(String caracter) {
        return caracter.charAt(0);
    }

}
