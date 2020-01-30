package br.com.estudos.specifications.controller;

import br.com.estudos.specifications.domain.Sala;
import br.com.estudos.specifications.domain.request.SalaRequest;
import br.com.estudos.specifications.mapper.SalaMapper;
import br.com.estudos.specifications.services.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/salas")
public class SalaController {

    @Autowired
    private SalaService salaService;

    @Autowired
    private SalaMapper salaMapper;

    @GetMapping
    public ResponseEntity<List<Sala>> findAll() {
        List<Sala> listaSala = salaService.findAll();
        return ResponseEntity.ok(listaSala);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sala> findById(@PathVariable Long id) {
        return ResponseEntity.ok(salaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody SalaRequest sala) {
        salaService.save(salaMapper.requestToEntity(sala));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Sala sala, @PathVariable Long id) {
        sala.setId(id);
        salaService.update(sala);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        salaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
