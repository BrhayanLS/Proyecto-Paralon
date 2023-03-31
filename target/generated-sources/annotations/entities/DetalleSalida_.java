package entities;

import entities.ProductosInventario;
import entities.SalidaInventario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-03-31T14:57:32")
@StaticMetamodel(DetalleSalida.class)
public class DetalleSalida_ { 

    public static volatile SingularAttribute<DetalleSalida, Integer> idDetalle;
    public static volatile SingularAttribute<DetalleSalida, SalidaInventario> idSalida;
    public static volatile SingularAttribute<DetalleSalida, Integer> cantidad;
    public static volatile SingularAttribute<DetalleSalida, ProductosInventario> idProducto;

}