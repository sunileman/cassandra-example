package com.flights;

import java.util.List;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.flights.objects.Flight;

public class LoadToFlightsTable {

	public static void main(String[] args) {


		String cassandraIP = args[0];
		int port = Integer.parseInt(args[1]);

		String username = "cassandra";
		String password = "cassandra";
		// Create a cluster instance
		//default port is 9042
		Cluster cluster = Cluster.builder()
				.addContactPoint(cassandraIP)
				.withPort(port)
                .withCredentials(username.trim(), password.trim())
				.build();
		
		// Open a session with the cluster
		Session session = cluster.connect("flight_exercise");

		//Load csv into flight list objects
		List<Flight> flightList = ProcessFlightsCSV.processFlights("flights_from_pg.csv");

		//load cassandra
		new FlightLoaderForQuestions(session, flightList).loadFlights();


		//connection cleanup
		session.close();
		cluster.close();
	}
}
