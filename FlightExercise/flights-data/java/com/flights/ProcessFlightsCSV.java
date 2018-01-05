package com.flights;


import java.util.ArrayList;
import java.util.List;

import com.flights.objects.Flight;
import com.flights.utils.FileUtils;

public class ProcessFlightsCSV {
	
	private static final String COMMA = ",";
	
	public static List<Flight> processFlights(String filename){
		
		List<Flight> flights = new ArrayList<Flight>();
		
		List<String> readFileIntoList = FileUtils.readFileIntoList(filename);
		
		Flight flight;
		
		for (String row : readFileIntoList) {
			
			String[] items = row.split(COMMA);
			flight = new Flight();
			flight.setId(Integer.parseInt(items[0]));
			flight.setYear(Integer.parseInt(items[1]));
			flight.setDayOfMonth(Integer.parseInt(items[2]));
			flight.setFlDate(items[3]);
			flight.setAirlineId(Integer.parseInt(items[4]));
			flight.setCarrier(items[5]);
			flight.setFlNum(Integer.parseInt(items[6]));
			flight.setOriginAirportId(Integer.parseInt(items[7]));
			flight.setOrigin(items[8]);
			flight.setOriginCityName(items[9]);
			flight.setOriginStateAbr(items[10]);
			flight.setDest(items[11]);
			flight.setDestCityName(items[12]);
			flight.setDestStateAbr(items[13]);
			flight.setDepTime(Integer.parseInt(items[14]));
			flight.setArrTime(Integer.parseInt(items[15]));
			flight.setDistance(Integer.parseInt(items[16]));
			flights.add(flight);
		}
		
		return flights;
	}
}
