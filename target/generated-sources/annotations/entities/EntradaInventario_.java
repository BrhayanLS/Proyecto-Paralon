package entities;

import entities.ClienteProveedor;
import entities.Empleados;
import entities.ProductosInventario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-01-31T20:38:08")
@StaticMetamodel(EntradaInventario.class)
public class EntradaInventario_ { 

    public static volatile SingularAttribute<EntradaInventario, Date> fecha;
    public static volatile SingularAttribute<EntradaInventario, Empleados> idEmpleado;
    public static volatile SingularAttribute<EntradaInventario, ClienteProveedor> idProveedor;
    public static volatile SingularAttribute<EntradaInventario, Integer> cantidad;
    public static volatile SingularAttribute<EntradaInventario, ProductosInventario> idProducto;
    public static volatile SingularAttribute<EntradaInventario, Integer> idEntrada;

}