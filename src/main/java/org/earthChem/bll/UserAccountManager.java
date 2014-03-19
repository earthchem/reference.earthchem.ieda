package org.earthChem.bll;

import java.math.BigDecimal;
import org.earthChem.domain.UserAccount;


/****
 * 
 * @author EarthChem3
 *
 */
public interface UserAccountManager {
	public UserAccount getUserAccount(final BigDecimal accountID);
	public UserAccount getUserAccount(final String userName);

}
