package com.example.sintomedic.repositorios;

import com.example.sintomedic.ListaPacientes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ListaPacientesRepositorio extends JpaRepository<ListaPacientes, Long> {

}

