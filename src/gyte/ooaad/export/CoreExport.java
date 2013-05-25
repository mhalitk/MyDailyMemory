package gyte.ooaad.export;

import gyte.ooaad.application.Diary;
import gyte.ooaad.application.Memory;

/**
 * @author emresaslan
 * @version 1.0
 * @created 25-May-2013 15:17:07
 */
public interface CoreExport {

	public static Diary diary = null;
	public static Memory memory = null;
	public ExportTypes m_ExportTypes = null;

	public void exportingProcess();

}