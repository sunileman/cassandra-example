# cassandra-example

This repo is simple example on how load csv data into cassadra

Steps<br>
Install docker<br>
Run DSE Images:<br>
docker run --privileged -e DS_LICENSE=accept --name my-dse -d -P store/datastax/dse-server:5.1.5 -k -s<br>
docker run -e DS_LICENSE=accept --link my-dse --name my-studio -p 9091:9091 -d datastax/dse-studio<br>
<br>
Open Datastax studio<br>
http://yourdockerhost:9091<br>

Create keyspace<br>
CREATE KEYSPACE flight_exercise<br>
  WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };<br>
<br>
<br>
 Create tables
<br>
<br>
  CREATE TABLE flights_q1 (<br>
  id INT,<br>
  year INT,<br>
  fl_date date,<br>
  airline_id INT,<br>
  carrier text,<br>
  fl_num INT,<br>
  origin_airport_id INT,<br>
  origin text,<br>
  origin_city_name text,<br>
  origin_state_abr text,<br>
  dest text,<br>
  day_of_month INT,<br>
  dest_city_name text,<br>
  dest_state_abr text,<br>
  dep_time INT,<br>
  arr_time INT,<br>
  distance INT,<br>
  PRIMARY KEY ((origin), fl_date, dep_time, id ))<br>
  WITH CLUSTERING ORDER BY (fl_date DESC , dep_time DESC)<br>
<br>
<br>
CREATE TABLE flights_q2 (<br>
  fl_date date,<br>
  carrier text,<br>
  origin text,<br>
  dest text,<br>
  dep_time INT,<br>
  PRIMARY KEY (fl_date, dep_time))<br>
  WITH CLUSTERING ORDER BY (dep_time DESC)<br>
<br>
<br>
CREATE TABLE flights_q3 (<br>
fl_date date,<br>
origin text,<br>
PRIMARY KEY ((origin, fl_date)))<br>
<br>
<br>
<br>
Git clone this repo<br>
git clone https://github.com/sunileman/cassandra-example.git<br>
<br>
<br>
Cd into<br>
cd cassandra-example/FlightExercise/flights-data<br>
<br>
clean and build<br>
mvn clean package<br>
<br>
cd into target directory<br>
<br>
run application to load cassandra<br>
java -jar cassandra.jar <yourHostIp> <CassandraPort><br>





