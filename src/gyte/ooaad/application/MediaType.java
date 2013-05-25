package gyte.ooaad.application;

/**
 * @author Coker
 * @version 1.0
 * @created 25-May-2013 15:17:07
 */
public abstract class MediaType {

	private String media;

	public MediaType() {
		media = null;
	}

	public void finalize() throws Throwable {

	}

	public String getMedia() {
		return media;
	}

	/**
	 * 
	 * @param media
	 */
	public void setMedia(String theMedia) {
		this.media = theMedia;
	}

}