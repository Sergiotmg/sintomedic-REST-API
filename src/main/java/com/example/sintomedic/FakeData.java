package com.example.sintomedic;

import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;


/**
 * Datos fake
 */
public class FakeData {

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    private static final String NOMBRES_APELLIDOS[][] = {

            {"sergiotmg", "sergiotmg", "VLC","A", "sergiotmg@gmail.com", "Compania6",
                    "23141", "5453-46734", "colegiado112", "11/04/1998", "diazepam", "01","01", "false", "/img/sergiotmg.jpg",
                    "1234"},


            {"Goku", "Cacaroto", "MIS","B", "goku@megaman.com", "Compania3",
                    "41454141", "5453-46734", "colegiado112", "12/10/1988", "sinTratamiento", "02","02","false", "/img/goku.jpg",
                    "gokuContraseña"},


            {"Mega", "Man", "MAD","C", "megaman@megaman.com", "Compania1",
                    "41414141", "5453-42434", "colegiado111", "11/11/1975", "sinTratamiento", "03","03", "false", "/img/megaman.jpg",
                    "megaContraseña"}

    };

    private FakeData() {
    }

    public static FakeData get() {
        return new FakeData();
    }

    public List<Usuario> getUsuarioList() {
        List<Usuario> personaList = new CopyOnWriteArrayList<>();
        final Usuario u = getPersona();
        final Usuario u2 = getPersona();
        final Usuario u3 = getPersona();
        final Usuario u4 = getPersona();
        final Usuario u5 = getPersona();
        final Usuario u6 = getPersona();
        Stream.of(u, u2, u3, u4, u5, u6).forEach(personaList::add);
        return personaList;
    }

    private Usuario getPersona() {
        final Usuario usuario = new Usuario();
        usuario.setNombre(gen(0));
        usuario.setApellidos(gen(1));
        usuario.setLocalidad(gen(2));
        usuario.setCentro(gen(3));
        usuario.setCorreo(gen(4));
        usuario.setCompaniaAseguradora(gen(5));
        usuario.setTelefono((gen(6)));
        usuario.setDniNie(gen(7));
        usuario.setNumColegiado(gen(8));
        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(gen(9));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        usuario.setFechaNacimiento(date);
        //usuario.setIdListaEnfermedades(gen(9));
        usuario.setTratamiento(gen(10));
        usuario.setIdListaPacientes(gen(11));
        usuario.setIdListaDoctores(gen(12));
        //usuario.setIdListaProximasConsultas(gen(13));
        //usuario.setIdListaSintomas(gen(14));
        usuario.setEsDoctor(Boolean.parseBoolean(gen(13)));
        usuario.setLinkFotoPerfil(gen(14));
        usuario.setContrasenia(gen(15));
        return usuario;
    }


    private static String gen(final int index) {
        return NOMBRES_APELLIDOS[SECURE_RANDOM.nextInt(NOMBRES_APELLIDOS.length)][index];
    }
}
