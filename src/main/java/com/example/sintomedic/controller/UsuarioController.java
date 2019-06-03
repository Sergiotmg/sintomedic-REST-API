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

    //PARA USUARIOS
    //register

    /*@RequestMapping("/api/register")
    @ResponseBody
    public Long register(@RequestBody Usuario user) {
       return usuariosRepositorio.registerUser(user);
    }*/

    // Get All users

    @GetMapping
    public List<Usuario> findAll() {
        return usuariosRepositorio.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Usuario> getUserById(@PathVariable(value = "id") long id) {
        return usuariosRepositorio.findById(id)
                .map(usuario -> ResponseEntity.ok().body(usuario))
                .orElse(ResponseEntity.notFound().build());

    }

    //Crear nuevo usuario
    @PostMapping
    public Usuario createUser(@Valid @RequestBody Usuario usuario) {
        return usuariosRepositorio.save(usuario);
    }

    //Actualizar usuario por id
    @PutMapping("{id}")
    public ResponseEntity<Usuario> updateUser(@PathVariable(value = "id") Long id,
                                              @Valid @RequestBody Usuario usuarioDetails)  {

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
                    usuario.setEsDoctor(usuarioDetails.getEsDoctor());
                    usuario.setLinkFotoPerfil(usuarioDetails.getLinkFotoPerfil());
                    usuario.setContrasenia(usuarioDetails.getContrasenia());
                    final Usuario updatedUsuario = usuariosRepositorio.save(usuario);
                    return ResponseEntity.ok().body(updatedUsuario);
                }).orElse(ResponseEntity.notFound().build());

    }

    //Borrar usuario por id
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long id) {
        return usuariosRepositorio.findById(id)
                .map(borrar -> {
                    usuariosRepositorio.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
