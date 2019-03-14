package fch.service.test;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.Test;

import edu.duke.FileResource;
import fch.service.FindColdestHour;

public class TestSingleDay {
	@Test
	public void testSingleDay() {
		FileResource fr = new FileResource("src/test/resources/nc_weather/2014/weather-2014-05-01.csv"); 
		CSVParser parser = fr.getCSVParser();
		FindColdestHour findColdestHour = new FindColdestHour();
		CSVRecord coldest = findColdestHour.coldestHourInFile(parser);
		System.out.println("Coldest temperature was " + coldest.get("TemperatureF") + " at " + coldest.get("DateUTC"));
	}
}

