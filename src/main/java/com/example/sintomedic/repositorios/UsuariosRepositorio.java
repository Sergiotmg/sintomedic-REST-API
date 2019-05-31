package com.example.sintomedic.repositorios;

import com.example.sintomedic.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuariosRepositorio<usuario> extends JpaRepository<Usuario, Long> {
    public Usuario findByDniAndPassword(String dni, String password);

    String get_pacientes_de_un_doctor = "FROM lista_pacientes_de_doctor WHERE id = :id_doctor";
    @Query(get_pacientes_de_un_doctor)
    Optional<List<Usuario>> findUsuarioById(int id);







}
