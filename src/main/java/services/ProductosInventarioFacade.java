/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.ProductosInventario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author brhay
 */
@Stateless
public class ProductosInventarioFacade extends AbstractFacade<ProductosInventario> {

    @PersistenceContext(unitName = "com.my_Proyecto_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductosInventarioFacade() {
        super(ProductosInventario.class);
    }
    
    public List<ProductosInventario> ventas() throws SQLException {
        List<ProductosInventario> lista = null;
        ResultSet rs;
        Connection cn = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto?user=root&password=root");
            
            PreparedStatement st = cn.prepareStatement("SELECT nombre, stock FROM productos_inventario");
            
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()){
                ProductosInventario proIn = new ProductosInventario();
                proIn.setNombre(rs.getString("Nombre"));
                proIn.setStock(rs.getInt("Stock"));
                lista.add(proIn);
            }
            rs.close();
        } catch (ClassNotFoundException | SQLException e) {
            
        }
        return lista;
    }
}
