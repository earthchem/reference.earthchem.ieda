package org.earthChem.bll;

import java.util.List;

import org.earthChem.domain.Reference;
import org.earthChem.exception.InvalidDoiException;

/****
 * Interface to manage reference data
 * 
 * @author EarthChem3
 *
 */
public interface ReferenceManager {
	public Reference getReference(final String doi) throws InvalidDoiException;

	public List<String> getStatuses();
	
	public List<Reference> getReferences();

	public void addOrUpdateReference(Reference reference);
	
	public void deleteReference(Integer refNum);
	
	public List<String> getCitations(List<Integer> selectedReferences);
	
}
