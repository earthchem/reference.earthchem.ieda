package org.earthChem.presentation.jsf;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.earthChem.bll.ReferenceManager;
import org.primefaces.context.RequestContext;

/*********
 * JSF Backing Bean for Logout Page
 *
 *
 */
public class LogoutBean implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String logout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/faces/reference.xhtml/logout?faces-redirect=true";
	}
}
