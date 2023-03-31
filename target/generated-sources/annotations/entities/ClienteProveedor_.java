package entities;

import entities.EntradaInventario;
import entities.PedidoProduccion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-03-31T14:57:32")
@StaticMetamodel(ClienteProveedor.class)
public class ClienteProveedor_ { 

    public static volatile SingularAttribute<ClienteProveedor, Integer> idClienteProveedor;
    public static volatile ListAttribute<ClienteProveedor, EntradaInventario> entradaInventarioList;
    public static volatile SingularAttribute<ClienteProveedor, String> tipoProveedor;
    public static volatile SingularAttribute<ClienteProveedor, String> razonSocial;
    public static volatile SingularAttribute<ClienteProveedor, String> rolClienteProvee;
    public static volatile SingularAttribute<ClienteProveedor, String> correo;
    public static volatile SingularAttribute<ClienteProveedor, String> direccion;
    public static volatile SingularAttribute<ClienteProveedor, String> dniNit;
    public static volatile ListAttribute<ClienteProveedor, PedidoProduccion> pedidoProduccionList;
    public static volatile SingularAttribute<ClienteProveedor, String> contacto1;
    public static volatile SingularAttribute<ClienteProveedor, String> contacto2;

}