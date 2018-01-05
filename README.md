# cassandra-example

This repo is simple example on how load csv data into cassadra

Steps
Install docker
Run DSE Images:
docker run --privileged -e DS_LICENSE=accept --name my-dse -d -P store/datastax/dse-server:5.1.5 -k -s
docker run -e DS_LICENSE=accept --link my-dse --name my-studio -p 9091:9091 -d datastax/dse-studio

Open Datastax studio
http://yourdockerhost:9091

Create keyspace
CREATE KEYSPACE flight_exercise
  WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };


 Create tables


  CREATE TABLE flights_q1 (
  id INT,
  year INT,
  fl_date date,
  airline_id INT,
  carrier text,
  fl_num INT,
  origin_airport_id INT,
  origin text,
  origin_city_name text,
  origin_state_abr text,
  dest text,
  day_of_month INT,
  dest_city_name text,
  dest_state_abr text,
  dep_time INT,
  arr_time INT,
  distance INT,
  PRIMARY KEY ((origin), fl_date, dep_time, id ))
  WITH CLUSTERING ORDER BY (fl_date DESC , dep_time DESC)


CREATE TABLE flights_q2 (
  fl_date date,
  carrier text,
  origin text,
  dest text,
  dep_time INT,
  PRIMARY KEY (fl_date, dep_time))
  WITH CLUSTERING ORDER BY (dep_time DESC)


CREATE TABLE flights_q3 (
fl_date date,
origin text,
PRIMARY KEY ((origin, fl_date)))



Git clone this repo
git clone https://github.com/sunileman/cassandra-example.git


Cd into
cd cassandra-example/FlightExercise/flights-data

clean and build
mvn clean package

cd into target directory

run application to load cassandra
java -jar cassandra.jar <yourHostIp> <CassandraPort>





