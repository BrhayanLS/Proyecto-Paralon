/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controllers;

import entities.Rol;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import services.RolFacade;

/**
 *
 * @author brhay
 */
@Named(value = "controllerRegistrarRol")
@SessionScoped
public class ControllerRegistrarRol implements Serializable {

    @EJB
    private RolFacade rolFacade;
    private Rol rol = new Rol();
    
    public ControllerRegistrarRol() {
    }
    //CREATE
    public void guardarRol(){
        rolFacade.create(rol);
    }
    //READ
    public List<Rol> listaRoles(){
        return rolFacade.findAll();
    }
    //UPDATE
     public String actualizarEmpleado(Rol e){
        this.rol = e;
        return "actualizarEmpleado.xhtml";
    }
    
    public String actualizarEmpleado(){
        this.rolFacade.edit(rol);
        this.rol = rol;
        return "empleados.xhtml";
    }
    //DELETE    
    public void eliminarRol(Rol rol){
        this.rolFacade.remove(rol);
    }

    public RolFacade getRolFacade() {
        return rolFacade;
    }

    public void setRolFacade(RolFacade rolFacade) {
        this.rolFacade = rolFacade;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    
}
