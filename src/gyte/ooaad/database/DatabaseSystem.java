package gyte.ooaad.database;

/**
 * @author emresaslan
 * @version 1.0
 * @created 25-May-2013 15:17:07
 */
public class DatabaseSystem implements CoreDatabase {

	public Connection m_Connection;

	public DatabaseSystem(){

	}

	public void finalize() throws Throwable {

	}

	public void accessFriendsMemories(){

	}

	public void accessMemoryDetails(){

	}

	public void accessUserData(){

	}

	public void accessUserDiary(){

	}

	public void accessUserMemories(){

	}

	/**
	 * 
	 * @param con
	 */
	public boolean close(Connection con){
		return false;
	}

	/**
	 * 
	 * @param databaseName
	 * @param databasePassword
	 * @param databaseUsername
	 * @param databaseHost
	 */
	public Connection connect(String databaseName, String databasePassword, String databaseUsername, String databaseHost){
		return null;
	}

	public void updateRecord(){

	}

}