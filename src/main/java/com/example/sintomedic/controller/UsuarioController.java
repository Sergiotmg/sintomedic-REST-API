package com.example.sintomedic.controller;


import com.example.sintomedic.Usuario;
import com.example.sintomedic.exception.UsuarioNotFoundException;
import com.example.sintomedic.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    // Get All users

    @GetMapping("/usuario")
    public List<Usuario> getAllNotes() {
        return usuarioRepositorio.findAll();
    }


    // Create a new Note/*
    @PostMapping("/usuario")
    public Usuario createNote(@Valid @RequestBody Usuario book) {
        return usuarioRepositorio.save(book);
    }

    // Get a Single Note
    @GetMapping("/usuario/{id}")
    public Usuario getNoteById(@PathVariable(value = "id") Long id) throws UsuarioNotFoundException {
        return usuarioRepositorio.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));
    }

    // Update a Note
    @PutMapping("/usuario/{id}")
    public Usuario updateNote(@PathVariable(value = "id") Long id,
                               @Valid @RequestBody Usuario usuarioDetails) throws UsuarioNotFoundException {

        Usuario usuario = usuarioRepositorio.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));

        usuario.setNombre(usuarioDetails.getNombre());
        usuario.setApellidos(usuarioDetails.getApellidos());
        usuario.setCompaniaAseguradora(usuarioDetails.getCompaniaAseguradora());
        usuario.setCorreo(usuarioDetails.getCorreo());
        usuario.setDNI_NIE(usuarioDetails.getDNI_NIE());
        usuario.setId(usuarioDetails.getId());
        usuario.setLocalidad(usuarioDetails.getLocalidad());
        usuario.setTelefono(usuarioDetails.getTelefono());

        Usuario updatedUsuario = usuarioRepositorio.save(usuario);

        return updatedUsuario;
    }

    // Delete a Note
    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable(value = "id") Long id) throws UsuarioNotFoundException {
        Usuario usuario = usuarioRepositorio.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));

        usuarioRepositorio.delete(usuario);

        return ResponseEntity.ok().build();
    }
}
