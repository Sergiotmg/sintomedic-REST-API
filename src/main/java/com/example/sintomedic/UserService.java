package com.example.sintomedic;

import com.example.sintomedic.repositorios.UsuariosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UsuariosRepositorio userRepository;

    public UserService(UsuariosRepositorio userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<Usuario> list() {
        return userRepository.findAll();
    }


    public Usuario save(Usuario user) {
        return (Usuario) userRepository.save(user);
    }

    /*public void save(List<Usuario> users) {
        userRepository.save(users);
    }*/


    public Long registerUser(Usuario user) {
        //user.setContrasenia(new BCryptPasswordEncoder().encode(password));
        userRepository.save(user);
        return user.getId();
    }


}
