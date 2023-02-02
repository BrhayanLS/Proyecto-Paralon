/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Empleados;
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
public class EmpleadosFacade extends AbstractFacade<Empleados> {

    @PersistenceContext(unitName = "com.my_Proyecto_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpleadosFacade() {
        super(Empleados.class);
    }

    public Empleados inicioSesion(String dniEmpleado, String password) {
        Empleados empleados = null;
        try {
            Query query = em.createQuery("SELECT e FROM Empleados e WHERE e.dni = :dniEmpleado AND e.contraseña = :password");
            query.setParameter("dniEmpleado", dniEmpleado);
            query.setParameter("password", password);
            List<Empleados> lista = query.getResultList();
            if (!lista.isEmpty()) {
                empleados = lista.get(0);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return empleados;
    }
}
