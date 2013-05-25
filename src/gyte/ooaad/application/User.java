package gyte.ooaad.application;
import java.util.Vector;

/**
 * @version 1.0
 * @created 25-May-2013 15:17:08
 */
public class User {

	private Vector<Memory> memories;
	private int userId;
	public Memory m_Memory;

	public User(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param newFriend
	 */
	public void addFriend(User newFriend){

	}

	/**
	 * 
	 * @param newMemory
	 */
	public void addMemory(Memory newMemory){

	}

	/**
	 * 
	 * @param friend
	 */
	public boolean deleteFriend(User friend){
		return true;
	}

	/**
	 * 
	 * @param memory
	 */
	public boolean deleteMemory(Memory memory){
		return true;
	}

}