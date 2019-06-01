package com.example.sintomedic.repositorios;

import com.example.sintomedic.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuariosRepositorio extends JpaRepository<Usuario, Integer> {
    public Usuario findById(int id);
    public Usuario findByIdAndDni(int id,String dni_nie);
    //public Usuario findByDniAndPassword(String dni, String password);

   /*FALLA ESA QUERY

   String get_pacientes_de_un_doctor = "FROM lista_pacientes_de_doctor WHERE id = :id_doctor";
    @Query(get_pacientes_de_un_doctor)
    Optional<Usuario> findById(int id);*/







}
