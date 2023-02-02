/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.ClienteProveedor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author brhay
 */
@Stateless
public class ClienteProveedorFacade extends AbstractFacade<ClienteProveedor> {

    @PersistenceContext(unitName = "com.my_Proyecto_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteProveedorFacade() {
        super(ClienteProveedor.class);
    }
    
    public ClienteProveedor listaClientes() {
        ClienteProveedor clientePro = null;
        try {
            Query query = em.createQuery("SELECT * FROM ClienteProveedor c WHERE c.rolClienteProvee = :Cliente");
            List<ClienteProveedor> lista = query.getResultList();
            if (!lista.isEmpty()) {
                clientePro = lista.get(0);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return clientePro;
    }
}
