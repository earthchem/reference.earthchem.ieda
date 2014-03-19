package org.earthChem.bll;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.earthChem.dal.UserAccountDao;
import org.earthChem.domain.Reference;
import org.earthChem.domain.UserAccount;
import org.earthChem.exception.InvalidDoiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public class UserAccountManagerImpl implements UserAccountManager, Serializable {
	
	@Autowired
	private UserAccountDao userAccountDao;
	
	@Override
	public UserAccount getUserAccount(final BigDecimal accountID) {
		return this.userAccountDao.getUserAccount(accountID);
	}
	
	@Override
	public UserAccount getUserAccount(final String userName) {
		return this.userAccountDao.getUserAccount(userName);
	}
}
