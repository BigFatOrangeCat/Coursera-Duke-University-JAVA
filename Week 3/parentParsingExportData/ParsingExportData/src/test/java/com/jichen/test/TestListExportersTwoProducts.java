package com.jichen.test;

import org.apache.commons.csv.CSVParser;
import org.junit.Test;

import com.jichen.service.ParsingExportData;

import edu.duke.FileResource;

public class TestListExportersTwoProducts {
	@Test
	public void test2() {
		FileResource fr = new FileResource("exports_small.csv");
		CSVParser parser = fr.getCSVParser();
		ParsingExportData ped = new ParsingExportData();
		ped.listExportersTwoProducts(parser, "gold", "diamonds");
	}
}
