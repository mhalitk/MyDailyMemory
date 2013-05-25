package gyte.ooaad.application;

/**
 * @author halit
 * @version 1.0
 * @created 25-May-2013 15:17:08
 */
public class Text extends MediaType {

	public Text(){
		super();
	}

	public Text(String text) {
		super.setMedia(text);
	}
	
	public void finalize() throws Throwable {

	}

	public String getMedia(){
		return super.getMedia();
	}

	/**
	 * 
	 * @param text
	 */
	public void setMedia(String text){
		super.setMedia(text);
	}

}