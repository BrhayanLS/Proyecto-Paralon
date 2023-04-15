package entities;

import entities.ActualizacionPedido;
import entities.ClienteProveedor;
import entities.Empleados;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-04-01T01:12:07")
@StaticMetamodel(PedidoProduccion.class)
public class PedidoProduccion_ { 

    public static volatile SingularAttribute<PedidoProduccion, Date> fecha;
    public static volatile SingularAttribute<PedidoProduccion, ClienteProveedor> idClientePed;
    public static volatile SingularAttribute<PedidoProduccion, Empleados> idEmpleadoPed;
    public static volatile SingularAttribute<PedidoProduccion, Empleados> idConductor;
    public static volatile SingularAttribute<PedidoProduccion, Integer> valor;
    public static volatile SingularAttribute<PedidoProduccion, String> numeroFactura;
    public static volatile ListAttribute<PedidoProduccion, ActualizacionPedido> actualizacionPedidoList;
    public static volatile SingularAttribute<PedidoProduccion, Integer> idPedido;

}