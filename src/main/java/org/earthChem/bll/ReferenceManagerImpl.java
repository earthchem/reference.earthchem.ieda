package org.earthChem.bll;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.earthChem.dal.ReferenceDao;
import org.earthChem.domain.Reference;
import org.earthChem.exception.InvalidDoiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ReferenceManagerImpl implements ReferenceManager, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6867424806074301237L;
	@Autowired
	private ReferenceDao restReferenceDao;
	@Autowired
	private ReferenceDao hibernateReferenceDao;
	 
	/****
	 * to get reference data from database first. If not exists, get it from doi.org server using RESTful
	 * services.
	 * @throws InvalidDoiException 
	 * 
	 */
	@Override
	public Reference getReference(final String doi) throws InvalidDoiException {
		Reference ref=this.hibernateReferenceDao.getReferenceByDoi(doi);
		if (ref == null)
			ref=this.restReferenceDao.getReferenceByDoi(doi);
		
		return ref;
	}

	/******
	 * to get a list of status for reference records
	 */
	@Override
	public List<String> getStatuses() {
		ArrayList<String> statuses=new ArrayList<String>();
		statuses.add("IN_QUEUE");
		statuses.add("IN_PROGRESS");
		statuses.add("COMPLETED");
		statuses.add("ALERT!");
		return statuses;
	}

	/***
	 * to get all references from database
	 */
	@Override
	public List<Reference> getReferences() {
		return this.hibernateReferenceDao.getReferences();
	}

	/***
	 * to add or update the reference to the backend database
	 */
	@Override
	public void addOrUpdateReference(Reference reference) {
		this.hibernateReferenceDao.addOrUpdateReference(reference);
	}

	@Override
	public void deleteReference(List<Integer> refNums) {
		this.hibernateReferenceDao.deleteReference(refNums);		
	}
	
	@Override
	public List<String> getCitations(List<Integer> selectedReferences) {
		return this.hibernateReferenceDao.getCitations(selectedReferences);
	}
}
