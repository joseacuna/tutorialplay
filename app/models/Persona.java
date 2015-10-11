package models;

import play.db.jpa.JPA;
import play.db.jpa.Model;
/**/

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by slenderman on 10-10-15.
 */
@Entity
@SequenceGenerator(name = "idAutoGen", sequenceName = "seq_persona")
public class Persona extends EntidadIdAutoLongAltKey {
    public String nombres;
    public String apellidoPaterno;
    public String apellidoMaterno;
    public String rut;
    public int genero;
    public String direccion;
    public String telefono;
    public String celular;
    @Temporal(TemporalType.TIMESTAMP)
    public Date fechaNacimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    public Comuna comuna;
    @ManyToOne(fetch = FetchType.LAZY)
    public Provincia provincia;
    @ManyToOne(fetch = FetchType.LAZY)
    public Region region;
    @ManyToOne(fetch = FetchType.LAZY)
    public Pais pais;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombreCompleto(){
        return nombres+' '+apellidoPaterno+' '+apellidoMaterno;
    }

    public Comuna getComuna() {
        return comuna;
    }

    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public static Persona findPersonaByAltKey(String altKey) {
        try{
            Persona persona= JPA.em().createQuery("select pr FROM Persona pr where pr.altKey=?1",Persona.class).setParameter(1,altKey).getSingleResult();
            return persona;
        }catch (NoResultException e){
            return null;
        }


    }
}
