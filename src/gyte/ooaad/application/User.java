package gyte.ooaad.application;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @created 25-May-2013 15:17:08
 */
public class User {

	final int DEFAULT_USERID = -1;
	private Memory memory;
	private int userId;
	String name;
	String password;

	public User() {
		memory = new Memory();
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

	public Memory getMemory() {
		return memory;
	}

	public void setMemory(Memory memory) {
		this.memory = memory;
	}
}