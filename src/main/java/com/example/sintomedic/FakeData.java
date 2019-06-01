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
 *
 */
public class FakeData {

    private static List<Usuario> personaList = new CopyOnWriteArrayList<>();
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    private static final String NOMBRES_APELLIDOS[][] = {

            {"sergiotmg" , "sergiotmg","foro","sergiotmg@gmail.com","Compania6",
                    "23141","5453-46734","colegiado112","11/04/1998","id-05","locura","id-pacien07"
                    ,"id-doctore06","idProximaConsul08","idSintoma-02","false","true","/img/sergiotmg.jpg",
                    "1234"},


            {"Goku" , "Cacaroto","anime","goku@megaman.com","Compania3",
                    "41454141","5453-46734","colegiado112","12/10/1988","id-04","sinTratamiento","id-pacien05"
                    ,"id-doctore03","idProximaConsul05","idSintoma-02","false","true","/img/goku.jpg",
                    "gokuContraseña"},


            {"Mega" , "Man","nintento","megaman@megaman.com","Compania1",
                    "41414141","5453-42434","colegiado111","11/11/1975","id-01","sinTratamiento","id-pacien01"
            ,"id-doctore01","idProximaConsul01","idSintoma-01","false","true","/img/megaman.jpg",
            "megaContraseña"}

    };

    private FakeData(){}

    public static List<Usuario> getUsuarioList() {
        final Usuario u = getPersona();
        final Usuario u2 = getPersona();
        final Usuario u3 = getPersona();
        final Usuario u4 = getPersona();
        final Usuario u5 = getPersona();
        final Usuario u6 = getPersona();
        Stream.of(u,u2,u3,u4,u5,u6).forEach(e -> personaList.add(e));
        return personaList;
    }

    private static Usuario getPersona() {
        final Usuario usuario = new Usuario();
        usuario.setNombre( gen(0) );
        usuario.setApellidos(gen(1));
        usuario.setLocalidad(gen(2));
        usuario.setCorreo( gen(3) );
        usuario.setCompaniaAseguradora(gen(5));
        usuario.setTelefono(( gen(5)));
        usuario.setDniNie(gen(6));
        usuario.setNumColegiado(gen(7));
        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(gen(8));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        usuario.setFechaNacimiento(date);
        usuario.setIdListaEnfermedades(gen(9));
        usuario.setTratamiento(gen(10));
        usuario.setIdListaPacientes(gen(11));
        usuario.setIdListaDoctores(gen(12));
        usuario.setIdListaProximasConsultas(gen(13));
        usuario.setIdListaSintomas(gen(14));
        usuario.setEsDoctor(Boolean.parseBoolean(gen(15)));
        usuario.setEsPaciente(Boolean.parseBoolean(gen(16)));
        usuario.setLinkFotoPerfil(gen(17));
        usuario.setContrasenia(gen(18));
        return usuario;
    }


    private static String gen(final int index) {
        return NOMBRES_APELLIDOS[SECURE_RANDOM.nextInt(NOMBRES_APELLIDOS.length - 1)][index];
    }
}