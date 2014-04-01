package org.earthChem.presentation.jsf;

import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.earthChem.bll.ReferenceManager;
import org.earthChem.domain.Reference;
import org.earthChem.exception.InvalidDoiException;
import org.primefaces.context.RequestContext;

/*********
 * JSF Backing Bean for Reference Page
 *
 *
 */
@ManagedBean
@SessionScoped
public class ReferenceBean {

	private ReferenceManager referenceManager;
	private Reference reference=new Reference();
	private Reference selectedReference;
	private List<Reference> references;
	private boolean isNew=false;
	private SelectItem[] statusOptions=null;
	
	
	public ReferenceManager getReferenceManager() {
		return referenceManager;
	}
	public void setReferenceManager(ReferenceManager referenceManager) {
		this.referenceManager = referenceManager;
	}
	public Reference getReference() {
		return reference;
	}
	public void setReference(Reference reference) {
		this.reference = reference;
	}
	
	public List<String> getStatuses()
	{
		return this.referenceManager.getStatuses();
	}
	
	public SelectItem[] getStatusOptions()  { 
		
		if (statusOptions != null)
			return statusOptions;
		List<String> statuses=this.getStatuses();
        statusOptions = new SelectItem[statuses.size() + 1];  
  
        statusOptions[0] = new SelectItem("", "Select");  
        for(int i = 0; i < statuses.size(); i++) {  
        	statusOptions[i + 1] = new SelectItem(statuses.get(i), statuses.get(i));  
        }  
  
        return statusOptions;  
    }  
	

	public Reference getSelectedReference() {
		return selectedReference;
	}
	public void setSelectedReference(Reference selectedReference) {
		this.selectedReference = selectedReference;
	}
	
	public List<Reference> getReferences() {
		if (this.references == null)
			this.references =  this.referenceManager.getReferences();
		return this.references;
	}
	
	public void setReferences(List<Reference> references) {
		this.references = references;
	} 
	
	private boolean hasDoiBeUsed(String doi)
	{
		Iterator<Reference> it=this.references.iterator();
		while (it.hasNext())
		{
			Reference ref=it.next();
			if (ref.getDoi() == null || ref.getDoi().isEmpty())
				continue;
			if (ref.getDoi().equalsIgnoreCase(doi))
				return true;
		}
		return false;
	}
	/******
	 * to get the reference data for input doi
	 */
	public void doSubmit() {  
	//	Integer refNum = reference.getRefNum();
        String doi = reference.getDoi();
        if(doi != null) doi = doi.trim();
        
        if (doi == null || doi.isEmpty())
        {
        	FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Validation Error:", "DOI must be entered"));
        //	validDoi=false;
        }
        else if (this.hasDoiBeUsed(doi))
        {
        	FacesContext.getCurrentInstance().addMessage(null, 
								new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Validation Error:", "A reference with input doi has been in the database."));
        }
        else
        {
			try
			{
				this.reference=this.referenceManager.getReference(doi);
			}
			catch (InvalidDoiException ie)
			{
				FacesContext.getCurrentInstance().addMessage(null, 
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Validation Error:", "Entered Invalid DOI"));
				//validDoi=false;	
			}
			catch (Exception ex)
			{
				FacesContext.getCurrentInstance().addMessage(null, 
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"System Error:", ex.getMessage()));
				//validDoi=false;	
			}
        }
		
	}
	
	/********
	 * To save the reference to the database
	 */
	public void doSave()
	{
		boolean validRefNum=true;
		if (this.isNew)  {
			Integer refNum=reference.getRefNum();
		
			if (refNum == null || refNum == 0)
			{
				FacesContext.getCurrentInstance().addMessage(null, 
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Validation Error:", "Ref Num is required"));
				validRefNum = false;
			}
			//now check if the ref num has been used
			else 
			{
				Iterator<Reference> it=this.references.iterator();
				while (it.hasNext())
				{
					Reference ref=it.next();
					if (ref.getRefNum() == refNum.intValue())
					{
						FacesContext.getCurrentInstance().addMessage(null, 
								new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Validation Error:", "Ref Num has been used."));
						validRefNum = false;
						ref.setRefNum(null);
					}
				}
			}
		}
		RequestContext context = RequestContext.getCurrentInstance(); 
		context.addCallbackParam("validRefNum", validRefNum);
		if (validRefNum == false)
			return;
		
		this.referenceManager.addOrUpdateReference(reference);	
		this.references = this.referenceManager.getReferences();
	}
	
	/***
	 * Edit an existing reference
	 */
	public void doEdit()
	{
		this.reference=this.selectedReference;
		this.isNew = false;
	}
	
	/*****
	 * Add a new reference
	 */
	public void doAdd()
	{
		this.reference= new Reference();
		this.isNew = true;
		
	}
	
	public void doDelete()
	{		
		this.referenceManager.deleteReference(selectedReference.getRefNum());		
		selectedReference = null;
		this.references = this.referenceManager.getReferences();
	}
	
	public boolean getIsNew()
	{
		return this.isNew;
	}
	
	
	
}
