package models;

import play.db.jpa.JPA;
import play.db.jpa.Model;

import javax.persistence.*;

/**
 * Created by slenderman on 10-10-15.
 */
@Entity
@SequenceGenerator(name = "idAutoGen", sequenceName = "seq_usuario")
public class Usuario extends EntidadIdAutoLongAltKey{
    public String usuario;

    public String password;

    public String email;
    @ManyToOne(cascade = CascadeType.ALL)
    public Persona persona;

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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public static Usuario findUsuarioByAltKey(String altKey) {
        try{
            Usuario usuario= JPA.em().createQuery("select us FROM Usuario us where us.altKey=?1",Usuario.class).setParameter(1,altKey).getSingleResult();
            return usuario;
        }catch (NoResultException e){
            return null;
        }


    }

    public static Usuario findUsuarioByAltKeyPersona(String altKey) {

        try{
            Usuario usuario= JPA.em().createQuery("select us FROM Usuario us inner join Persona per on us.persona.id = per.id where per.altKey=?1",Usuario.class).setParameter(1,altKey).getSingleResult();
            return usuario;
        }catch (NoResultException e){
            return null;
        }
    }
}
