package org.earthChem.dal;

import java.util.List;

import org.earthChem.domain.Reference;

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
	 */
	public Reference getReferenceByDoi(final String doi);

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
}
