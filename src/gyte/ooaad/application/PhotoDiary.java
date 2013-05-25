package gyte.ooaad.application;

public class PhotoDiary extends Decorator {
	private Photo photo;

	public PhotoDiary() {
		super();
		this.photo = null;
	}

	public PhotoDiary(Diary diary) {
		super(diary);
	}

	public void setPhoto(Photo thePhoto) {
		this.photo = thePhoto;
	}

	public Photo getPhoto() {
		return this.photo;
	}
}
