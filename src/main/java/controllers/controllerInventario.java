/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controllers;

import entities.ProductosInventario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import services.ProductosInventarioFacade;

/**
 *
 * @author LENOVO
 */
@Named(value = "controllerInventario")
@SessionScoped
public class controllerInventario implements Serializable {

    /**
     * Creates a new instance of controllerInventario
     */
    @EJB
    private ProductosInventarioFacade inventarioFacade;
    private ProductosInventario inventario = new ProductosInventario();
    private String mensaje;

    public controllerInventario() {
    }

    ///CREATE 
    public void guardar() {
        try {
            getInventarioFacade().create(getInventario());
            setMensaje("Registro guardado");
        } catch (Exception e) {
            e.printStackTrace();
            this.setMensaje("Error " + e.getMessage());

        }
        FacesMessage mens = new FacesMessage(this.getMensaje());
        FacesContext.getCurrentInstance().addMessage(null, mens);
    }

    ///LISTAR
    public List<ProductosInventario> getAllProductosInventario() {
 
        return inventarioFacade.findAll();
    }

    /**
     * @return the inventarioFacade
     */
    public ProductosInventarioFacade getInventarioFacade() {
        return inventarioFacade;
    }

    /**
     * @param inventarioFacade the inventarioFacade to set
     */
    public void setInventarioFacade(ProductosInventarioFacade inventarioFacade) {
        this.inventarioFacade = inventarioFacade;
    }

    /**
     * @return the inventario
     */
    public ProductosInventario getInventario() {
        return inventario;
    }

    /**
     * @param inventario the inventario to set
     */
    public void setInventario(ProductosInventario inventario) {
        this.inventario = inventario;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
