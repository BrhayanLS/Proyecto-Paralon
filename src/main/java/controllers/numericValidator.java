/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controllers;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author brhay
 */
@Named(value = "numericValidator")
@SessionScoped
public class numericValidator implements Serializable {

    /**
     * Creates a new instance of numericValidator
     */
    public numericValidator() {
    }
    
}
