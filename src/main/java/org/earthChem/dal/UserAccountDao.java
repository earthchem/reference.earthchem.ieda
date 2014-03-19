package org.earthChem.dal;

import java.math.BigDecimal;
import  org.earthChem.domain.UserAccount;

public interface UserAccountDao {
	
	public UserAccount getUserAccount(final BigDecimal accountID);
	public UserAccount getUserAccount(final String userName);
}
