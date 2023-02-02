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
@Table(name = "productos_produccion")
@NamedQueries({
    @NamedQuery(name = "ProductosProduccion.findAll", query = "SELECT p FROM ProductosProduccion p"),
    @NamedQuery(name = "ProductosProduccion.findByIdProducto", query = "SELECT p FROM ProductosProduccion p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "ProductosProduccion.findByNombre", query = "SELECT p FROM ProductosProduccion p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "ProductosProduccion.findByCosto", query = "SELECT p FROM ProductosProduccion p WHERE p.costo = :costo")})
public class ProductosProduccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_producto")
    private Integer idProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo")
    private int costo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto", fetch = FetchType.LAZY)
    private List<Produccion> produccionList;

    public ProductosProduccion() {
    }

    public ProductosProduccion(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public ProductosProduccion(Integer idProducto, String nombre, int costo) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.costo = costo;
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

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
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
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductosProduccion)) {
            return false;
        }
        ProductosProduccion other = (ProductosProduccion) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ProductosProduccion[ idProducto=" + idProducto + " ]";
    }
    
}
