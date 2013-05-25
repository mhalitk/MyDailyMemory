package gyte.ooaad.security;

/**
 * @author emresaslan
 * @version 1.0
 * @created 25-May-2013 15:17:07
 */
public interface CoreSecurity {

	public static String password = null;
	public static String userName = null;

	/**
	 * 
	 * @param password
	 * @param userName
	 */
	public boolean checkUsernamePassword(String password, String userName);

	public void wrongUsernamePassword();

}