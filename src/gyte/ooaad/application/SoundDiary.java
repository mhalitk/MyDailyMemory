package gyte.ooaad.application;

/**
 * @author Coker
 * @version 1.0
 * @created 25-May-2013 15:17:08
 */
public class SoundDiary extends Decorator {

	private Sound sound;
	
	public SoundDiary(){
		super();
		this.sound = null;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public Sound getSound(){
		return this.sound;
	}

	/**
	 * 
	 * @param sound
	 */
	public void setSound(Sound theSound){
		this.sound = theSound;
	}

}