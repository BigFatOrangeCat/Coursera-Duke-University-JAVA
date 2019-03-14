package fch.service.test;

import org.apache.commons.csv.CSVParser;
import org.junit.Test;

import edu.duke.FileResource;
import fch.service.FindColdestHour;

public class TestAverageTemp {
	@Test
	public void testAverageTemp() {
		FileResource fr = new FileResource("src/test/resources/nc_weather/2013/weather-2013-08-10.csv"); 
		CSVParser parser = fr.getCSVParser();
		FindColdestHour findColdestHour = new FindColdestHour();
		double averageTemp = findColdestHour.averageTemperatureInFile(parser);
		System.out.println("Average Temperature in file is " + averageTemp);
	}
}
