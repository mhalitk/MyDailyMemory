package gyte.ooaad.database;

/**
 * @author emresaslan
 * @version 1.0
 * @created 25-May-2013 15:17:07
 */
public interface CoreDatabase {

	public static String databaseHost = "";
	public static String databaseName = "";
	public static String databasePassword = "";
	public static String databaseUsername = "";

	/**
	 * 
	 * @param con
	 */
	public boolean close(Connection con);

	/**
	 * 
	 * @param databaseName
	 * @param databasePassword
	 * @param databaseUsername
	 * @param databaseHost
	 */
	public Connection connect(String databaseName, String databasePassword, String databaseUsername, String databaseHost);

}