package entities;

import entities.EntradaInventario;
import entities.PedidoProduccion;
import entities.Produccion;
import entities.Rol;
import entities.SalidaInventario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-03-14T22:05:34")
@StaticMetamodel(Empleados.class)
public class Empleados_ { 

    public static volatile SingularAttribute<Empleados, String> apellidos;
    public static volatile ListAttribute<Empleados, EntradaInventario> entradaInventarioList;
    public static volatile ListAttribute<Empleados, SalidaInventario> salidaInventarioList;
    public static volatile ListAttribute<Empleados, Produccion> produccionList;
    public static volatile SingularAttribute<Empleados, String> nombres;
    public static volatile ListAttribute<Empleados, PedidoProduccion> pedidoProduccionList1;
    public static volatile SingularAttribute<Empleados, Rol> idCargo;
    public static volatile SingularAttribute<Empleados, String> correo;
    public static volatile ListAttribute<Empleados, PedidoProduccion> pedidoProduccionList;
    public static volatile SingularAttribute<Empleados, Integer> idEmpleados;
    public static volatile SingularAttribute<Empleados, String> contacto1;
    public static volatile SingularAttribute<Empleados, String> contacto2;
    public static volatile SingularAttribute<Empleados, String> dni;
    public static volatile SingularAttribute<Empleados, String> contraseña;

}