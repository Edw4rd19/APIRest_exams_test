package com.ASST.examenes.apirest.Controllers;

import java.util.List;

import com.ASST.examenes.apirest.Entities.Pregunta;
import com.ASST.examenes.apirest.Repositories.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/examen")
public class PreguntaController {

    @Autowired
    private PreguntaRepository preguntaRepository;

    @GetMapping
    public List<Pregunta> obtenerPreguntas() {
        return preguntaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pregunta obtenerPreguntasPorId(@PathVariable Long id) {
        return preguntaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró la pregunta con el ID: " + id));
    }


    /*@GetMapping("/presentar")
    public List<CrearExamen> obtenerExamen(@PathVariable Long id) {
        return preguntaRepository.findAll();
    }*/

    @PostMapping
    public Pregunta crearPregunta(@RequestBody Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    @PutMapping("/{id}")
    public Pregunta actualizarPregunta(@PathVariable Long id, @RequestBody Pregunta detallesPregunta) {
        Pregunta pregunta = preguntaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró la pregunta con el ID: " + id));

        pregunta.setNombre(detallesPregunta.getNombre());
        pregunta.setiA(detallesPregunta.getiA());
        pregunta.setiB(detallesPregunta.getiB());
        pregunta.setiC(detallesPregunta.getiC());
        pregunta.setOpD(detallesPregunta.getopD());
        pregunta.setiOk(detallesPregunta.getiOk());
        pregunta.setPuntaje(detallesPregunta.getPuntaje());

        return preguntaRepository.save(pregunta);
    }

    @DeleteMapping("/{id}")
    public String borrarPregunta(@PathVariable Long id) {
        Pregunta pregunta = preguntaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró la pregunta con el ID: " + id));

        preguntaRepository.delete(pregunta);
        return "La pregunta con el ID: " + id + " fue eliminada correctamente";
    }

}
