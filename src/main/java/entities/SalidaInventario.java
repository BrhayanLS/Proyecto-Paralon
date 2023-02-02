/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author brhay
 */
@Entity
@Table(name = "salida_inventario")
@NamedQueries({
    @NamedQuery(name = "SalidaInventario.findAll", query = "SELECT s FROM SalidaInventario s"),
    @NamedQuery(name = "SalidaInventario.findByIdSalida", query = "SELECT s FROM SalidaInventario s WHERE s.idSalida = :idSalida"),
    @NamedQuery(name = "SalidaInventario.findByFecha", query = "SELECT s FROM SalidaInventario s WHERE s.fecha = :fecha")})
public class SalidaInventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_salida")
    private Integer idSalida;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSalida", fetch = FetchType.LAZY)
    private List<DetalleSalida> detalleSalidaList;
    @JoinColumn(name = "id_empleado_sal", referencedColumnName = "id_empleados")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleados idEmpleadoSal;

    public SalidaInventario() {
    }

    public SalidaInventario(Integer idSalida) {
        this.idSalida = idSalida;
    }

    public Integer getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(Integer idSalida) {
        this.idSalida = idSalida;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<DetalleSalida> getDetalleSalidaList() {
        return detalleSalidaList;
    }

    public void setDetalleSalidaList(List<DetalleSalida> detalleSalidaList) {
        this.detalleSalidaList = detalleSalidaList;
    }

    public Empleados getIdEmpleadoSal() {
        return idEmpleadoSal;
    }

    public void setIdEmpleadoSal(Empleados idEmpleadoSal) {
        this.idEmpleadoSal = idEmpleadoSal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSalida != null ? idSalida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalidaInventario)) {
            return false;
        }
        SalidaInventario other = (SalidaInventario) object;
        if ((this.idSalida == null && other.idSalida != null) || (this.idSalida != null && !this.idSalida.equals(other.idSalida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SalidaInventario[ idSalida=" + idSalida + " ]";
    }
    
}
