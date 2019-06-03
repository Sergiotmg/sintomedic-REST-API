package com.example.sintomedic.controller;


import com.example.sintomedic.Sintoma;
import com.example.sintomedic.exception.SintomaNotFoundException;
import com.example.sintomedic.repositorios.SintomasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 *
 * 
 *
 */
@RestController
public class SintomasController {

    @Autowired
    SintomasRepositorio sintomasRepositorio;


    //************************ SINTOMAS *****************

    // Get All SINTOMAS

    @GetMapping("/sintomas")
    public List<Sintoma> getAllSintomas() {
        return sintomasRepositorio.findAll();
    }

    // Create a new SINTOMA/*
    @PostMapping("/sintomas")
    public Sintoma createSintomas(@Valid @RequestBody Sintoma sintoma) {
        return sintomasRepositorio.save(sintoma);
    }


    // Get a Single SINTOMA
    @GetMapping("/sintomas/{id}")
    public Sintoma getSintomaById(@PathVariable(value = "id") int id) throws SintomaNotFoundException {
        return sintomasRepositorio.findById(id)
                .orElseThrow(() -> new SintomaNotFoundException(id));

    }


    // Update a SINTOMA
    @PutMapping("/sintomas/{id}")
    public Sintoma updateSintoma(@PathVariable(value = "id") int id,
                                 @Valid @RequestBody Sintoma sintomaDetails) throws SintomaNotFoundException {

        Sintoma sintoma = sintomasRepositorio.findById(id)
                .orElseThrow(() -> new SintomaNotFoundException(id));

        sintoma.setDescripcion(sintomaDetails.getDescripcion());
        // FALTAN EL RESTO!!!!!!!!!!!!


        Sintoma updateSintoma = sintomasRepositorio.save(sintoma);

        return updateSintoma;
    }

    // Delete a SINTOMA
    @DeleteMapping("/sintomas/{id}")
    public ResponseEntity<?> deleteSintoma(@PathVariable(value = "id") int id) throws SintomaNotFoundException {
        Sintoma sintoma = (Sintoma) sintomasRepositorio.findById(id).orElseThrow(() -> new SintomaNotFoundException(id));

        sintomasRepositorio.delete(sintoma);

        return ResponseEntity.ok().build();
    }
}
