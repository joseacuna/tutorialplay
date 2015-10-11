package controllers;

import play.*;
import play.data.binding.As;
import play.db.jpa.JPA;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        List<Persona> personas = Persona.findAll();
        render(personas);
    }

    public static void formularioPersona(){
        List<Pais> paises = Pais.findAllPais();

        render(paises);}

    public static void formularioEditarPersona(String altKey){
        Persona persona =Persona.findPersonaByAltKey(altKey);
        List<Pais> paises = Pais.findAllPais();
        render(persona,paises);
    }

    public static void getRegiones(Long id_pais){
        List<Region> regiones = Region.findAllRegionesByIdPais(id_pais);
        renderJSON(regiones);
    }
    public static void getProvincias(Long id_region){
        List<Provincia> provincias = Provincia.findAllProvinciasByIdRegiones(id_region);
        renderJSON(provincias);
    }

    public static void getComunas(Long id_provincia){
        List<Comuna> comunas = Comuna.findAllComunasByIdProvincias(id_provincia);
        renderJSON(comunas);
    }

    public static void guardarPersona(Persona persona,@As("dd-MM-yyyy") Date fechaNacimiento,Long pais,Long region,Long provincia,Long comuna){
        persona.setPais(JPA.em().getReference(Pais.class, pais));
        persona.setRegion(JPA.em().getReference(Region.class, region));
        persona.setProvincia(JPA.em().getReference(Provincia.class, provincia));
        persona.setComuna(JPA.em().getReference(Comuna.class, comuna));
        persona.setFechaNacimiento(fechaNacimiento);
        persona.save();
        index();
    }

    public static void eliminarPersona(String altKey){
        Persona persona = Persona.findPersonaByAltKey(altKey);
        persona.delete();
        index();

    }

}