package org.earthChem.presentation.jsf;

import java.io.IOException;
import java.math.BigDecimal;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.earthChem.bll.ReferenceManager;
import org.earthChem.bll.UserAccountManager;
import org.earthChem.domain.UserAccount;
import org.primefaces.context.RequestContext;

/*********
 * JSF Backing Bean for Reference Page
 *
 *
 */
public class UserAccountBean {

	private UserAccountManager userAccountManager;
	private String username;	
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public UserAccountManager getUserAccountManager() {
		return userAccountManager;
	}
	
	public void setUserAccountManager(UserAccountManager userAccountManager) {
		this.userAccountManager = userAccountManager;
	}
	

	public void login(ActionEvent actionEvent)
	{
		
				RequestContext context = RequestContext.getCurrentInstance();
				FacesMessage msg = null;
				boolean loggedIn = false;
				UserAccount ua;
				if(username != null && password != null && (ua = userAccountManager.getUserAccount(username)) != null) {
					if(password.equals(ua.getPassword())) {
						System.out.println("bc-found");
						msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
						loggedIn = true;
					}
				} else {
					msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");
					System.out.println("bc-not found");
				}
				
				FacesContext.getCurrentInstance().addMessage(null, msg);
				context.addCallbackParam("loggedIn", loggedIn);	
	}
	
	public String logout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login.xhtml/logout?faces-redirect=true";
	}
}
