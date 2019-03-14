package fch.service.test;

import org.junit.Test;

import fch.service.FindColdestHour;

public class TestManyDays {
	@Test
	public void testManyDays() {
		FindColdestHour findColdestHour = new FindColdestHour();
		findColdestHour.fileWithColdestTemperature();
		//System.out.println();
	}

}
