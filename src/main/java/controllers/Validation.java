package controllers;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

@Named(value = "validation")
@SessionScoped
public class Validation implements Serializable {

    public void validar(FacesContext context, UIComponent toValidate, Object value) {
        context = FacesContext.getCurrentInstance();
        String texto = (String) value;

        try {
            Integer numero = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            ((UIInput) toValidate).setValid(false);
            context.addMessage(toValidate.getClientId(context), new FacesMessage("Solo valores numericos"));
        }
    }
}
