package com.flights;

import java.util.List;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.flights.objects.Flight;

public class LoadToFlightsTable {

	public static void main(String[] args) {


		String cassandraIP = args[0];
		int port = Integer.parseInt(args[1]);

		String username = "cassandra";
		String password = "cassandra";
		// Create a cluster instance
		Cluster cluster = Cluster.builder()
				.addContactPoint(cassandraIP)
				.withPort(port)
                .withCredentials(username.trim(), password.trim())
				.build();
		
		// Open a session with the cluster
		Session session = cluster.connect("flight_exercise");
		
		System.out.println("Processing CSV file ...");
		
		List<Flight> flightList = ProcessFlightsCSV.processFlights("flights_from_pg.csv");
		
		for (Flight flight : flightList) {
			
			//System.out.println(flight);
			
			Insert query = QueryBuilder.insertInto("flights_q1")
					.value("id", flight.getId())
					.value("year", flight.getYear())
					.value("fl_date", flight.getFlDate())
					.value("airline_id", flight.getAirlineId())
					.value("carrier", flight.getCarrier())
					.value("fl_num", flight.getFlNum())
					.value("origin_airport_id", flight.getOriginAirportId())
					.value("origin", flight.getOrigin())
					.value("origin_city_name", flight.getOriginCityName())
					.value("origin_state_abr", flight.getOriginStateAbr())
					.value("dest", flight.getDest())
					.value("day_of_month", flight.getDayOfMonth())
					.value("dest_city_name", flight.getDestCityName())
					.value("dest_state_abr", flight.getDestStateAbr())
					.value("dep_time", flight.getDepTime())
					.value("arr_time", flight.getArrTime())
					.value("distance", flight.getDistance())
					;
			
			session.execute(query);
		}

		session.close();
		cluster.close();
	}
}
