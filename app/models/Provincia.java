package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

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
}
