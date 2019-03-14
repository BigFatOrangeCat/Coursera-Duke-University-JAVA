package fch.service.test;

import org.apache.commons.csv.CSVParser;
import org.junit.Test;

import edu.duke.FileResource;
import fch.service.FindColdestHour;

public class TestAverageTempWithHumidity {
	@Test
	public void testAverageTempWithHumidity() {
		FileResource fr = new FileResource("src/test/resources/nc_weather/2013/weather-2013-09-02.csv"); 
		CSVParser parser = fr.getCSVParser();
		FindColdestHour findColdestHour = new FindColdestHour();
		int value = 80;
		double averageTemp = findColdestHour.averageTemperatureWithHighHumidityInFile(parser, value);
		if (averageTemp == 0) {
			System.out.println("No temperature with that humidity");
		}
			else {
				System.out.println("Average Temp when high Humidity is " + averageTemp);
			}
	}
}
