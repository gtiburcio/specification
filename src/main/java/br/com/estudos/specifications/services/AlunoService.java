package br.com.estudos.specifications.services;

import br.com.estudos.specifications.domain.Aluno;
import br.com.estudos.specifications.domain.Sala;
import br.com.estudos.specifications.domain.filters.AlunoFilter;
import br.com.estudos.specifications.exceptions.AlunoNotFoundException;
import br.com.estudos.specifications.repositories.AlunoRepository;
import br.com.estudos.specifications.repositories.spc.AlunoSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository repository;

    private final SalaService salaService;

    public Aluno save(Aluno aluno) {
        salaService.findById(aluno.getSala().getId());
        return repository.save(aluno);
    }

    public List<Aluno> findAll() {
        return repository.findAll();
    }

    public Aluno findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new AlunoNotFoundException(MessageFormat.format("O aluno com id {0} não foi encontrado.", id)));
    }

    public List<Aluno> findFilter(AlunoFilter alunoFilter) {
        return repository.findAll(new AlunoSpecification(alunoFilter));
    }

    public Sala convertToSala(Long id) {
        Sala sala = new Sala();
        sala.setId(id);
        return sala;
    }
}
