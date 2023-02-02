/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author brhay
 */
@Entity
@Table(name = "produccion")
@NamedQueries({
    @NamedQuery(name = "Produccion.findAll", query = "SELECT p FROM Produccion p"),
    @NamedQuery(name = "Produccion.findByIdProduccion", query = "SELECT p FROM Produccion p WHERE p.idProduccion = :idProduccion"),
    @NamedQuery(name = "Produccion.findByFecha", query = "SELECT p FROM Produccion p WHERE p.fecha = :fecha")})
public class Produccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_produccion")
    private Integer idProduccion;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "id_empleado_pro", referencedColumnName = "id_empleados")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleados idEmpleadoPro;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProductosProduccion idProducto;

    public Produccion() {
    }

    public Produccion(Integer idProduccion) {
        this.idProduccion = idProduccion;
    }

    public Integer getIdProduccion() {
        return idProduccion;
    }

    public void setIdProduccion(Integer idProduccion) {
        this.idProduccion = idProduccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Empleados getIdEmpleadoPro() {
        return idEmpleadoPro;
    }

    public void setIdEmpleadoPro(Empleados idEmpleadoPro) {
        this.idEmpleadoPro = idEmpleadoPro;
    }

    public ProductosProduccion getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(ProductosProduccion idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduccion != null ? idProduccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produccion)) {
            return false;
        }
        Produccion other = (Produccion) object;
        if ((this.idProduccion == null && other.idProduccion != null) || (this.idProduccion != null && !this.idProduccion.equals(other.idProduccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Produccion[ idProduccion=" + idProduccion + " ]";
    }
    
}
