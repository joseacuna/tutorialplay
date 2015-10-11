package models;

import play.db.jpa.JPA;
import play.db.jpa.Model;

import javax.persistence.Entity;
import java.util.List;

/**
 * Created by slenderman on 10-10-15.
 */
@Entity
public class Pais  extends Model{
    public Integer codNum;

    public String alfaTres;

    public String alfaDos;

    public String nombre;

    public String nacionalidad;

    public Integer getCodNum() {
        return codNum;
    }

    public void setCodNum(Integer codNum) {
        this.codNum = codNum;
    }

    public String getAlfaTres() {
        return alfaTres;
    }

    public void setAlfaTres(String alfaTres) {
        this.alfaTres = alfaTres;
    }

    public String getAlfaDos() {
        return alfaDos;
    }

    public void setAlfaDos(String alfaDos) {
        this.alfaDos = alfaDos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public static List<Pais> findAllPais() {
        List<Pais> allPaises = JPA.em().createQuery("select p FROM Pais p").getResultList();
        return allPaises;
    }
}
