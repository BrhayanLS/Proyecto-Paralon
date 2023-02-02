/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author brhay
 */
@Entity
@Table(name = "ex_empleados")
@NamedQueries({
    @NamedQuery(name = "ExEmpleados.findAll", query = "SELECT e FROM ExEmpleados e"),
    @NamedQuery(name = "ExEmpleados.findByIdExEmpleados", query = "SELECT e FROM ExEmpleados e WHERE e.idExEmpleados = :idExEmpleados"),
    @NamedQuery(name = "ExEmpleados.findByIdEmpleadoEx", query = "SELECT e FROM ExEmpleados e WHERE e.idEmpleadoEx = :idEmpleadoEx"),
    @NamedQuery(name = "ExEmpleados.findByIdCargo", query = "SELECT e FROM ExEmpleados e WHERE e.idCargo = :idCargo"),
    @NamedQuery(name = "ExEmpleados.findByDni", query = "SELECT e FROM ExEmpleados e WHERE e.dni = :dni"),
    @NamedQuery(name = "ExEmpleados.findByNombres", query = "SELECT e FROM ExEmpleados e WHERE e.nombres = :nombres"),
    @NamedQuery(name = "ExEmpleados.findByApellidos", query = "SELECT e FROM ExEmpleados e WHERE e.apellidos = :apellidos"),
    @NamedQuery(name = "ExEmpleados.findByContacto1", query = "SELECT e FROM ExEmpleados e WHERE e.contacto1 = :contacto1"),
    @NamedQuery(name = "ExEmpleados.findByContacto2", query = "SELECT e FROM ExEmpleados e WHERE e.contacto2 = :contacto2"),
    @NamedQuery(name = "ExEmpleados.findByCorreo", query = "SELECT e FROM ExEmpleados e WHERE e.correo = :correo")})
public class ExEmpleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ex_empleados")
    private Integer idExEmpleados;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_empleado_ex")
    private int idEmpleadoEx;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cargo")
    private int idCargo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "dni")
    private String dni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "contacto1")
    private String contacto1;
    @Size(max = 15)
    @Column(name = "contacto2")
    private String contacto2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "correo")
    private String correo;

    public ExEmpleados() {
    }

    public ExEmpleados(Integer idExEmpleados) {
        this.idExEmpleados = idExEmpleados;
    }

    public ExEmpleados(Integer idExEmpleados, int idEmpleadoEx, int idCargo, String dni, String nombres, String apellidos, String contacto1, String correo) {
        this.idExEmpleados = idExEmpleados;
        this.idEmpleadoEx = idEmpleadoEx;
        this.idCargo = idCargo;
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.contacto1 = contacto1;
        this.correo = correo;
    }

    public Integer getIdExEmpleados() {
        return idExEmpleados;
    }

    public void setIdExEmpleados(Integer idExEmpleados) {
        this.idExEmpleados = idExEmpleados;
    }

    public int getIdEmpleadoEx() {
        return idEmpleadoEx;
    }

    public void setIdEmpleadoEx(int idEmpleadoEx) {
        this.idEmpleadoEx = idEmpleadoEx;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContacto1() {
        return contacto1;
    }

    public void setContacto1(String contacto1) {
        this.contacto1 = contacto1;
    }

    public String getContacto2() {
        return contacto2;
    }

    public void setContacto2(String contacto2) {
        this.contacto2 = contacto2;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExEmpleados != null ? idExEmpleados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExEmpleados)) {
            return false;
        }
        ExEmpleados other = (ExEmpleados) object;
        if ((this.idExEmpleados == null && other.idExEmpleados != null) || (this.idExEmpleados != null && !this.idExEmpleados.equals(other.idExEmpleados))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ExEmpleados[ idExEmpleados=" + idExEmpleados + " ]";
    }
    
}
