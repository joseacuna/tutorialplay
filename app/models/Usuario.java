package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

/**
 * Created by slenderman on 10-10-15.
 */
@Entity
public class Usuario extends Model{
    public String usuario;

    public String password;

    public String email;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
