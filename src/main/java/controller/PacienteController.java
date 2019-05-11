package controller;

import exception.PacienteNotFoundException;
import com.example.sintomedic.Paciente;
import repositorios.PacienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import java.util.List;

@RestController
public class PacienteController {

    @Autowired
    PacienteRepositorio pacienteRepositorio;

    // Get All Notes
    @GetMapping("/books")
    public List<Paciente> getAllNotes() {
        return pacienteRepositorio.findAll();
    }

    // Create a new Note
    @PostMapping("/books")
    public Paciente createNote(@Valid @RequestBody Paciente book) {
        return pacienteRepositorio.save(book);
    }

    // Get a Single Note
    @GetMapping("/books/{id}")
    public Paciente getNoteById(@PathVariable(value = "id") Long id) throws PacienteNotFoundException {
        return pacienteRepositorio.findById(id)
                .orElseThrow(() -> new PacienteNotFoundException(id));
    }

    // Update a Note
    @PutMapping("/books/{id}")
    public Paciente updateNote(@PathVariable(value = "id") Long id,
                           @Valid @RequestBody Paciente pacienteDetails) throws PacienteNotFoundException {

        Paciente paciente = pacienteRepositorio.findById(id)
                .orElseThrow(() -> new PacienteNotFoundException(id));

        paciente.setNombre(pacienteDetails.getNombre());
        paciente.setApellidos(pacienteDetails.getApellidos());
        paciente.setCompaniaAseguradora(pacienteDetails.getCompaniaAseguradora());
        paciente.setCorreo(pacienteDetails.getCorreo());
        paciente.setDNI_NIE(pacienteDetails.getDNI_NIE());
        paciente.setId(pacienteDetails.getId());
        paciente.setLocalidad(pacienteDetails.getLocalidad());
        paciente.setTelefono(pacienteDetails.getTelefono());

        Paciente updatedPaciente = pacienteRepositorio.save(paciente);

        return updatedPaciente;
    }

    // Delete a Note
    @DeleteMapping("/pacientes/{id}")
    public ResponseEntity<?> deletePaciente(@PathVariable(value = "id") Long id) throws PacienteNotFoundException {
        Paciente paciente = pacienteRepositorio.findById(id)
                .orElseThrow(() -> new PacienteNotFoundException(id));

        pacienteRepositorio.delete(paciente);

        return ResponseEntity.ok().build();
    }
}