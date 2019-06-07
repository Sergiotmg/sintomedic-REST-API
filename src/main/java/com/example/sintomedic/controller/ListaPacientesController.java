package com.example.sintomedic.controller;

import com.example.sintomedic.ListaPacientes;
import com.example.sintomedic.Usuario;
import com.example.sintomedic.repositorios.UsuariosRepositorio;
import com.example.sintomedic.repositorios.ListaPacientesRepositorio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping({"/lista_pacientes"})

public class ListaPacientesController {
    private ListaPacientesRepositorio listaPacientesRepositorio;

    public ListaPacientesController(ListaPacientesRepositorio listaPacientesRepositorio) {
        this.listaPacientesRepositorio = listaPacientesRepositorio;
    }



    // GET 1 LISTA PACIENTES DE UN DOCTOR

    @GetMapping(path = {"/{id_doctor}"})
    public ResponseEntity<ListaPacientes> getListaPacientesByIdDOctor(@PathVariable(value = "id_doctor")long id){
        return  listaPacientesRepositorio.findById(id)
                .map(listaPacientes -> ResponseEntity.ok().body(listaPacientes))
                .orElse(ResponseEntity.notFound().build());
    }


    // CREATE NEW LISTA PACIENTES
    @PostMapping
    public ListaPacientes createListaPacientes(@Valid @RequestBody ListaPacientes listaPacientes) {
        return listaPacientesRepositorio.save(listaPacientes);
    }

    // Update a LISTA PACIENTES by id DOCTOR
    @PutMapping("{id_doctor}")
    public ResponseEntity<ListaPacientes> updateUser(@PathVariable(value = "id_doctor") Long id,
                                              @Valid @RequestBody ListaPacientes listaDetails) {
        return listaPacientesRepositorio.findById(id)
                .map(listaPacientes -> {

                    listaPacientes.setId_doctor(listaDetails.getId_doctor());
                    listaPacientes.setIdPaciente1(listaDetails.getIdPaciente1());
                    listaPacientes.setIdPaciente2(listaDetails.getIdPaciente2());
                    listaPacientes.setIdPaciente3(listaDetails.getIdPaciente3());
                    listaPacientes.setIdPaciente4(listaDetails.getIdPaciente4());
                    listaPacientes.setIdPaciente5(listaDetails.getIdPaciente5());

                    final ListaPacientes updateListaPacientes = listaPacientesRepositorio.save(listaPacientes);
                    return ResponseEntity.ok().body(updateListaPacientes);

                }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE LISTA PACIENTES BY ID DOCTOR
    @DeleteMapping("{id_doctor}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id_doctor") Long id)  {
        return listaPacientesRepositorio.findById(id)
                .map(borrar -> {
                    listaPacientesRepositorio.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
