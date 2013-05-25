package gyte.ooaad.application;

/**
 * This class maintains a reference to a Component object and defines an interface
 * that conforms to Component's interface.
 * @version 1.0
 * @created 25-May-2013 15:57:12
 */
public abstract class Decorator extends Diary {

	private Diary diary;
	public Diary m_Diary;

	public Decorator(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}