package gyte.ooaad.application;

/**
 * @author halit
 * @version 1.0
 * @created 25-May-2013 15:17:08
 */
public class Video extends MediaType {

	public Video() {
		super();
	}

	public Video(String video) {
		super.setMedia(video);
	}

	public void finalize() throws Throwable {

	}

	public String getMedia() {
		return super.getMedia();
	}

	/**
	 * 
	 * @param newVideo
	 */
	public void setMedia(String newVideo) {
		super.setMedia(newVideo);
	}

}