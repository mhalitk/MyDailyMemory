package gyte.ooaad.application;

/**
 * This class maintains a reference to a Component object and defines an
 * interface that conforms to Component's interface.
 * 
 * @version 1.0
 * @created 25-May-2013 15:57:12
 */
public abstract class Decorator extends Diary {

	private Diary diary;

	public Decorator(Diary theDiary) {
		this.diary = theDiary;
		setDate(theDiary.getDate());
	}

	public Decorator() {
		diary = null;
	}

	public Diary getDiary() {
		return diary;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}
}