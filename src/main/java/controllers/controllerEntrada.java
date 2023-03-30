/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controllers;

import entities.ClienteProveedor;
import entities.Empleados;
import entities.EntradaInventario;
import entities.ProductosInventario;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import services.ClienteProveedorFacade;
import services.EmpleadosFacade;
import services.EntradaInventarioFacade;
import services.ProductosInventarioFacade;

/**
 *
 * @author LENOVO
 */
@Named(value = "controllerEntrada")
@Dependent
public class controllerEntrada {

    @EJB
    private ClienteProveedorFacade clienteProveedorFacade;
    private ClienteProveedor clienteProveedor = new ClienteProveedor();

    @EJB
    private ProductosInventarioFacade productosInventarioFacade;
    private ProductosInventario productosInventario = new ProductosInventario();

    @EJB
    private EntradaInventarioFacade entradaInventarioFacade;
    private EntradaInventario entradaInventario = new EntradaInventario();

    @EJB
    private EmpleadosFacade empleadosFacade;
    private Empleados empleados = new Empleados();
    private String mensaje = "";

    /**
     * Creates a new instance of controllerEntrada
     */
    public controllerEntrada() {
    }
    
    
    /////nuevo codigo
    /*
    public void  cargarData(EntradaInventario t){
        this.entradaInventario = t;
        
    }
    */
    
   /////////// antiguo codigo

    public void cargar(EntradaInventario entradaInventario) {
        this.entradaInventario = entradaInventario;
    }

    public void ActualizarDatos() {
        entradaInventarioFacade.edit(entradaInventario);
    }

    //CARGAR DATOS EN EL FOMULARIO DE ACTUALIZCION
    
    public String Actualizar(EntradaInventario t) {

        this.entradaInventario = t;
        return "EntradaInventario.xhtml";
    }
    //GUARDAR
    public void guardar() {
        try {
            getEntradaInventario().setIdProducto(getProductosInventarioFacade().find(getProductosInventario().getIdProducto()));
            getEntradaInventario().setIdProveedor(getClienteProveedorFacade().find(getClienteProveedor().getIdClienteProveedor()));
            getEntradaInventario().setIdEmpleado(getEmpleadosFacade().find(getEmpleados().getIdEmpleados()));
            getEntradaInventarioFacade().create(getEntradaInventario());
            this.mensaje = "Almacenado Con exito";
        } catch (Exception e) {
            e.printStackTrace();
            this.mensaje = "Error " + e.getMessage();

        }
        FacesMessage mens = new FacesMessage(this.mensaje);

        FacesContext.getCurrentInstance().addMessage(null, mens);
    }

    //LISTAR
    public List<EntradaInventario> getALLEntradaInventario() {
        return getEntradaInventarioFacade().findAll();
    }

    ///ELIMINAR
    public void eliminarEntrada(EntradaInventario entradaInventario) {
        getEntradaInventarioFacade().remove(entradaInventario);
    }

    ///ACTUALIZAR
    /**
     * @return the clienteProveedorFacade
     */
    public ClienteProveedorFacade getClienteProveedorFacade() {
        return clienteProveedorFacade;
    }

    /**
     * @param clienteProveedorFacade the clienteProveedorFacade to set
     */
    public void setClienteProveedorFacade(ClienteProveedorFacade clienteProveedorFacade) {
        this.clienteProveedorFacade = clienteProveedorFacade;
    }

    /**
     * @return the clienteProveedor
     */
    public ClienteProveedor getClienteProveedor() {
        return clienteProveedor;
    }

    /**
     * @param clienteProveedor the clienteProveedor to set
     */
    public void setClienteProveedor(ClienteProveedor clienteProveedor) {
        this.clienteProveedor = clienteProveedor;
    }

    /**
     * @return the productosInventarioFacade
     */
    public ProductosInventarioFacade getProductosInventarioFacade() {
        return productosInventarioFacade;
    }

    /**
     * @param productosInventarioFacade the productosInventarioFacade to set
     */
    public void setProductosInventarioFacade(ProductosInventarioFacade productosInventarioFacade) {
        this.productosInventarioFacade = productosInventarioFacade;
    }

    /**
     * @return the productosInventario
     */
    public ProductosInventario getProductosInventario() {
        return productosInventario;
    }

    /**
     * @param productosInventario the productosInventario to set
     */
    public void setProductosInventario(ProductosInventario productosInventario) {
        this.productosInventario = productosInventario;
    }

    /**
     * @return the entradaInventarioFacade
     */
    public EntradaInventarioFacade getEntradaInventarioFacade() {
        return entradaInventarioFacade;
    }

    /**
     * @param entradaInventarioFacade the entradaInventarioFacade to set
     */
    public void setEntradaInventarioFacade(EntradaInventarioFacade entradaInventarioFacade) {
        this.entradaInventarioFacade = entradaInventarioFacade;
    }

    /**
     * @return the entradaInventario
     */
    public EntradaInventario getEntradaInventario() {
        return entradaInventario;
    }

    /**
     * @param entradaInventario the entradaInventario to set
     */
    public void setEntradaInventario(EntradaInventario entradaInventario) {
        this.entradaInventario = entradaInventario;
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

    /**
     * @return the EntradaInventario
     */
}
