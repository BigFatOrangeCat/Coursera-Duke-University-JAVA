package com.jichen.service;

import org.apache.commons.csv.*;

public class ParsingExportData {

	public String countryInfo(CSVParser parser, String country) {
		for (CSVRecord record : parser) {
			String countryName = record.get("Country");
			if (countryName.contains(country)) {
				String exports = record.get("Exports");
				String value = record.get("Value (dollars)");
				return countryName + ": " + exports + ": " + value;
			}
		}
		return "There is so such country in the document";
	}

	public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
		for (CSVRecord record : parser) {
			String item = record.get("Exports");
			if (item.contains(exportItem1) && item.contains(exportItem2)) {
				String countryName = record.get("Country");
				System.out.println(countryName);
			}
		}
	}

	public int numberOfExporters(CSVParser parser, String exportItem) {
		int count = 0;
		for (CSVRecord record : parser) {
			String item = record.get("Exports");
			if (item.contains(exportItem)) {
				count += 1;
			}
		}
		return count;
	}

	public void bigExporters(CSVParser parser, String amount) {
		for (CSVRecord record : parser) {
			String money = record.get("Value (dollars)");
			if (money.length() > amount.length()) {
				String countryName = record.get("Country");
				System.out.println(countryName + " " + money);
			}
		}
	}
}
