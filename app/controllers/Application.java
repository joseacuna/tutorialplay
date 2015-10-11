package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {

        List<Pais> paises = Pais.findAllPais();

        render(paises);
    }

    public static void formularioPersona(){render();}

}