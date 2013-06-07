package gyte.ooaad.tests;

import static org.junit.Assert.fail;
import junit.framework.Assert;
import gyte.ooaad.application.Date;

import org.junit.Test;

public class DateTest {

	@Test
	public void testDate() {
		Date date = new Date("28/07/2013");
		Assert.assertEquals(date.getDate(), "28/07/2013");
	}

	@Test
	public void testSetDate() {
		Date date = new Date("28/07/2013");
		date.setDate("28/08/2013");
		Assert.assertEquals(date.getDate(), "28/08/2013");
	}

	@Test
	public void testGetDate() {
		Date date = new Date("28/07/2013");
		Assert.assertEquals(date.getDate(), "28/07/2013");
	}

}
