package entities;

import entities.Produccion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-03-14T22:05:34")
@StaticMetamodel(ProductosProduccion.class)
public class ProductosProduccion_ { 

    public static volatile SingularAttribute<ProductosProduccion, Integer> costo;
    public static volatile SingularAttribute<ProductosProduccion, Integer> idProducto;
    public static volatile ListAttribute<ProductosProduccion, Produccion> produccionList;
    public static volatile SingularAttribute<ProductosProduccion, String> nombre;

}