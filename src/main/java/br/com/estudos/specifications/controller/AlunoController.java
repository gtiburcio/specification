package br.com.estudos.specifications.controller;

import br.com.estudos.specifications.domain.Aluno;
import br.com.estudos.specifications.domain.filters.AlunoFilter;
import br.com.estudos.specifications.services.AlunoService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @GetMapping("/")
    @ApiOperation("Buscar todos os aluno")
    public ResponseEntity<List<Aluno>> findAll() {
        return ResponseEntity.ok(alunoService.findAll());
    }

    @GetMapping("/{id}")
    @ApiOperation("Buscar aluno por id")
    public ResponseEntity<Aluno> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(alunoService.findById(id));
    }

    @PostMapping("/")
    @ApiOperation("Salvar um aluno")
    public ResponseEntity<Void> saveAluno(@RequestBody Aluno aluno) {
        aluno = alunoService.save(aluno);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(aluno.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    @ApiOperation("Atualizar um aluno")
    public ResponseEntity<Void> updateAluno(@PathVariable("id") Long id, @RequestBody Aluno aluno) {
        alunoService.findById(id);
        aluno.setId(id);
        alunoService.save(aluno);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/filter")
    public ResponseEntity<List<Aluno>> filtrarAlunos(@RequestBody AlunoFilter alunoFilter) {
        return ResponseEntity.ok(alunoService.findFilter(alunoFilter));
    }

}
