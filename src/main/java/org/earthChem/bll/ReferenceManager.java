package org.earthChem.bll;

import java.util.List;

import org.earthChem.domain.Reference;

/****
 * Interface to manage reference data
 * 
 * @author EarthChem3
 *
 */
public interface ReferenceManager {
	public Reference getReference(final String doi);

	public List<String> getStatuses();
	
	public List<Reference> getReferences();

	public void addOrUpdateReference(Reference reference);
	
}
