package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

/**
 * Created by slenderman on 10-10-15.
 */
@Entity
public class Region extends Model{
    public String nombre;

    public String corfo;

    public String codigo;

    public Integer numero;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorfo() {
        return corfo;
    }

    public void setCorfo(String corfo) {
        this.corfo = corfo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}
