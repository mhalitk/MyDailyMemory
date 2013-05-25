package gyte.ooaad.application;

/**
 * This class defines the interface for objects that can have responsibilities
 * added to them dynamically.
 * @version 1.0
 * @created 25-May-2013 15:51:21
 */
public abstract class Diary {

	private Date date;

	public Diary(){

	}

	public void finalize() throws Throwable {

	}

	public Date getDate(){
		return null;
	}

	public String getText(){
		return "";
	}

	/**
	 * 
	 * @param date
	 */
	public void setDate(Date date){

	}

	/**
	 * 
	 * @param text
	 */
	public void setText(String text){

	}

}