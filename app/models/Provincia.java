package models;

import play.db.jpa.JPA;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.List;

/**
 * Created by slenderman on 10-10-15.
 */
@Entity
public class Provincia extends Model {
    public String nombre;

    @ManyToOne
    public Region region;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public static List<Provincia> findAllProvinciasByIdRegiones(Long id_region) {
        List<Provincia> provincias = JPA.em().createQuery("select pr from Provincia pr where pr.region.id=?1").setParameter(1,id_region).getResultList();
        return provincias;
    }
}
