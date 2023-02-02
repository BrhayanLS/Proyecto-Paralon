/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author brhay
 */
@Entity
@Table(name = "empleados")
@NamedQueries({
    @NamedQuery(name = "Empleados.findAll", query = "SELECT e FROM Empleados e"),
    @NamedQuery(name = "Empleados.findByIdEmpleados", query = "SELECT e FROM Empleados e WHERE e.idEmpleados = :idEmpleados"),
    @NamedQuery(name = "Empleados.findByDni", query = "SELECT e FROM Empleados e WHERE e.dni = :dni"),
    @NamedQuery(name = "Empleados.findByNombres", query = "SELECT e FROM Empleados e WHERE e.nombres = :nombres"),
    @NamedQuery(name = "Empleados.findByApellidos", query = "SELECT e FROM Empleados e WHERE e.apellidos = :apellidos"),
    @NamedQuery(name = "Empleados.findByContacto1", query = "SELECT e FROM Empleados e WHERE e.contacto1 = :contacto1"),
    @NamedQuery(name = "Empleados.findByContacto2", query = "SELECT e FROM Empleados e WHERE e.contacto2 = :contacto2"),
    @NamedQuery(name = "Empleados.findByCorreo", query = "SELECT e FROM Empleados e WHERE e.correo = :correo")})
public class Empleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empleados")
    private Integer idEmpleados;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "dni")
    private String dni;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "contrase\u00f1a")
    private String contraseña;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleado", fetch = FetchType.LAZY)
    private List<EntradaInventario> entradaInventarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConductor", fetch = FetchType.LAZY)
    private List<PedidoProduccion> pedidoProduccionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleadoPed", fetch = FetchType.LAZY)
    private List<PedidoProduccion> pedidoProduccionList1;
    @JoinColumn(name = "id_cargo", referencedColumnName = "id_cargo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Rol idCargo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleadoSal", fetch = FetchType.LAZY)
    private List<SalidaInventario> salidaInventarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleadoPro", fetch = FetchType.LAZY)
    private List<Produccion> produccionList;

    public Empleados() {
    }

    public Empleados(Integer idEmpleados) {
        this.idEmpleados = idEmpleados;
    }

    public Empleados(Integer idEmpleados, String dni, String contraseña, String nombres, String apellidos, String contacto1, String correo) {
        this.idEmpleados = idEmpleados;
        this.dni = dni;
        this.contraseña = contraseña;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.contacto1 = contacto1;
        this.correo = correo;
    }

    public Integer getIdEmpleados() {
        return idEmpleados;
    }

    public void setIdEmpleados(Integer idEmpleados) {
        this.idEmpleados = idEmpleados;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
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

    public List<EntradaInventario> getEntradaInventarioList() {
        return entradaInventarioList;
    }

    public void setEntradaInventarioList(List<EntradaInventario> entradaInventarioList) {
        this.entradaInventarioList = entradaInventarioList;
    }

    public List<PedidoProduccion> getPedidoProduccionList() {
        return pedidoProduccionList;
    }

    public void setPedidoProduccionList(List<PedidoProduccion> pedidoProduccionList) {
        this.pedidoProduccionList = pedidoProduccionList;
    }

    public List<PedidoProduccion> getPedidoProduccionList1() {
        return pedidoProduccionList1;
    }

    public void setPedidoProduccionList1(List<PedidoProduccion> pedidoProduccionList1) {
        this.pedidoProduccionList1 = pedidoProduccionList1;
    }

    public Rol getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Rol idCargo) {
        this.idCargo = idCargo;
    }

    public List<SalidaInventario> getSalidaInventarioList() {
        return salidaInventarioList;
    }

    public void setSalidaInventarioList(List<SalidaInventario> salidaInventarioList) {
        this.salidaInventarioList = salidaInventarioList;
    }

    public List<Produccion> getProduccionList() {
        return produccionList;
    }

    public void setProduccionList(List<Produccion> produccionList) {
        this.produccionList = produccionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleados != null ? idEmpleados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.idEmpleados == null && other.idEmpleados != null) || (this.idEmpleados != null && !this.idEmpleados.equals(other.idEmpleados))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Empleados[ idEmpleados=" + idEmpleados + " ]";
    }
    
}
