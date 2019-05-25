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
        //usuario.setId(usuarioDetails.getId()); no cambiar id nunca
        usuario.setLocalidad(usuarioDetails.getLocalidad());
        usuario.setTelefono(usuarioDetails.getTelefono());
        usuario.setNum_colegiado(usuarioDetails.getNum_colegiado());
        usuario.setFecha_nacimiento(usuarioDetails.getFecha_nacimiento());
        usuario.setTratamiento(usuarioDetails.getTratamiento());
        usuario.setId_lista_doctores(usuarioDetails.getId_lista_doctores());
        usuario.setId_lista_pacientes(usuarioDetails.getId_lista_pacientes());
        usuario.setId_lista_proximas_consultas(usuarioDetails.getId_lista_proximas_consultas());
        usuario.setId_lista_sintomas(usuarioDetails.getId_lista_sintomas());
        usuario.setEs_doctor(usuarioDetails.getEs_doctor());
        usuario.setEs_paciente(usuarioDetails.getEs_paciente());
        usuario.setLink_foto_perfil(usuarioDetails.getLink_foto_perfil());
        usuario.setContrasenia(usuarioDetails.getContrasenia());


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
