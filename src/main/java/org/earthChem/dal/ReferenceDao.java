package org.earthChem.dal;

import java.util.List;

import org.earthChem.domain.Reference;
import org.earthChem.exception.InvalidDoiException;

/***
 * Reference DAO interface
 * 
 *
 */
public interface ReferenceDao {
	
	/**
	 * To retrieve the reference based on doi 
	 * @param doi
	 * @return
	 * @throws InvalidDoiException 
	 */
	public Reference getReferenceByDoi(final String doi) throws InvalidDoiException;

	/**
	 * To get all references from the database
	 * 
	 * @return
	 */
	public List<Reference> getReferences();

	/*******
	 * to save the reference data to database
	 * @param reference
	 */
	public void addOrUpdateReference(Reference reference);
	
	public void deleteReference(List<Integer> refNums);
	
	public List<String> getCitations(List<Integer> selectedReferences);
}
