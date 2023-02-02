/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controllers;

import entities.ExEmpleados;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import services.ExEmpleadosFacade;

/**
 *
 * @author brhay
 */
@Named(value = "controllerExempleados")
@SessionScoped
public class ControllerExempleados implements Serializable {

    private ExEmpleados exempleados = new ExEmpleados();
    @EJB
    private ExEmpleadosFacade exempleFacade;
    
    public ControllerExempleados() {
    }
//READ
    public List<ExEmpleados> listaEx(){
        return exempleFacade.findAll();
    }
    
    public ExEmpleados getExempleados() {
        return exempleados;
    }

    public void setExempleados(ExEmpleados exempleados) {
        this.exempleados = exempleados;
    }

    public ExEmpleadosFacade getExempleFacade() {
        return exempleFacade;
    }

    public void setExempleFacade(ExEmpleadosFacade exempleFacade) {
        this.exempleFacade = exempleFacade;
    }
    
    
    
}
