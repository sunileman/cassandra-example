package com.flights.objects;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.datastax.driver.core.LocalDate;


public class Flight {
	
	  private int id;
	  private int actualElapsedTime;
	  private int airTime;
	  private int airlineId;
	  private int arrTime;
	  private String carrier;
	  private int dayOfMonth; 
	  private int depTime;
	  private String dest;
	  private String destCityName;
	  private String destStateAbr;
	  private int distance;
	  private String flDate;
	  private int flNum;
	  private String origin;
	  private int originAirportId;
	  private String originCityName;
	  private String originStateAbr;
	  private int year;
	  
	  public Flight(){}
	  
	  public int getId() {
		  return id;
	  }
	  
	  public void setId(int id){
		  this.id = id;
	  }
	  
	  public int getActualElapsedTime() {
		  return actualElapsedTime;
	  }
	  
	  public void setActualElapsedTime(int actualElapsedTime) {
		  this.actualElapsedTime = actualElapsedTime;
	  };
	  
	  public int getAirTime(){
		  return airTime;
	  }
	  
	  public void setAirTime(int airTime) {
		  this.airTime = airTime;
	  }
	  
	  public int getAirlineId() {
		  return airlineId;
	  }
	  
	  public void setAirlineId(int airlineId) {
		  this.airlineId = airlineId;
	  }
	  
	  public int getArrTime() {
		  return arrTime;
	  }
	  
	  public void setArrTime(int arrTime) {
		  this.arrTime = arrTime;
	  }
	  
	  public String getCarrier() {
		  return carrier;
	  }
	  
	  public void setCarrier(String carrier) {
		  this.carrier = carrier;
	  }
	  
	  public int getDayOfMonth() {
		  return dayOfMonth;
	  }
	  
 	  public void setDayOfMonth(int dayOfMonth) {
 		  this.dayOfMonth = dayOfMonth;
 	  }
 	  
 	  public int getDepTime() {
 		  return depTime;
 	  }
 	  
 	  public void setDepTime(int depTime) {
 		  this.depTime = depTime;
 	  }
 	  
 	  public String getDest() {
 		  return dest;
 	  }
 	  
 	  public void setDest(String dest) {
 		  this.dest = dest;
 	  }
 	  
 	  public String getDestCityName() {
 		  return destCityName;
 	  }
 	  
 	  public void setDestCityName(String destCityName) {
 		  this.destCityName = destCityName;
 	  }
 	  
 	  public String getDestStateAbr() {
 		  return destStateAbr;
 	  }
 	  
 	  public void setDestStateAbr(String destStateAbr) {
 		  this.destStateAbr = destStateAbr;
 	  }
 	  
 	  public int getDistance() {
 		  return distance;
 	  }
 	  
 	  public void setDistance(int distance) {
 		  this.distance = distance;
 	  }
 	  
 	  public LocalDate getFlDate() {




		  Date departdate = null;
		  try {
			  //SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
			  departdate = new SimpleDateFormat("yyyy/MM/dd").parse(flDate);

		  } catch (ParseException e) {
			  e.printStackTrace();
		  }


		  return LocalDate.fromMillisSinceEpoch(departdate.getTime());


	  }
 	  
 	  public void setFlDate(String flDate) {
 		  this.flDate = flDate;
 	  }
 	  
 	  public int getFlNum() {
 		  return flNum;
 	  }
 	  
 	  public void setFlNum(int flNum) {
 		  this.flNum = flNum;
 	  }
 	  
 	  public String getOrigin() {
 		  return origin;
 	  }
 	  
 	  public void setOrigin(String origin) {
 		  this.origin = origin;
 	  }
 	  
 	  public int getOriginAirportId() {
 		  return originAirportId;
 	  }
 	  
 	  public void setOriginAirportId(int originAirportId) {
 		  this.originAirportId = originAirportId;
 	  }
 	  
 	  public String getOriginCityName() {
 		 return originCityName;
 	  }
 	  
 	  public void setOriginCityName(String originCityName) {
 		  this.originCityName = originCityName;
 	  }
 	  
 	  public String getOriginStateAbr() {
 		  return originStateAbr;
 	  }
 	  
 	  public void setOriginStateAbr(String originStateAbr) {
 		  this.originStateAbr = originStateAbr;
 	  }
 	  
 	  public int getYear() {
 		  return year;
 	  }
 	  
 	  public void setYear(int year) {
 		  this.year = year;
 	  }
 	  
 	  
 	  
 	  
 	
	
}
