package com.ASST.examenes.apirest.Controllers;

import com.ASST.examenes.apirest.Entities.Alumno;
import com.ASST.examenes.apirest.Repositories.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @GetMapping
    public List<Alumno> obtenerAlumnos() {
        return alumnoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Alumno obtenerAlumnoPorId(@PathVariable Long id) {
        return alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró alumno con el ID: " + id));
    }

    @PostMapping
    public Alumno crearAlumno(@RequestBody Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @PutMapping("/{id}")
    public Alumno actualizarAlumno(@PathVariable Long id, @RequestBody Alumno detallesAlumno) {
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el alumno con el ID: " + id));
        alumno.setNombre(detallesAlumno.getNombre());
        alumno.setEdad(detallesAlumno.getEdad());
        alumno.setCiudad(detallesAlumno.getCiudad());
        return alumnoRepository.save(alumno);
    }

    @DeleteMapping("/{id}")
    public String borrarAlumno(@PathVariable Long id) {
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el alumno con el ID: " + id));

        alumnoRepository.delete(alumno);
        return "El alumno con el ID: " + id + " fue eliminado correctamente";
    }
}
