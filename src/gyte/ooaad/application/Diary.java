package gyte.ooaad.application;

/**
 * This class defines the interface for objects that can have responsibilities
 * added to them dynamically.
 * 
 * @version 1.0
 * @created 25-May-2013 15:51:21
 */
public abstract class Diary {

	private Date date;

	public Diary() {
		this.date = null;
	}

	public Diary(Date theDate) {
		this.date = theDate;
	}

	public void finalize() throws Throwable {

	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}