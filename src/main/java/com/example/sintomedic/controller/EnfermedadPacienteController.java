package com.example.sintomedic.controller;

import com.example.sintomedic.EnfermedadPaciente;
import com.example.sintomedic.EnfermedadPaciente;
import com.example.sintomedic.repositorios.EnfermedadPacienteRepositorio;
import com.example.sintomedic.repositorios.EnfermedadPacienteRepositorio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping({"/enfermedad_de_paciente"})

public class EnfermedadPacienteController {

    private EnfermedadPacienteRepositorio enfermedadPacienteRepositorio;

    public EnfermedadPacienteController(EnfermedadPacienteRepositorio enfermedadPacienteRepositorio) {
        this.enfermedadPacienteRepositorio = enfermedadPacienteRepositorio;
    }


    // GET ENFERMEDADES DE 1 PACIENTES

    @GetMapping(path = {"/{id_doctor}"})
    public ResponseEntity<EnfermedadPaciente> getEnfermedadPacienteByIdDOctor(@PathVariable(value = "id_doctor")long id){
        return  enfermedadPacienteRepositorio.findById(id)
                .map(EnfermedadPaciente -> ResponseEntity.ok().body(EnfermedadPaciente))
                .orElse(ResponseEntity.notFound().build());
    }


    // CREATE NEW enfermedad PACIENTE
    @PostMapping
    public EnfermedadPaciente createEnfermedadPaciente(@Valid @RequestBody EnfermedadPaciente EnfermedadPaciente) {
        return enfermedadPacienteRepositorio.save(EnfermedadPaciente);
    }

    // Update a ENFERMEDAD PACIENTES by id PACIENTE
    @PutMapping("{id_usuario}")
    public ResponseEntity<EnfermedadPaciente> updateUser(@PathVariable(value = "id_usuario") Long id,
                                                    @Valid @RequestBody EnfermedadPaciente listaDetails) {
        return enfermedadPacienteRepositorio.findById(id)
                .map(enfermedadPaciente -> {

                    enfermedadPaciente.setDescripcion(listaDetails.getDescripcion());
                    enfermedadPaciente.setFecha_inicio(listaDetails.getFecha_inicio());
                    enfermedadPaciente.setFecha_fin(listaDetails.getFecha_fin());
                    enfermedadPaciente.setId_usuario(listaDetails.getId_usuario());
                    enfermedadPaciente.setNombre(listaDetails.getNombre());

                    final EnfermedadPaciente updateEnfermedadPaciente = enfermedadPacienteRepositorio.save(enfermedadPaciente);
                    return ResponseEntity.ok().body(updateEnfermedadPaciente);

                }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE LISTA PACIENTES BY ID DOCTOR
    @DeleteMapping("{id_doctor}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id_doctor") Long id)  {
        return enfermedadPacienteRepositorio.findById(id)
                .map(borrar -> {
                    enfermedadPacienteRepositorio.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
