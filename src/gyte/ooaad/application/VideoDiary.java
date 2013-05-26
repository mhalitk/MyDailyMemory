package gyte.ooaad.application;

/**
 * @author Coker
 * @version 1.0
 * @created 25-May-2013 15:17:08
 */
public class VideoDiary extends Decorator {

	private Video video;

	public VideoDiary() {
		super();
	}

	public VideoDiary(Diary diary) {
		super(diary);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void setVideo(Video theVideo) {
		this.video = theVideo;
	}

	public Video getVideo() {
		return this.video;
	}

}