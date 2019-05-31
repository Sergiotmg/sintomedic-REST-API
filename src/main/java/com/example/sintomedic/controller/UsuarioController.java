package com.example.sintomedic.controller;


import com.example.sintomedic.Sintoma;
import com.example.sintomedic.UserService;
import com.example.sintomedic.Usuario;
import com.example.sintomedic.exception.SintomaNotFoundException;
import com.example.sintomedic.exception.UsuarioNotFoundException;
import com.example.sintomedic.repositorios.SintomasRepositorio;
import com.example.sintomedic.repositorios.UsuariosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UserService userService;

    UsuariosRepositorio usuariosRepositorio;
    SintomasRepositorio sintomasRepositorio;

    public UsuarioController(UserService userService) {
        this.userService = userService;
    }

    //PARA USUARIOS
    //register

    @RequestMapping("/api/register")
    @ResponseBody
    public Long register(@RequestBody Usuario user) {
        return userService.registerUser(user);
    }

    // Get All users

    @GetMapping("/usuarios")
    public List<Usuario> getAllUsers() {
        return usuariosRepositorio.findAll();
    }

    // Get a Single USER
    @GetMapping("/usuarios/{id}")
    /*public Usuario getUserById(@PathVariable(value = "id") Long id) throws Throwable {
        return usuariosRepositorio.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));
    }*/

    // Create a new USER/*
    /*@PostMapping("/usuarios")
    public Usuario createUser(@Valid @RequestBody Usuario book) {
        return usuariosRepositorio.save(book);
    }*/

    // Update a USER
    @PutMapping("/usuarios/{id}")
    public Usuario updateUser(@PathVariable(value = "id") Long id,
                              @Valid @RequestBody Usuario usuarioDetails) throws Throwable {

        Usuario usuario = (Usuario) usuariosRepositorio.findById(id).orElseThrow(() -> new UsuarioNotFoundException(id));



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


        Usuario updatedUsuario = (Usuario) usuariosRepositorio.save(usuario);

        return updatedUsuario;
    }

    // Delete a USER
    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> deleteUser(@PathVariable(value = "id") Long id) throws Throwable {
        Usuario usuario = (Usuario) usuariosRepositorio.findById(id).orElseThrow(() -> new UsuarioNotFoundException(id));


        usuariosRepositorio.delete(usuario);

        return ResponseEntity.ok().build();
    }

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
    public Sintoma getSintomaById(@PathVariable(value = "id") Long id) throws SintomaNotFoundException {
        return  sintomasRepositorio.findById(id)
                .orElseThrow(() -> new SintomaNotFoundException(id));

    }



    // Update a SINTOMA
    @PutMapping("/sintomas/{id}")
    public Sintoma updateSintoma(@PathVariable(value = "id") Long id,
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
    public ResponseEntity<?> deleteSintoma(@PathVariable(value = "id") Long id) throws SintomaNotFoundException {
        Sintoma sintoma = (Sintoma) sintomasRepositorio.findById(id).orElseThrow(() -> new SintomaNotFoundException(id));

        usuariosRepositorio.delete(sintoma);

        return ResponseEntity.ok().build();
    }
}
