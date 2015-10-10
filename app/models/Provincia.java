package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

/**
 * Created by slenderman on 10-10-15.
 */
@Entity
public class Provincia extends Model {
    public String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
