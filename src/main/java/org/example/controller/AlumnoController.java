
package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.example.Service.AlumnoService;
import org.example.model.Alumno;
import org.example.model.Titor;
import org.example.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AlumnoController.MAPPING)
public class AlumnoController {

    public static final String MAPPING = "/alumno";

    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private AlumnoService alumnoService;

    @Operation(summary = "Crear un novo alumno")
    @PostMapping("/alumno")
    public Alumno crearAlumno(@RequestBody Alumno alumno){
        return alumnoService.crearOuActualizarAlumno(alumno);
    }

    @Operation(summary = "Obter todos os alumnos")
    @GetMapping("/alumnos")
    public List<Alumno> obtenerTodosOsAlumnos(){
        return alumnoService.obterTodosOsAlumnos();
    }

    @Operation(summary = "Actualizar un alumno")
    @PutMapping("/alumno/{id}")
        public ResponseEntity<Alumno> actualizarAlumno(@PathVariable Long id, @RequestBody Alumno alumnoDetails) {
        Optional<Alumno> alumnoOptional = alumnoService.obterAlumnoPorId(id);
        if (alumnoOptional.isPresent()) {
            Alumno alumno = alumnoOptional.get();
            alumno.setNome(alumnoDetails.getNome());
            alumno.setApelidos(alumnoDetails.getApelidos());
            Alumno alumnoActualizado = alumnoService.crearOuActualizarAlumno(alumno);
            return ResponseEntity.ok(alumnoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Eliminar un alumno")
    @DeleteMapping("/alumno/{id}")
    public ResponseEntity<Void> eliminarAlumno(@PathVariable Long id){
        if(alumnoRepository.existsById(id)){
            alumnoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Obter alumno por ID")
    @GetMapping("/alumno/{id}")
    public ResponseEntity<Alumno> obtenerAlumnoPorId(@PathVariable Long id) {
        Optional<Alumno> alumno = alumnoService.obterAlumnoPorId(id);
        return alumno.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
