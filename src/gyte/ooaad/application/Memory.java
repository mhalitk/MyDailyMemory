package gyte.ooaad.application;

import java.util.ArrayList;
import java.util.List;

/**
 * @author halit
 * @version 1.0
 * @created 25-May-2013 15:17:07
 */
public class Memory {

	private List<Diary> diaries;

	public Memory() {
		diaries = new ArrayList<Diary>();
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param newDiary
	 */
	public void addDiary(Diary newDiary) {
		diaries.add(newDiary);
	}

	/**
	 * 
	 * @param diary
	 */
	public boolean deleteDiary(Diary diary) {
		if (diaries.contains(diary)) {
			diaries.remove(diary);
			return true;
		}
		return false;
	}

	public List<Diary> getDiaries() {
		return diaries;
	}

}