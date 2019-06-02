package com.example.sintomedic;

import com.example.sintomedic.repositorios.UsuariosRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.IntStream;

@SpringBootApplication
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

    @Bean
    CommandLineRunner iniciar(final UsuariosRepositorio usuariosRepositorio) {
        return param -> {
            usuariosRepositorio.deleteAll();
            final FakeData fakeData = FakeData.get();
            IntStream.range(0,fakeData.getUsuarioList().size())
                    .mapToObj(numero -> fakeData.getUsuarioList().get(numero))
                    .map(usuariosRepositorio::save)
                    .forEach(System.out::println);
        };
    }

}