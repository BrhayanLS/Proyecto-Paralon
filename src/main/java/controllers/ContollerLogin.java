/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controllers;

import entities.Empleados;
import entities.Rol;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import services.EmpleadosFacade;

/**
 *
 * @author brhay
 */
@Named(value = "contollerLogin")
@SessionScoped
public class ContollerLogin implements Serializable {

    private Empleados empleAcceso = new Empleados();
    @EJB
    private EmpleadosFacade empleAccesoFacade;
    private String password;
    private String dniEmple;
    
    public ContollerLogin() {
    }

    public Empleados getEmpleAcceso() {
        return empleAcceso;
    }

    public void setEmpleAcceso(Empleados empleAcceso) {
        this.empleAcceso = empleAcceso;
    }

    public EmpleadosFacade getEmpleAccesoFacade() {
        return empleAccesoFacade;
    }

    public void setEmpleAccesoFacade(EmpleadosFacade empleAccesoFacade) {
        this.empleAccesoFacade = empleAccesoFacade;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDniEmple() {
        return dniEmple;
    }

    public void setDniEmple(String dniEmple) {
        this.dniEmple = dniEmple;
    }
    
    public String iniciarSesion() {
        System.out.println("Verificando Usuario");
        String redireccion = null;
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            empleAcceso = empleAccesoFacade.inicioSesion(dniEmple, password);
            if (empleAcceso != null) {
                context.getExternalContext().getSessionMap().put("usuario", empleAcceso);
                 redireccion = redireccionEmpleados(empleAcceso.getIdCargo());
            } else {
                redireccion = "index.xhtml";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return redireccion;
    }
    
    public String redireccionEmpleados(Rol rol) {
        switch (rol.getCargo()) {
            case "Administrador":
                return "administracion/administracion.xhtml";
            case "Jefe Produccion":
                return "produccion/produccion.xhtml";
            case "Jefe Inventario":
                return "inventario/InicioInventario.xhtml";
            default:
                return "index.xhtml";

        }
    }
}
