package com.example.sintomedic.controller;


import com.example.sintomedic.Usuario;
import com.example.sintomedic.exception.UsuarioNotFoundException;
import com.example.sintomedic.repositorios.UsuariosRepositorio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Para acceder a los datos necesitamos esto un controller
 */
@RestController
public class UsuarioController {

    //sin autorired, la inyeccion via constructor
    private UsuariosRepositorio usuariosRepositorio;

    public UsuarioController(UsuariosRepositorio usuariosRepositorio) {
       this.usuariosRepositorio = usuariosRepositorio;
    }

    //PARA USUARIOS
    //register

    /*@RequestMapping("/api/register")
    @ResponseBody
    public Long register(@RequestBody Usuario user) {
       return usuariosRepositorio.registerUser(user);
    }*/

    // Get All users

    @GetMapping("/usuarios")
    public List<Usuario> getAllUsers() {
        return usuariosRepositorio.findAll();
    }


    // Get a Single USER
    //@GetMapping("/usuarios/{id}")
    @GetMapping(path = {"/{id}"})
    public Usuario getUserById(@PathVariable(value = "id") long id) throws UsuarioNotFoundException {
        return usuariosRepositorio.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));
    }

    // Create a new USER/*
    @PostMapping("/usuarios")
    public Usuario createUser(@Valid @RequestBody Usuario usuario) {
        return usuariosRepositorio.save(usuario);
    }

    // Update a USER
    @PutMapping("/usuarios/{id}")
    public Usuario updateUser(@PathVariable(value = "id") Long id,
                              @Valid @RequestBody Usuario usuarioDetails) throws UsuarioNotFoundException {

        Usuario usuario = usuariosRepositorio.findById(id).
                orElseThrow(() -> new UsuarioNotFoundException(id));


        usuario.setNombre(usuarioDetails.getNombre());
        usuario.setApellidos(usuarioDetails.getApellidos());
        usuario.setCompaniaAseguradora(usuarioDetails.getCompaniaAseguradora());
        usuario.setCorreo(usuarioDetails.getCorreo());
        usuario.setDniNie(usuarioDetails.getDniNie());
        //usuario.setId(usuarioDetails.getId()); no cambiar id nunca, tal cual XD
        usuario.setLocalidad(usuarioDetails.getLocalidad());
        usuario.setTelefono(usuarioDetails.getTelefono());
        usuario.setNumColegiado(usuarioDetails.getNumColegiado());
        usuario.setFechaNacimiento(usuarioDetails.getFechaNacimiento());
        usuario.setTratamiento(usuarioDetails.getTratamiento());
        usuario.setIdListaDoctores(usuarioDetails.getIdListaDoctores());
        usuario.setIdListaPacientes(usuarioDetails.getIdListaPacientes());
        usuario.setIdListaProximasConsultas(usuarioDetails.getIdListaProximasConsultas());
        usuario.setIdListaSintomas(usuarioDetails.getIdListaSintomas());
        usuario.setEsDoctor(usuarioDetails.getEsDoctor());
        usuario.setLinkFotoPerfil(usuarioDetails.getLinkFotoPerfil());
        usuario.setContrasenia(usuarioDetails.getContrasenia());


        Usuario updatedUsuario = usuariosRepositorio.save(usuario);

        return updatedUsuario;
    }

    // Delete a USER
    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long id) throws Throwable {
        return usuariosRepositorio.findById(id)
                .map(borrar -> {
                    usuariosRepositorio.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
