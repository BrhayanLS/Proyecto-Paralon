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
import java.util.List;
import javax.ejb.EJB;
import services.EmpleadosFacade;
import services.RolFacade;

/**
 *
 * @author brhay
 */
@Named(value = "controllerRegistrarEmpleados")
@SessionScoped
public class ControllerRegistrarEmpleados implements Serializable {

    @EJB
    private EmpleadosFacade empleadosFacade;
    private Empleados empleados = new Empleados();

    @EJB
    private RolFacade rolFacade;
    private Rol rol = new Rol();

    public ControllerRegistrarEmpleados() {
    }
//CREATE
    public String guardarEmpleado(){
        try{
            empleados.setIdCargo(rolFacade.find(rol.getIdCargo()));
            empleadosFacade.create(empleados);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "registroEmpleados.xhtml";
    }
//READ
    public List<Empleados> listaEmpleados(){
        return empleadosFacade.findAll();
    }
//UPDATE
    public String actualizarEmpleado(Empleados e){
        this.empleados = e;
        return "actualizarEmpleado.xhtml";
    }
    
    public String actualizarEmpleado(){
        rol.setIdCargo(empleados.getIdCargo().getIdCargo());
        empleados.setIdCargo(rol);
        this.empleadosFacade.edit(empleados);
        return "empleados.xhtml";
    }
//DELETE
    public void eliminarEmple(Empleados empleados){
        this.empleadosFacade.remove(empleados);        
    }
    
    /**
     * @return the empleadosFacade
     */
    public EmpleadosFacade getEmpleadosFacade() {
        return empleadosFacade;
    }

    /**
     * @param empleadosFacade the empleadosFacade to set
     */
    public void setEmpleadosFacade(EmpleadosFacade empleadosFacade) {
        this.empleadosFacade = empleadosFacade;
    }

    /**
     * @return the empleados
     */
    public Empleados getEmpleados() {
        return empleados;
    }

    /**
     * @param empleados the empleados to set
     */
    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    /**
     * @return the rolFacade
     */
    public RolFacade getRolFacade() {
        return rolFacade;
    }

    /**
     * @param rolFacade the rolFacade to set
     */
    public void setRolFacade(RolFacade rolFacade) {
        this.rolFacade = rolFacade;
    }

    /**
     * @return the rol
     */
    public Rol getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
}
