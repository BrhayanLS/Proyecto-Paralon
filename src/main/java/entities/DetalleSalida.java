/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;

/**
 *
 * @author brhay
 */
@Entity
@Table(name = "detalle_salida")
@NamedQueries({
    @NamedQuery(name = "DetalleSalida.findAll", query = "SELECT d FROM DetalleSalida d"),
    @NamedQuery(name = "DetalleSalida.findByIdDetalle", query = "SELECT d FROM DetalleSalida d WHERE d.idDetalle = :idDetalle"),
    @NamedQuery(name = "DetalleSalida.findByCantidad", query = "SELECT d FROM DetalleSalida d WHERE d.cantidad = :cantidad")})
public class DetalleSalida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle")
    private Integer idDetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "id_producto", referencedColumnName = "IdProducto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProductosInventario idProducto;
    @JoinColumn(name = "id_salida", referencedColumnName = "id_salida")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SalidaInventario idSalida;

    public DetalleSalida() {
    }

    public DetalleSalida(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public DetalleSalida(Integer idDetalle, int cantidad) {
        this.idDetalle = idDetalle;
        this.cantidad = cantidad;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public ProductosInventario getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(ProductosInventario idProducto) {
        this.idProducto = idProducto;
    }

    public SalidaInventario getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(SalidaInventario idSalida) {
        this.idSalida = idSalida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalle != null ? idDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleSalida)) {
            return false;
        }
        DetalleSalida other = (DetalleSalida) object;
        if ((this.idDetalle == null && other.idDetalle != null) || (this.idDetalle != null && !this.idDetalle.equals(other.idDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DetalleSalida[ idDetalle=" + idDetalle + " ]";
    }
    
}
