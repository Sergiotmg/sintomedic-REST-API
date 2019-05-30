package com.example.sintomedic.repositorios;

import com.example.sintomedic.Sintoma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SintomasRepositorio extends JpaRepository<Sintoma,Long> {


}
