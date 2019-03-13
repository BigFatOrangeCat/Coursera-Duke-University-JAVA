package com.jichen.test;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.junit.Test;

import com.jichen.service.ParsingExportData;

public class testPED {
    @Test
    public void test(){
        FileResource fr = new FileResource("exports_small.csv");
        CSVParser parser = fr.getCSVParser();
        ParsingExportData ped = new ParsingExportData();
		System.out.println(ped.countryInfo(parser, "Germany"));
	}
    
}

