package com.example.sintomedic.controller;


import com.example.sintomedic.Usuario;
import com.example.sintomedic.repositorios.UsuariosRepositorio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Para acceder a los datos necesitamos esto un controller
 */
@RestController
@RequestMapping({"/usuarios"})
public class UsuarioController {

    //sin autorired, la inyeccion via constructor
    private UsuariosRepositorio usuariosRepositorio;

    public UsuarioController(UsuariosRepositorio usuariosRepositorio) {
       this.usuariosRepositorio = usuariosRepositorio;
    }


    // Get All users

    @GetMapping
    public List<Usuario> findAll() {
        return usuariosRepositorio.findAll();
    }

    // Get a Single USER

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Usuario> getUserById(@PathVariable(value = "id")long id){
        return  usuariosRepositorio.findById(id)
                .map(usuario -> ResponseEntity.ok().body(usuario))
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new USER
    @PostMapping
    public Usuario createUser(@Valid @RequestBody Usuario usuario) {
        return usuariosRepositorio.save(usuario);
    }

    // Update a USER by id
    @PutMapping("{id}")
    public ResponseEntity<Usuario> updateUser(@PathVariable(value = "id") Long id,
                                              @Valid @RequestBody Usuario usuarioDetails) {
        return usuariosRepositorio.findById(id)
            .map(usuario -> {

                usuario.setNombre(usuarioDetails.getNombre());
                usuario.setApellidos(usuarioDetails.getApellidos());
                usuario.setCompaniaAseguradora(usuarioDetails.getCompaniaAseguradora());
                usuario.setCorreo(usuarioDetails.getCorreo());
                usuario.setDniNie(usuarioDetails.getDniNie());
                usuario.setLocalidad(usuarioDetails.getLocalidad());
                usuario.setTelefono(usuarioDetails.getTelefono());
                usuario.setNumColegiado(usuarioDetails.getNumColegiado());
                usuario.setFechaNacimiento(usuarioDetails.getFechaNacimiento());
                usuario.setTratamiento(usuarioDetails.getTratamiento());

                usuario.setIdListaDoctores(usuarioDetails.getIdListaDoctores());
                usuario.setIdListaPacientes(usuarioDetails.getIdListaPacientes());

                usuario.setEsDoctor(usuarioDetails.getEsDoctor());
                usuario.setLinkFotoPerfil(usuarioDetails.getLinkFotoPerfil());
                usuario.setContrasenia(usuarioDetails.getContrasenia());
                final Usuario updateUsuario = usuariosRepositorio.save(usuario);
                return ResponseEntity.ok().body(updateUsuario);

            }).orElse(ResponseEntity.notFound().build());
    }

    // Delete a USER by id
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long id)  {
        return usuariosRepositorio.findById(id)
                .map(borrar -> {
                    usuariosRepositorio.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
