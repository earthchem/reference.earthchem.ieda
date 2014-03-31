package org.earthChem.presentation.jsf;

import java.io.IOException;
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
public class LogoutBean {

	public String logout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/faces/reference.xhtml/logout?faces-redirect=true";
	}
}
