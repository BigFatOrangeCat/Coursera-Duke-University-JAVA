package com.jichen.test;

import org.apache.commons.csv.CSVParser;
import org.junit.Test;

import com.jichen.service.ParsingExportData;

import edu.duke.FileResource;

public class TestBigExporters {
	@Test
	public void testBigExporters() {
		FileResource fr = new FileResource("exports_small.csv");
		CSVParser parser = fr.getCSVParser();
		ParsingExportData ped = new ParsingExportData();
		ped.bigExporters(parser, "$999,999,999");
	}
}
