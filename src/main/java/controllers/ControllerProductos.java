/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controllers;

import entities.ProductosProduccion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import services.ProductosProduccionFacade;

@Named(value = "controllerProductos")
@SessionScoped
public class ControllerProductos implements Serializable {

    ProductosProduccion productos = new ProductosProduccion();
    @EJB
    ProductosProduccionFacade productosFacade;
    
    public ControllerProductos() {
    }
    
    //CREATE
    public void guardarProducto(){
        productosFacade.create(productos);
    }
    //READ
    public List<ProductosProduccion> listaProductos(){
        return productosFacade.findAll();
    }
    //UPDATE
    public String actualizarProducto (ProductosProduccion e){
        this.productos = e;
        return "ActualizarProductos";
    }
    
    public String actualizarProducto(){
        this.productosFacade.edit(productos);
        return "RegistrarProductos.xhtml";
    }
    //DELETE
    public String eliminarProducto(ProductosProduccion productos){
        this.productosFacade.remove(productos);
        return "RegistrarProductos.xhtml";
    }

    public ProductosProduccion getProductos() {
        return productos;
    }

    public void setProductos(ProductosProduccion productos) {
        this.productos = productos;
    }

    public ProductosProduccionFacade getProductosFacade() {
        return productosFacade;
    }

    public void setProductosFacade(ProductosProduccionFacade productosFacade) {
        this.productosFacade = productosFacade;
    }
    
}
