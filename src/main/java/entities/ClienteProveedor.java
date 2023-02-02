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
@Table(name = "cliente_proveedor")
@NamedQueries({
    @NamedQuery(name = "ClienteProveedor.findAll", query = "SELECT c FROM ClienteProveedor c"),
    @NamedQuery(name = "ClienteProveedor.findByIdClienteProveedor", query = "SELECT c FROM ClienteProveedor c WHERE c.idClienteProveedor = :idClienteProveedor"),
    @NamedQuery(name = "ClienteProveedor.findByDniNit", query = "SELECT c FROM ClienteProveedor c WHERE c.dniNit = :dniNit"),
    @NamedQuery(name = "ClienteProveedor.findByTipoProveedor", query = "SELECT c FROM ClienteProveedor c WHERE c.tipoProveedor = :tipoProveedor"),
    @NamedQuery(name = "ClienteProveedor.findByRazonSocial", query = "SELECT c FROM ClienteProveedor c WHERE c.razonSocial = :razonSocial"),
    @NamedQuery(name = "ClienteProveedor.findByRolClienteProvee", query = "SELECT c FROM ClienteProveedor c WHERE c.rolClienteProvee = :rolClienteProvee"),
    @NamedQuery(name = "ClienteProveedor.findByContacto1", query = "SELECT c FROM ClienteProveedor c WHERE c.contacto1 = :contacto1"),
    @NamedQuery(name = "ClienteProveedor.findByContacto2", query = "SELECT c FROM ClienteProveedor c WHERE c.contacto2 = :contacto2"),
    @NamedQuery(name = "ClienteProveedor.findByCorreo", query = "SELECT c FROM ClienteProveedor c WHERE c.correo = :correo"),
    @NamedQuery(name = "ClienteProveedor.findByDireccion", query = "SELECT c FROM ClienteProveedor c WHERE c.direccion = :direccion")})
public class ClienteProveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente_proveedor")
    private Integer idClienteProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "dni_nit")
    private String dniNit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tipo_proveedor")
    private String tipoProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "razon_social")
    private String razonSocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "rol_cliente_provee")
    private String rolClienteProvee;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "direccion")
    private String direccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProveedor", fetch = FetchType.LAZY)
    private List<EntradaInventario> entradaInventarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClientePed", fetch = FetchType.LAZY)
    private List<PedidoProduccion> pedidoProduccionList;

    public ClienteProveedor() {
    }

    public ClienteProveedor(Integer idClienteProveedor) {
        this.idClienteProveedor = idClienteProveedor;
    }

    public ClienteProveedor(Integer idClienteProveedor, String dniNit, String tipoProveedor, String razonSocial, String rolClienteProvee, String contacto1, String correo, String direccion) {
        this.idClienteProveedor = idClienteProveedor;
        this.dniNit = dniNit;
        this.tipoProveedor = tipoProveedor;
        this.razonSocial = razonSocial;
        this.rolClienteProvee = rolClienteProvee;
        this.contacto1 = contacto1;
        this.correo = correo;
        this.direccion = direccion;
    }

    public Integer getIdClienteProveedor() {
        return idClienteProveedor;
    }

    public void setIdClienteProveedor(Integer idClienteProveedor) {
        this.idClienteProveedor = idClienteProveedor;
    }

    public String getDniNit() {
        return dniNit;
    }

    public void setDniNit(String dniNit) {
        this.dniNit = dniNit;
    }

    public String getTipoProveedor() {
        return tipoProveedor;
    }

    public void setTipoProveedor(String tipoProveedor) {
        this.tipoProveedor = tipoProveedor;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRolClienteProvee() {
        return rolClienteProvee;
    }

    public void setRolClienteProvee(String rolClienteProvee) {
        this.rolClienteProvee = rolClienteProvee;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClienteProveedor != null ? idClienteProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteProveedor)) {
            return false;
        }
        ClienteProveedor other = (ClienteProveedor) object;
        if ((this.idClienteProveedor == null && other.idClienteProveedor != null) || (this.idClienteProveedor != null && !this.idClienteProveedor.equals(other.idClienteProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ClienteProveedor[ idClienteProveedor=" + idClienteProveedor + " ]";
    }
    
}
