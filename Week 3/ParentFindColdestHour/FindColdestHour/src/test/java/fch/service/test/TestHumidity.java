package fch.service.test;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.Test;

import edu.duke.FileResource;
import fch.service.FindColdestHour;

public class TestHumidity {
	@Test
	public void testSingleDay() {
		FileResource fr = new FileResource("src/test/resources/nc_weather/2014/weather-2014-07-22.csv"); 
		CSVParser parser = fr.getCSVParser();
		FindColdestHour findColdestHour = new FindColdestHour();
		CSVRecord humiest = findColdestHour.lowestHumidityInFile(parser);
		System.out.println("Lowest Humidity was " + humiest.get("Humidity") + " at " + humiest.get("DateUTC"));
	}
}
