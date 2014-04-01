package org.earthChem.presentation.jsf;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/*********
 * JSF Backing Bean for Logout Page
 *
 *
 */
@ManagedBean
@SessionScoped
public class LogoutBean {

	public String logout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/faces/reference.xhtml/logout?faces-redirect=true";
	}
}
