/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controllers;

import entities.ActualizacionPedido;
import entities.ClienteProveedor;
import entities.Empleados;
import entities.PedidoProduccion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import services.ActualizacionPedidoFacade;
import services.ClienteProveedorFacade;
import services.EmpleadosFacade;
import services.PedidoProduccionFacade;

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
    @EJB
    private ClienteProveedorFacade cliproFacade;
    private ActualizacionPedido actPed = new ActualizacionPedido();
    @EJB
    private ActualizacionPedidoFacade actPedFacade;

    public ControllerPedidoProduccion() {
    }

    //CREATE
    public String guardarEmpleado() {
        try {            
            pedido.setIdEmpleadoPed(empleadoFacade.find(empleado.getIdEmpleados()));
            pedido.setIdClientePed(cliproFacade.find(clipro.getIdClienteProveedor()));
            pedido.setIdConductor(empleadoFacade.find(empleado.getIdEmpleados()));
            pedidoFacade.create(pedido);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "RegistrarPedido.xhtml";
    }
//READ
    public List<PedidoProduccion> listaPedidos() {
        return pedidoFacade.findAll();
    }
    
    public List<ActualizacionPedido> listaPedidosActu(){
        return actPedFacade.findAll();
    }
//UPDATE

    public String actualizarPedido(PedidoProduccion e) {
        this.pedido = e;
        return "ActualizarPedidos.xhtml";
    }

    public String actualizarPedido() {
        PedidoProduccion pedAct = this.pedidoFacade.find(this.pedido.getIdPedido());
        empleado.setIdEmpleados(pedido.getIdEmpleadoPed().getIdEmpleados());
        pedAct.setIdEmpleadoPed(empleado);
        clipro.setIdClienteProveedor(pedido.getIdClientePed().getIdClienteProveedor());
        pedAct.setIdClientePed(clipro);
        pedAct.setNumeroFactura(this.pedido.getNumeroFactura());
        pedAct.setValor(this.pedido.getValor());
        empleado.setIdEmpleados(pedido.getIdConductor().getIdEmpleados());
        pedAct.setIdConductor(empleado);
        
        pedAct.setIdConductor(this.pedido.getIdConductor());

        this.pedidoFacade.edit(pedAct);

        return "ListadePedidos.xhtml";
    }
    
//DELETE
    public String eliminarPedido(PedidoProduccion pedido) {
        this.pedidoFacade.remove(pedido);
        return "ListadePedidos.xhtml";
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
