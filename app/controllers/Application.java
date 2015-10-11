package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {


        render();
    }

    public static void formularioPersona(){
        List<Pais> paises = Pais.findAllPais();

        render(paises);}

    public static void getRegiones(Long id_pais){
        List<Region> regiones = Region.findAllRegionesByIdPais(id_pais);
        renderJSON(regiones);
    }
    public static void getProvincias(Long id_region){
        List<Provincia> provincias = Provincia.findAllProvinciasByIdRegiones(id_region);
        renderJSON(provincias);
    };

    public static void getComunas(Long id_provincia){
        List<Comuna> comunas = Comuna.findAllComunasByIdProvincias(id_provincia);
        renderJSON(comunas);
    }

}