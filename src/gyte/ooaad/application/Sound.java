package gyte.ooaad.application;

/**
 * @author halit
 * @version 1.0
 * @created 25-May-2013 15:17:08
 */
public class Sound extends MediaType {

	public Sound() {
		super();
	}

	public Sound(String sound) {
		super.setMedia(sound);
	}

	public void finalize() throws Throwable {

	}

	public String getMedia() {
		return super.getMedia();
	}

	/**
	 * 
	 * @param newSound
	 */
	public void setMedia(String newSound) {
		super.setMedia(newSound);
	}

}