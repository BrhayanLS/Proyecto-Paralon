/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controllers;

import entities.ClienteProveedor;
import entities.Empleados;
import entities.PedidoProduccion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import services.ClienteProveedorFacade;
import services.EmpleadosFacade;
import services.PedidoProduccionFacade;

/**
 *
 * @author brhay
 */
@Named(value = "controllerPedidoProduccion")
@SessionScoped
public class ControllerPedidoProduccion implements Serializable {

    private PedidoProduccion pedido = new PedidoProduccion();
    @EJB
    private PedidoProduccionFacade pedidoFacade;
    private Empleados empleado = new Empleados();
    @EJB
    private EmpleadosFacade empleadoFacade;
    private ClienteProveedor clipro = new ClienteProveedor();
    private ClienteProveedorFacade cliproFacade;
    
    public ControllerPedidoProduccion() {
    }
    
    //CREATE
    public void guardarEmpleado(){
        try{
            pedido.setIdEmpleadoPed(empleadoFacade.find(empleado.getIdEmpleados()));
            pedidoFacade.create(pedido);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
//READ
    public List<PedidoProduccion> listaPedidos(){
        return pedidoFacade.findAll();
    }
//UPDATE
    public String actualizarPedido(PedidoProduccion e){
        this.pedido = e;
        return "ActualizarPedidos.xhtml";
    }
    
    public String actualizarPedido(){
        this.pedidoFacade.edit(pedido);
        this.pedido = pedido;
        return "ListadePedidos.xhtml";
    }
//DELETE
    public void eliminarPedido(PedidoProduccion pedido){
        this.pedidoFacade.remove(pedido);        
    }

    public PedidoProduccion getPedido() {
        return pedido;
    }

    public void setPedido(PedidoProduccion pedido) {
        this.pedido = pedido;
    }

    public PedidoProduccionFacade getPedidoFacade() {
        return pedidoFacade;
    }

    public void setPedidoFacade(PedidoProduccionFacade pedidoFacade) {
        this.pedidoFacade = pedidoFacade;
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

    public ClienteProveedor getClipro() {
        return clipro;
    }

    public void setClipro(ClienteProveedor clipro) {
        this.clipro = clipro;
    }

    public ClienteProveedorFacade getCliproFacade() {
        return cliproFacade;
    }

    public void setCliproFacade(ClienteProveedorFacade cliproFacade) {
        this.cliproFacade = cliproFacade;
    }
    
    
}
