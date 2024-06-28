package com.S4sprint1.client;

public class ClientUI {
    public static final String BASE_URL = "http://localhost:8080";
    public static final String CITY_URL = BASE_URL + "/city" + "/{id}";
    public static final String CITIES_URL = BASE_URL + "/cities";
    public static final String AIRPORT_URL = BASE_URL + "/airport" + "/{id}";
    public static final String AIRPORTS_URL = BASE_URL + "/airports";
    public static final String AIRCRAFT_URL = BASE_URL + "/aircraft" + "/{id}";
    public static final String AIRCRAFT_LIST_URL = BASE_URL + "/aircraft";
    public static final String FLIGHT_URL = BASE_URL + "/flight" + "/{id}";
    public static final String FLIGHTS_URL = BASE_URL + "/flights";
    public static final String PASSENGER_URL = BASE_URL + "/passenger" + "/{id}";
    public static final String PASSENGERS_URL = BASE_URL + "/passengers";
    public static final String PASSENGERS_FLIGHTS_URL = BASE_URL + "/flights?find=passenger&id=" + "{id}";
    public static final String AIRCRAFT_FLIGHTS_URL = BASE_URL + "/flights?find=aircraft&id=" + "{id}";
}