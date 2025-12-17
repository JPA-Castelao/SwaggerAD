package org.example.Service;

import jakarta.transaction.Transactional;
import org.example.model.Alumno;
import org.example.model.Titor;
import org.example.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.AbstractList;
import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {
    private final AlumnoRepository alumnoRepository;

    @Autowired
    public AlumnoService(AlumnoRepository alumnoRepository){
        this.alumnoRepository = alumnoRepository;
    }

    @Transactional
    public Alumno crearOuActualizarAlumno(Alumno alumno){
        return alumnoRepository.save(alumno);
    }

        public List<Alumno> obterTodosOsAlumnos(){
        return alumnoRepository.findAll();
    }

    public Optional<Alumno> obterAlumnoPorId(Long id){
        return alumnoRepository.findById(id);
    }

    public Alumno actualizarAlumno(Alumno alumno){
        return alumnoRepository.save(alumno);
    }

}
