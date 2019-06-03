package com.example.sintomedic.repositorios;

import com.example.sintomedic.ListaDoctores;
import com.example.sintomedic.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ListaDoctoresRepositorio extends JpaRepository<ListaDoctores, Long> {

}

