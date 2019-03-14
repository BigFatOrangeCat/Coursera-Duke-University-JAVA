package fch.service.test;

import org.junit.Test;

import fch.service.FindColdestHour;

public class TestHumidityManyFiles {
	@Test
	public void testHumidityManyFiles() {
		FindColdestHour findColdestHour = new FindColdestHour();
		findColdestHour.lowestHumidityInManyFiles();
		//System.out.println();
	}
}
