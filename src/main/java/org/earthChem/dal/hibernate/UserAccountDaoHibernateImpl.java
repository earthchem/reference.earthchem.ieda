package org.earthChem.dal.hibernate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.earthChem.dal.UserAccountDao;
import org.earthChem.dal.hibernate.bean.ReferenceHbm;
import org.earthChem.domain.UserAccount;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/********
 * 
 * @author EarthChem3
 *
 */
public class UserAccountDaoHibernateImpl implements UserAccountDao, Serializable {

	/**
	 * 
	 */
	private SessionFactory sessionFactory;

	@Autowired
	@Qualifier("sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public UserAccount getUserAccount(final BigDecimal accountID)
	{
		Session session = sessionFactory.getCurrentSession();
		return  (UserAccount) session.get(UserAccount.class, accountID);
	}
	
	public UserAccount getUserAccount(final String userName) {
		
		Session session = sessionFactory.getCurrentSession();

		@SuppressWarnings("unchecked")
		List<UserAccount> userAccounts = session
				.createQuery("from UserAccount where userName = :userName ")
				.setParameter("userName", userName).list();

		if (userAccounts == null || userAccounts.size() == 0) return null;
		else return userAccounts.get(0);
	}

}
