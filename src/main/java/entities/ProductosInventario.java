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
@Table(name = "productos_inventario")
@NamedQueries({
    @NamedQuery(name = "ProductosInventario.findAll", query = "SELECT p FROM ProductosInventario p"),
    @NamedQuery(name = "ProductosInventario.findByIdProducto", query = "SELECT p FROM ProductosInventario p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "ProductosInventario.findByNombre", query = "SELECT p FROM ProductosInventario p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "ProductosInventario.findByStock", query = "SELECT p FROM ProductosInventario p WHERE p.stock = :stock")})
public class ProductosInventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdProducto")
    private Integer idProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock")
    private int stock;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto", fetch = FetchType.LAZY)
    private List<DetalleSalida> detalleSalidaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto", fetch = FetchType.LAZY)
    private List<EntradaInventario> entradaInventarioList;

    public ProductosInventario() {
    }

    public ProductosInventario(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public ProductosInventario(Integer idProducto, String nombre, int stock) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.stock = stock;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<DetalleSalida> getDetalleSalidaList() {
        return detalleSalidaList;
    }

    public void setDetalleSalidaList(List<DetalleSalida> detalleSalidaList) {
        this.detalleSalidaList = detalleSalidaList;
    }

    public List<EntradaInventario> getEntradaInventarioList() {
        return entradaInventarioList;
    }

    public void setEntradaInventarioList(List<EntradaInventario> entradaInventarioList) {
        this.entradaInventarioList = entradaInventarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductosInventario)) {
            return false;
        }
        ProductosInventario other = (ProductosInventario) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ProductosInventario[ idProducto=" + idProducto + " ]";
    }
    
}
