package org.earthChem.dal.hibernate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.earthChem.dal.ReferenceDao;
import org.earthChem.dal.hibernate.bean.ReferenceHbm;
import org.earthChem.domain.Reference;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/********
 * Hibernate implementation for ReferenceDao
 * 
 * @author EarthChem3
 *
 */
public class ReferenceDaoHibernateImpl implements ReferenceDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3966769425050456505L;
	private SessionFactory sessionFactory;

	@Autowired
	@Qualifier("sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Reference getReferenceByDoi(final String doi)
	{
		ReferenceHbm referenceHbm=this.getReferenceHbmByDoi(doi);
		if (referenceHbm == null)
			return null;
		Reference reference=new Reference();
		convertReferenceHbm2Reference(referenceHbm, reference);
		return reference;
		
	}
	
	/**
	 * convert hibernate bean to domain object
	 * 
	 * @param referenceHbm
	 * @param reference
	 */
	private void convertReferenceHbm2Reference(ReferenceHbm referenceHbm,
			Reference reference) {
		reference.setDoi(referenceHbm.getPublicationDoi());
		reference.setTitle(referenceHbm.getTitle());
		reference.setRefNum(referenceHbm.getRefNum().intValue());
		reference.setJournal(referenceHbm.getJournal());
		reference.setVolume(referenceHbm.getVolume());
		reference.setIssue(referenceHbm.getIssue());
		reference.setFirstPage(referenceHbm.getFirstPage());
		reference.setLastPage(referenceHbm.getLastPage());
		reference.setPubYear(referenceHbm.getPubYear());
		reference.setBookTitle(referenceHbm.getBookTitle());
		reference.setBookEditor(referenceHbm.getBookEditor());
		reference.setPublisher(referenceHbm.getPublisher());
		reference.setDataEntered(referenceHbm.getDataEntered());
		reference.setDataEnteredDate(referenceHbm.getDataEnteredDate());
		reference.setStatus(referenceHbm.getStatus());
		reference.setPublicComment(referenceHbm.getPublicComment());
	}
	
	protected ReferenceHbm getReferenceHbm(final BigDecimal refNum)
	{
		Session session = sessionFactory.getCurrentSession();
		ReferenceHbm referenceHbm= (ReferenceHbm) session.get(ReferenceHbm.class, refNum);
		return referenceHbm;
	}
	
	protected ReferenceHbm getReferenceHbmByDoi(final String doi) {
		if (doi == null || doi.isEmpty()) {
			String message = "doi is null";
			throw new IllegalArgumentException(message);
		}

		Session session = sessionFactory.getCurrentSession();

		@SuppressWarnings("unchecked")
		List<ReferenceHbm> referenceHbms = session
				.createQuery("from ReferenceHbm where publicationDoi = :doi ")
				.setParameter("doi", doi).list();

		if (referenceHbms == null || referenceHbms.size() == 0) {
			return null;
		}

		if (referenceHbms.size() > 1) {
			String message = "There are multiple entries for the doi = " + doi;
			throw new RuntimeException(message);
		}

		return referenceHbms.get(0);
	}

	/****************
	 * to get all references from database
	 */
	@Override
	public List<Reference> getReferences() {
		
		Session session = sessionFactory.getCurrentSession();

		@SuppressWarnings("unchecked")
		List<ReferenceHbm> referenceHbms = session
				.createQuery("from ReferenceHbm ").list();

		if (referenceHbms == null || referenceHbms.size() == 0) {
			return null;
		}

		ArrayList<Reference> result=new ArrayList<Reference>();
		Iterator<ReferenceHbm> it=referenceHbms.iterator();
		while (it.hasNext())
		{
			ReferenceHbm referenceHbm=it.next();
			Reference reference=new Reference();
			this.convertReferenceHbm2Reference(referenceHbm, reference);
			result.add(reference);
		}

		return result;
	}

	/********
	 * To save the reference data to database
	 * 
	 */
	@Override
	public void addOrUpdateReference(Reference reference) {
		ReferenceHbm referenceHbm=this.getReferenceHbm(new BigDecimal(reference.getRefNum()));
		if (referenceHbm == null)
			referenceHbm=new ReferenceHbm();
		this.convertReference2ReferenceHbm(reference, referenceHbm);
		
		Session session = sessionFactory.getCurrentSession();			
	    session.saveOrUpdate(referenceHbm);
	        
	}
	
	public void deleteReference(Integer refNum) {
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createSQLQuery(
				"CALL PRC_DEL_REF(:refNum)")
				.addEntity(Reference.class)
				.setParameter("refNum", refNum);
				query.executeUpdate();
	}

	/********
	 * To convert domain object to hibernate bean
	 * 
	 * @param reference
	 * @param referenceHbm
	 */
	private void convertReference2ReferenceHbm(Reference reference,
			ReferenceHbm referenceHbm) {
		referenceHbm.setPublicationDoi(reference.getDoi());
		referenceHbm.setTitle(reference.getTitle());
		referenceHbm.setRefNum(new BigDecimal(reference.getRefNum()));
		referenceHbm.setJournal(reference.getJournal());
		referenceHbm.setVolume(reference.getVolume());
		referenceHbm.setIssue(reference.getIssue());
		referenceHbm.setFirstPage(referenceHbm.getFirstPage());
		referenceHbm.setLastPage(reference.getLastPage());
		referenceHbm.setPubYear(reference.getPubYear());
		referenceHbm.setBookTitle(reference.getBookTitle());
		referenceHbm.setBookEditor(reference.getBookEditor());
		referenceHbm.setPublisher(reference.getPublisher());
		referenceHbm.setDataEntered(reference.getDataEntered());
		referenceHbm.setDataEnteredDate(reference.getDataEnteredDate());
		referenceHbm.setStatus(reference.getStatus());
		referenceHbm.setPublicComment(reference.getPublicComment());
		
	}

}
