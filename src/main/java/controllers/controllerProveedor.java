package controllers;

import entities.ClienteProveedor;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import services.ClienteProveedorFacade;


/**
 *
 * @author LENOVO
 */
@Named(value = "controllerProveedor")
@SessionScoped

public class controllerProveedor implements Serializable {

    @EJB
    ClienteProveedorFacade proveedorFacade;
    ClienteProveedor proveedor = new ClienteProveedor();
    
    private String mensaje;

    public controllerProveedor() {

    }

    //Este actualiza los campos se encuentra en el boton actualizar de: ActualizarProveedor.xhtml
    public void ActualiarDatos() {
        proveedorFacade.edit(proveedor);        
    }
    
    //Este carga los datos a la pagina ActualizarProveedor.xhtml

    public String Actualizar(ClienteProveedor e) {
        this.proveedor = e;
        return "./Actualizar/ActualizarProveedor.xhtml";
    }

    //CREATE
    public void guardar() {
        try {
            getProveedorFacade().create(getProveedor());
        } catch (Exception e) {
            e.printStackTrace();
            this.setMensaje("Error " + e.getMessage());

        }
        FacesMessage mens = new FacesMessage(this.getMensaje());

        FacesContext.getCurrentInstance().addMessage(null, mens);
    }

    //listar
    public List<ClienteProveedor> getALLClienteProveedor() {
        return getProveedorFacade().findAll();
    }

    //ELIMNAR
    public void elimimar(ClienteProveedor proveedor) {
        getProveedorFacade().remove(proveedor);
    }
   
    
    

   
    
    /**
     * @return the proveedorFacade
     */
    public ClienteProveedorFacade getProveedorFacade() {
        return proveedorFacade;
    }

    /**
     * @param proveedorFacade the proveedorFacade to set
     */
    public void setProveedorFacade(ClienteProveedorFacade proveedorFacade) {
        this.proveedorFacade = proveedorFacade;
    }

    /**
     * @return the proveedor
     */
    public ClienteProveedor getProveedor() {
        return proveedor;
    }

    /**
     * @param proveedor the proveedor to set
     */
    public void setProveedor(ClienteProveedor proveedor) {
        this.proveedor = proveedor;
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
