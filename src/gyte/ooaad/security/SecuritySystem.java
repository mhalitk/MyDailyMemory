package gyte.ooaad.security;

/**
 * @author emresaslan
 * @version 1.0
 * @created 25-May-2013 15:17:08
 */
public class SecuritySystem implements CoreSecurity {

	public SecuritySystem(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param password
	 * @param userName
	 */
	public boolean checkUsernamePassword(String password, String userName){
		return false;
	}

	public void wrongUsernamePassword(){

	}

}