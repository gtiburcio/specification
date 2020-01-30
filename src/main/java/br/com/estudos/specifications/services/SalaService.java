package br.com.estudos.specifications.services;

import br.com.estudos.specifications.domain.Sala;
import br.com.estudos.specifications.exceptions.SalaNotFoundException;
import br.com.estudos.specifications.repositories.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    public Sala save(Sala sala) {
        return salaRepository.save(sala);
    }

    public List<Sala> findAll() {
        return salaRepository.findAll();
    }

    public Sala findById(Long id) {
        return salaRepository.findById(id).orElseThrow(() -> new SalaNotFoundException(MessageFormat.format("Sala com id {0} não foi encontrada!", id)));
    }

    public void update(Sala sala) {
        save(sala);
    }

    public void delete(Long id) {
        findById(id);
        salaRepository.deleteById(id);
    }
}
