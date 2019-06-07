package com.example.sintomedic.controller;


import com.example.sintomedic.Sintoma;
import com.example.sintomedic.Usuario;
import com.example.sintomedic.exception.SintomaNotFoundException;
import com.example.sintomedic.repositorios.SintomasRepositorio;
import com.example.sintomedic.repositorios.UsuariosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping({"/sintomas"})
public class SintomasController {


    SintomasRepositorio sintomasRepositorio;

    public SintomasController(SintomasRepositorio sintomasRepositorio) {
        this.sintomasRepositorio = sintomasRepositorio;
    }


    //************************ SINTOMAS *****************

    // Get All SINTOMAS

    @GetMapping
    public List<Sintoma> getAllSintomas() {
        return sintomasRepositorio.findAll();
    }


    public ResponseEntity<Sintoma> getSintomaById(@PathVariable(value = "id") long id)  {
        return sintomasRepositorio.findById(id)
                .map(sintoma -> ResponseEntity.ok().body(sintoma))
                .orElse(ResponseEntity.notFound().build());

    }

    // Create a new SINTOMA
    @PostMapping
    public Sintoma createUser(@Valid @RequestBody Sintoma sintoma) {
        return sintomasRepositorio.save(sintoma);
    }

    // Update SINTOMA by id
    @PutMapping("{id}")
    public ResponseEntity<Sintoma> updateSintoma(@PathVariable(value = "id") Long id,
                                              @Valid @RequestBody Sintoma sintomaDetails) {
        return sintomasRepositorio.findById(id)
                .map(sintoma -> {

                    sintoma.setDescripcion(sintomaDetails.getDescripcion());
                    sintoma.setIdPaciente(sintomaDetails.getIdPaciente());
                    sintoma.setFechaHora(sintomaDetails.getFechaHora());
                    sintoma.setPresionArterialAlta(sintomaDetails.getPresionArterialAlta());
                    sintoma.setPresionArterialBaja(sintomaDetails.getPresionArterialBaja());
                    sintoma.setPulso(sintomaDetails.getPulso());
                    sintoma.setTemperatura(sintomaDetails.getTemperatura());

                    final Sintoma updateSintoma = sintomasRepositorio.save(sintoma);
                    return ResponseEntity.ok().body(updateSintoma);

                }).orElse(ResponseEntity.notFound().build());
    }
    // Delete a Sintoma by id
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteSintoma(@PathVariable(value = "id") Long id)  {
        return sintomasRepositorio.findById(id)
                .map(borrar -> {
                    sintomasRepositorio.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }



}
