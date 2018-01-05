package com.flights;

import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.flights.objects.Flight;

import java.util.List;

public class FlightLoaderForQuestions {
    Session session;
    List<Flight> flightList;


    public FlightLoaderForQuestions(Session session, List<Flight> flightList) {
        this.session = session;
        this.flightList = flightList;

    }

    public void loadFlights(){
        System.out.println("Starting Load Process");
        loadq1();
        loadq2();
        loadq3();
        System.out.println("Load Process Finished");
    }

    private void loadq1(){

        System.out.println("Loading flights_q1");

        for (Flight flight : flightList) {


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

    }

    private void loadq2(){

        System.out.println("Loading flights_q2");

        for (Flight flight : flightList) {

            //System.out.println(flight);

            Insert query = QueryBuilder.insertInto("flights_q2")
                    .value("id", flight.getId())
                    .value("fl_date", flight.getFlDate())
                    .value("carrier", flight.getCarrier())
                    .value("origin", flight.getOrigin())
                    .value("dest", flight.getDest())
                    .value("dep_time", flight.getDepTime())
                    ;

            session.execute(query);
        }

    }

    private void loadq3(){
        System.out.println("Loading flights_q3");

        for (Flight flight : flightList) {

            //System.out.println(flight);

            Insert query = QueryBuilder.insertInto("flights_q3")
                    .value("id", flight.getId())
                    .value("fl_date", flight.getFlDate())
                    .value("origin", flight.getOrigin())
                    ;

            session.execute(query);
        }

    }

}
