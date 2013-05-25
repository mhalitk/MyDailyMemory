package gyte.ooaad.application;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @created 25-May-2013 15:17:08
 */
public class User {

	final int DEFAULT_USERID = -1;
	private List<Memory> memories;
	private int userId;
	String name;
	String password;

	public User(){
		memories = new ArrayList<Memory>();
		name = "";
		password = "";
		userId = DEFAULT_USERID;
	}
	
	public void setId(int theUserId) {
		this.userId = theUserId;
	}
	
	public void setName(String theName) {
		this.name = theName;
	}
	
	public void setPassword(String thePassword) {
		this.password = thePassword;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param newMemory
	 */
	public void addMemory(Memory newMemory){
		memories.add(newMemory);
	}

	/**
	 * 
	 * @param memory
	 */
	public boolean deleteMemory(Memory memory){
		// TODO sync with database
		
		boolean isContains = memories.contains(memory);
		
		if (isContains) {
			memories.remove(memory);
			return true;
		} 
		
		return false;
	}

}