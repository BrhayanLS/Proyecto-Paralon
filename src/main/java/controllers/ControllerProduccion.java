package controllers;

import entities.Empleados;
import entities.Produccion;
import entities.ProductosProduccion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import services.EmpleadosFacade;
import services.ProduccionFacade;
import services.ProductosProduccionFacade;

@Named(value = "controllerProduccion")
@SessionScoped
public class ControllerProduccion implements Serializable {

    private Produccion produc = new Produccion();
    @EJB
    private ProduccionFacade producFacade;
    private Empleados empleado = new Empleados();
    @EJB
    private EmpleadosFacade empleadoFacade;
    private ProductosProduccion producPro = new ProductosProduccion();
    @EJB
    private ProductosProduccionFacade producProFacade;
    
    
    public ControllerProduccion() {
    }
    
    //CREATE
    public String guardarProduccion(){
        try {
            produc.setIdEmpleadoPro(empleadoFacade.find(empleado.getIdEmpleados()));
            produc.setIdProducto(producProFacade.find(producPro.getIdProducto()));
            producFacade.create(produc);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "RegistrarProduccion.xhtml";
    }
    
    //READ
    public List<Produccion> listaProduccion(){
        return producFacade.findAll();
    }
    
    //UPDATE
    
    
    //DELETE
    public String eliminarProduccion(Produccion produc){
        this.producFacade.remove(produc);
        return "RegistrarProduccion.xhtml";
    }
    
    public Produccion getProduc() {
        return produc;
    }

    public void setProduc(Produccion produc) {
        this.produc = produc;
    }

    public ProduccionFacade getProducFacade() {
        return producFacade;
    }

    public void setProducFacade(ProduccionFacade producFacade) {
        this.producFacade = producFacade;
    }

    public Empleados getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }

    public EmpleadosFacade getEmpleadoFacade() {
        return empleadoFacade;
    }

    public void setEmpleadoFacade(EmpleadosFacade empleadoFacade) {
        this.empleadoFacade = empleadoFacade;
    }

    public ProductosProduccion getProducPro() {
        return producPro;
    }

    public void setProducPro(ProductosProduccion producPro) {
        this.producPro = producPro;
    }

    public ProductosProduccionFacade getProducProFacade() {
        return producProFacade;
    }

    public void setProducProFacade(ProductosProduccionFacade producProFacade) {
        this.producProFacade = producProFacade;
    }
}
