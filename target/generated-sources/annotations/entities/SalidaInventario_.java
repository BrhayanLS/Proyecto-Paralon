package entities;

import entities.DetalleSalida;
import entities.Empleados;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-03-30T22:58:40")
@StaticMetamodel(SalidaInventario.class)
public class SalidaInventario_ { 

    public static volatile SingularAttribute<SalidaInventario, Date> fecha;
    public static volatile SingularAttribute<SalidaInventario, Empleados> idEmpleadoSal;
    public static volatile SingularAttribute<SalidaInventario, Integer> idSalida;
    public static volatile ListAttribute<SalidaInventario, DetalleSalida> detalleSalidaList;

}