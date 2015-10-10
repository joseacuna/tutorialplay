package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by slenderman on 10-10-15.
 */
@Entity
public class Comuna extends Model{
    public String nombre;
    @ManyToOne
    public Provincia provincia;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
