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
import javax.validation.constraints.NotNull;

/**
 *
 * @author brhay
 */
@Entity
@Table(name = "entrada_inventario")
@NamedQueries({
    @NamedQuery(name = "EntradaInventario.findAll", query = "SELECT e FROM EntradaInventario e"),
    @NamedQuery(name = "EntradaInventario.findByIdEntrada", query = "SELECT e FROM EntradaInventario e WHERE e.idEntrada = :idEntrada"),
    @NamedQuery(name = "EntradaInventario.findByFecha", query = "SELECT e FROM EntradaInventario e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "EntradaInventario.findByCantidad", query = "SELECT e FROM EntradaInventario e WHERE e.cantidad = :cantidad")})
public class EntradaInventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_entrada")
    private Integer idEntrada;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_cliente_proveedor")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ClienteProveedor idProveedor;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleados")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleados idEmpleado;
    @JoinColumn(name = "id_producto", referencedColumnName = "IdProducto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProductosInventario idProducto;

    public EntradaInventario() {
    }

    public EntradaInventario(Integer idEntrada) {
        this.idEntrada = idEntrada;
    }

    public EntradaInventario(Integer idEntrada, int cantidad) {
        this.idEntrada = idEntrada;
        this.cantidad = cantidad;
    }

    public Integer getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(Integer idEntrada) {
        this.idEntrada = idEntrada;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public ClienteProveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(ClienteProveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Empleados getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleados idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public ProductosInventario getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(ProductosInventario idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntrada != null ? idEntrada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntradaInventario)) {
            return false;
        }
        EntradaInventario other = (EntradaInventario) object;
        if ((this.idEntrada == null && other.idEntrada != null) || (this.idEntrada != null && !this.idEntrada.equals(other.idEntrada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.EntradaInventario[ idEntrada=" + idEntrada + " ]";
    }
    
}
