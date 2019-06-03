package com.example.sintomedic.repositorios;

import com.example.sintomedic.EnfermedadPaciente;
import com.example.sintomedic.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnfermedadPacienteRepositorio extends JpaRepository<EnfermedadPaciente, Long> {

}

