package org.example.Service;

import jakarta.transaction.Transactional;
import org.example.model.Titor;
import org.example.repository.TitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TitorService {
    private final TitorRepository titorRepository;

    @Autowired
    public TitorService(TitorRepository titorRepository) {
        this.titorRepository = titorRepository;
    }

    @Transactional
    public Titor crearOuActualizarTitor(Titor titor){
        return titorRepository.save(titor);
    }

    public List<Titor> obterTodosOsTitores(){
        return titorRepository.findAll();
    }

    public Optional<Titor> obterTitorPorId(Long id){
        return titorRepository.findById(id);
    }
}
