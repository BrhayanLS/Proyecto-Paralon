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
import javax.validation.constraints.Size;

/**
 *
 * @author brhay
 */
@Entity
@Table(name = "actualizacion_pedido")
@NamedQueries({
    @NamedQuery(name = "ActualizacionPedido.findAll", query = "SELECT a FROM ActualizacionPedido a"),
    @NamedQuery(name = "ActualizacionPedido.findByIdActualizacion", query = "SELECT a FROM ActualizacionPedido a WHERE a.idActualizacion = :idActualizacion"),
    @NamedQuery(name = "ActualizacionPedido.findByFecha", query = "SELECT a FROM ActualizacionPedido a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "ActualizacionPedido.findByIdEmpleadoAntes", query = "SELECT a FROM ActualizacionPedido a WHERE a.idEmpleadoAntes = :idEmpleadoAntes"),
    @NamedQuery(name = "ActualizacionPedido.findByIdClienteAntes", query = "SELECT a FROM ActualizacionPedido a WHERE a.idClienteAntes = :idClienteAntes"),
    @NamedQuery(name = "ActualizacionPedido.findByNumFacturaAntes", query = "SELECT a FROM ActualizacionPedido a WHERE a.numFacturaAntes = :numFacturaAntes"),
    @NamedQuery(name = "ActualizacionPedido.findByValorAntes", query = "SELECT a FROM ActualizacionPedido a WHERE a.valorAntes = :valorAntes"),
    @NamedQuery(name = "ActualizacionPedido.findByIdConductorAntes", query = "SELECT a FROM ActualizacionPedido a WHERE a.idConductorAntes = :idConductorAntes")})
public class ActualizacionPedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_actualizacion")
    private Integer idActualizacion;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_empleado_antes")
    private int idEmpleadoAntes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cliente_antes")
    private int idClienteAntes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "num_factura_antes")
    private String numFacturaAntes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_antes")
    private int valorAntes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_conductor_antes")
    private int idConductorAntes;
    @JoinColumn(name = "id_pedido_act", referencedColumnName = "id_pedido")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PedidoProduccion idPedidoAct;

    public ActualizacionPedido() {
    }

    public ActualizacionPedido(Integer idActualizacion) {
        this.idActualizacion = idActualizacion;
    }

    public ActualizacionPedido(Integer idActualizacion, int idEmpleadoAntes, int idClienteAntes, String numFacturaAntes, int valorAntes, int idConductorAntes) {
        this.idActualizacion = idActualizacion;
        this.idEmpleadoAntes = idEmpleadoAntes;
        this.idClienteAntes = idClienteAntes;
        this.numFacturaAntes = numFacturaAntes;
        this.valorAntes = valorAntes;
        this.idConductorAntes = idConductorAntes;
    }

    public Integer getIdActualizacion() {
        return idActualizacion;
    }

    public void setIdActualizacion(Integer idActualizacion) {
        this.idActualizacion = idActualizacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdEmpleadoAntes() {
        return idEmpleadoAntes;
    }

    public void setIdEmpleadoAntes(int idEmpleadoAntes) {
        this.idEmpleadoAntes = idEmpleadoAntes;
    }

    public int getIdClienteAntes() {
        return idClienteAntes;
    }

    public void setIdClienteAntes(int idClienteAntes) {
        this.idClienteAntes = idClienteAntes;
    }

    public String getNumFacturaAntes() {
        return numFacturaAntes;
    }

    public void setNumFacturaAntes(String numFacturaAntes) {
        this.numFacturaAntes = numFacturaAntes;
    }

    public int getValorAntes() {
        return valorAntes;
    }

    public void setValorAntes(int valorAntes) {
        this.valorAntes = valorAntes;
    }

    public int getIdConductorAntes() {
        return idConductorAntes;
    }

    public void setIdConductorAntes(int idConductorAntes) {
        this.idConductorAntes = idConductorAntes;
    }

    public PedidoProduccion getIdPedidoAct() {
        return idPedidoAct;
    }

    public void setIdPedidoAct(PedidoProduccion idPedidoAct) {
        this.idPedidoAct = idPedidoAct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActualizacion != null ? idActualizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActualizacionPedido)) {
            return false;
        }
        ActualizacionPedido other = (ActualizacionPedido) object;
        if ((this.idActualizacion == null && other.idActualizacion != null) || (this.idActualizacion != null && !this.idActualizacion.equals(other.idActualizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ActualizacionPedido[ idActualizacion=" + idActualizacion + " ]";
    }
    
}
