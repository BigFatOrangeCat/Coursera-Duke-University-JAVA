package com.jichen.test;

import org.apache.commons.csv.CSVParser;
import org.junit.Test;

import com.jichen.service.ParsingExportData;

import edu.duke.FileResource;

public class TestNumberOfExporters {
	@Test
	public void testNumberOfExporters() {
		FileResource fr = new FileResource("exports_small.csv");
		CSVParser parser = fr.getCSVParser();
		ParsingExportData ped = new ParsingExportData();
		System.out.println(ped.numberOfExporters(parser, "gold"));
	}
}
