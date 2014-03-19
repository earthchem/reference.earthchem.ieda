package org.earthChem.domain;

import java.math.BigDecimal;
import java.util.Date;


public class UserAccount implements java.io.Serializable {

	 /**
	 * 
	 */
	 private BigDecimal acountID;
     private String userName;
     private String password;
     private Date dateCreated;
     private String note;
     private String role;

    // Constructors

    /** default constructor */
    public UserAccount() {
    }

	/** minimal constructor */
    public UserAccount(BigDecimal acountID) {
        this.acountID = acountID;
    }
    
    /** full constructor */
    public UserAccount(BigDecimal acountID, String userName,
			String password, Date dateCreated, String note, String role) {
		this.acountID = acountID;
		this.userName = userName;
		this.password = password;
		this.dateCreated = dateCreated;
		this.note = note;
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserAccount [acountID=" + acountID + ", userName=" + userName
				+ ", password=" + password + ", dateCreated=" + dateCreated
				+ ", note=" + note + ", role=" + role + "]";
	}

	public BigDecimal getAcountID() {
		return acountID;
	}

	public void setAcountID(BigDecimal acountID) {
		this.acountID = acountID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}   
  
}
