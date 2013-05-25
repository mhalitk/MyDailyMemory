package gyte.ooaad.application;

/**
 * @author Coker
 * @version 1.0
 * @created 25-May-2013 15:17:08
 */
public class VideoDiary extends Decorator {

	private Video video;
	
	public VideoDiary(){
		super();
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void setMedia(Video theVideo) {
		this.video = theVideo;
	}
	
	public Video getMedia() {
		return this.video;
	}
}