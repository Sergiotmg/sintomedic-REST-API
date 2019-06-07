
package com.example.sintomedic.controller;
import com.example.sintomedic.ListaDoctores;
import com.example.sintomedic.Usuario;
import com.example.sintomedic.repositorios.ListaDoctoresRepositorio;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping({"/lista_doctores"})

public class ListaDoctoresController {


    //sin autorired, la inyeccion via constructor
    
    private ListaDoctoresRepositorio listaDoctoresRepositorio;

    public ListaDoctoresController(ListaDoctoresRepositorio listaDoctoresRepositorio) {
        this.listaDoctoresRepositorio = listaDoctoresRepositorio;
    }



    // GET 1 LISTA PACIENTES DE UN DOCTOR

    @GetMapping(path = {"/{id_doctor}"})
    public ResponseEntity<ListaDoctores> getListaDoctoresByIdDOctor(@PathVariable(value = "id_doctor")long id){
        return  listaDoctoresRepositorio.findById(id)
                .map(ListaDoctores -> ResponseEntity.ok().body(ListaDoctores))
                .orElse(ResponseEntity.notFound().build());
    }


    // CREATE NEW LISTA PACIENTES
    @PostMapping
    public ListaDoctores createListaDoctores(@Valid @RequestBody ListaDoctores ListaDoctores) {
        return listaDoctoresRepositorio.save(ListaDoctores);
    }

    // Update a LISTA PACIENTES by id DOCTOR
    @PutMapping("{id_doctor}")
    public ResponseEntity<ListaDoctores> updateUser(@PathVariable(value = "id_doctor") Long id,
                                                     @Valid @RequestBody ListaDoctores listaDetails) {
        return listaDoctoresRepositorio.findById(id)
                .map(listaDoctores -> {

                    listaDoctores.setId_paciente(listaDetails.getId_paciente());
                    listaDoctores.setIDDoctor1(listaDetails.getIDDoctor1());
                    listaDoctores.setIDDoctor2(listaDetails.getIDDoctor2());
                    listaDoctores.setIDDoctor3(listaDetails.getIDDoctor3());

                    final ListaDoctores updateListaDoctores = listaDoctoresRepositorio.save(listaDoctores);
                    return ResponseEntity.ok().body(updateListaDoctores);

                }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE LISTA PACIENTES BY ID DOCTOR
    @DeleteMapping("{id_doctor}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id_doctor") Long id)  {
        return listaDoctoresRepositorio.findById(id)
                .map(borrar -> {
                    listaDoctoresRepositorio.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
