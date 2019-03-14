package fch.service;

import java.io.File;
import org.apache.commons.csv.*;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

public class FindColdestHour {
	
	public CSVRecord coldestHourInFile(CSVParser parser) {
		CSVRecord coldestSoFar = null;
		for (CSVRecord currRow : parser) {
			if (coldestSoFar == null) {
				coldestSoFar = currRow;
			}
			else {
				double currTemp = Double.parseDouble(currRow.get("TemperatureF"));
				double coldestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
				if (coldestTemp > currTemp) {
					coldestTemp = currTemp;
					coldestSoFar = currRow;
				}
			}
		}
		return coldestSoFar;
	}
	
	public void fileWithColdestTemperature () {
		String name = "";
		CSVRecord coldestSoFar = null;
		DirectoryResource dr = new DirectoryResource();
		for (File f : dr.selectedFiles()) {
			FileResource fr = new FileResource(f);
			CSVRecord currRow = coldestHourInFile(fr.getCSVParser());
			if (coldestSoFar  == null) {
				coldestSoFar = currRow;
			}
			else {
				double currTemp = Double.parseDouble(currRow.get("TemperatureF"))	;
				double coldestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
				if (currTemp < coldestTemp && currTemp != -9999) {
					coldestTemp = currTemp;
					coldestSoFar = currRow;
					name = f.getName();
				}
			}
		}
		System.out.println("Coldest day was in file " + name);
		System.out.println("Coldest temperature on that day was " + coldestSoFar.get("TemperatureF"));
		System.out.println("All the temperature on the coldest day were: ");
		
		FileResource file = new FileResource("src/test/resources/nc_weather/2013/" + name);
		for(CSVRecord record : file.getCSVParser()) {
            String date = record.get("DateUTC");
            String temp = record.get("TemperatureF");
            System.out.println(date + " " + temp);
        }
	}
	
	public CSVRecord lowestHumidityInFile (CSVParser parser) {
		CSVRecord humiSoFar = null;
		for (CSVRecord currRow : parser) {
			if (humiSoFar == null) {
				humiSoFar = currRow;
			}
			else {
				if (!currRow.get("Humidity").equals("N/A")) {
					double currHumi = Double.parseDouble(currRow.get("Humidity"));
					double humiest = Double.parseDouble(humiSoFar.get("Humidity"));
					if (humiest > currHumi) {
						humiest = currHumi;
						humiSoFar = currRow;
					}
				}
			}
		}
		return humiSoFar;
	}
	
	public void lowestHumidityInManyFiles () {
		//String name = "";
		CSVRecord humiSoFar = null;
		DirectoryResource dr = new DirectoryResource();
		for (File f : dr.selectedFiles()) {
			FileResource fr = new FileResource(f);
			CSVRecord currRow = lowestHumidityInFile(fr.getCSVParser());
			if (humiSoFar  == null) {
				humiSoFar = currRow;
			}
			else {
				if (!currRow.get("Humidity").equals("N/A")) {
					double currHumi = Double.parseDouble(currRow.get("Humidity"))	;
					double humiest = Double.parseDouble(humiSoFar.get("Humidity"));
					if (humiest > currHumi) {
						humiest = currHumi;
						humiSoFar = currRow;
						//name = f.getName();
					}
				}
			}
		}
		//System.out.println("Coldest day was in file " + name);
		System.out.println("Lowest Humidity was " + humiSoFar.get("Humidity") + " at " + humiSoFar.get("DateUTC"));
		/*System.out.println("All the temperature on the coldest day were: ");
		
		FileResource file = new FileResource("src/test/resources/nc_weather/2014/" + name);
		for(CSVRecord record : file.getCSVParser()) {
            String date = record.get("DateUTC");
            String temp = record.get("TemperatureF");
            System.out.println(date + " " + temp);
        }*/
	}
	
	public double averageTemperatureInFile(CSVParser parser) {
		double averageTemp = 0.0;
		int count = 0;
		double currTemp = 0.0;
		double sumTemp = 0.0;
		for (CSVRecord currRow : parser) {
				 currTemp = Double.parseDouble(currRow.get("TemperatureF"));
				 sumTemp = sumTemp + currTemp;
				count += 1;
			}
		averageTemp = sumTemp / count;
		return averageTemp;
	}
	
	public double averageTemperatureWithHighHumidityInFile(CSVParser parser, Integer value) {
		double averageTemp = 0.0;
		int count = 0;
		double currTemp = 0.0;
		double sumTemp = 0.0;
		for (CSVRecord currRow : parser) {
				currTemp = Double.parseDouble(currRow.get("TemperatureF"));
				double currHumi = Double.parseDouble(currRow.get("Humidity"));
				if (currHumi >= value) {
					sumTemp = sumTemp + currTemp;
					count += 1;
				}
			}
		if (count == 0) {
			return 0;
		}
		averageTemp = sumTemp / count;
		return averageTemp;
	}
}

