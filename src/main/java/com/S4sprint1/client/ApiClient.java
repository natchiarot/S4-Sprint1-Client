package com.S4sprint1.client;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.JSONArray;

public class ApiClient {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("No command line arguments found. Enter a valid command or 'help' for all commands.");
            return;
        }

        switch(args[0]) {
            case "help":
                System.out.println(String.format("%35s", "HELP"));
                System.out.println(String.format("%-50s %s", "* \"get_city\" [id]", "gets a specific city by id."));
                System.out.println(String.format("%-50s %s", "* \"get_cities\"", "gets a list of all cities."));
                System.out.println(String.format("%-50s %s", "* \"get_airport\" [id]", "gets a specific airport by id."));
                System.out.println(String.format("%-50s %s", "* \"get_airports\"", "gets a list of all airports."));
                System.out.println(String.format("%-50s %s", "* \"get_aircraft\" [id]", "gets a specific aircraft by id."));
                System.out.println(String.format("%-50s %s", "* \"get_all_aircraft\"", "gets a list of every aircraft."));
                System.out.println(String.format("%-50s %s", "* \"get_flight\" [id]", "gets a specific flight by id."));
                System.out.println(String.format("%-50s %s", "* \"get_flights\"", "gets a list of all flights."));
                System.out.println(String.format("%-50s %s", "* \"get_passenger\" [id]", "gets a specific passenger by id."));
                System.out.println(String.format("%-50s %s", "* \"get_passengers\"", "gets a list of all passengers."));
                System.out.println(String.format("%-50s %s", "* \"get_cities_airports\" [id]", "gets airports in a specific city."));
                System.out.println(String.format("%-50s %s", "* \"get_aircraft_list_for_passenger\" [id]", "lists all aircraft a specific passenger has travelled on."));
                System.out.println(String.format("%-50s %s", "* \"get_takeoff_and_landing\" [id]", "lists all airports a specific aircraft can take off from and land at."));
                System.out.println(String.format("%-50s %s", "* \"get_airports_list_for_passenger\" [id]", "lists airports a specific passenger has used."));

                break;
            case "get_city":
                if (args.length == 2) {
                    String id = args[1];
                    String command = ClientUI.CITY_URL.replace("{id}", id);
                    try {
                        String response = getRequest(command);
                        Object data = JSONValue.parse(response);
                        JSONObject jsonObjectDecode = (JSONObject) data;

                        long cityId = (long)jsonObjectDecode.get("id");
                        String name = (String)jsonObjectDecode.get("name");
                        String state = (String)jsonObjectDecode.get("state");
                        long population = (long)jsonObjectDecode.get("population");
                        System.out.println("Id: " + cityId + " \nName: " + name + " \nState: " + state + " \nPopulation: " + population);

                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                }
                } else {
                    System.out.println("Please provide a valid city id.");
                }
                break;

            case "get_cities":
                if (args.length == 1) {
                    String command = ClientUI.CITIES_URL;
                    try {
                        String response = getRequest(command);
                        Object data = JSONValue.parse(response);
                        JSONArray jsonArrayDecode = (JSONArray) data;

                        for (Object citiesObj : jsonArrayDecode) {
                            JSONObject jsonObjectDecode = (JSONObject) citiesObj;

                            long cityId = (long) jsonObjectDecode.get("id");
                            String name = (String) jsonObjectDecode.get("name");
                            String state = (String) jsonObjectDecode.get("state");
                            long population = (long) jsonObjectDecode.get("population");

                            System.out.println("Id: " + cityId + " \nName: " + name + " \nState: " + state + " \nPopulation: " + population);
                        }

                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                } else {
                    System.out.println("Please provide valid number of arguments (1).");
                }
                break;

            case "get_airport":
                if (args.length == 2) {
                    String id = args[1];
                    String command = ClientUI.AIRPORT_URL.replace("{id}", id);
                    try {
                        String response = getRequest(command);
                        Object data = JSONValue.parse(response);
                        JSONObject jsonObjectDecode = (JSONObject) data;

                        long airportId = (long)jsonObjectDecode.get("id");
                        String name = (String)jsonObjectDecode.get("name");
                        String code = (String)jsonObjectDecode.get("code");
                        System.out.println("Id: " + airportId + " \nName: " + name + " \nCode: " + code);

                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                } else {
                    System.out.println("Please provide a valid airport id.");
                }
                break;

            case "get_airports":
                if (args.length == 1) {
                    String command = ClientUI.AIRPORTS_URL;
                    try {
                        String response = getRequest(command);
                        Object data = JSONValue.parse(response);
                        JSONArray jsonArrayDecode = (JSONArray) data;

                        for (Object airportsObj : jsonArrayDecode) {
                            JSONObject jsonObjectDecode = (JSONObject) airportsObj;

                            long airportId = (long) jsonObjectDecode.get("id");
                            String name = (String) jsonObjectDecode.get("name");
                            String code = (String) jsonObjectDecode.get("code");

                            System.out.println("Id: " + airportId + " \nName: " + name + " \nCode: " + code);
                        }
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                } else {
                    System.out.println("Please provide valid number of arguments (1).");
                }
                break;

            case "get_aircraft":
                if (args.length == 2) {
                    String id = args[1];
                    String command = ClientUI.AIRCRAFT_URL.replace("{id}", id);
                    try {
                        String response = getRequest(command);
                        Object data = JSONValue.parse(response);
                        JSONObject jsonObjectDecode = (JSONObject) data;

                        long aircraftId = (long)jsonObjectDecode.get("id");
                        String type = (String)jsonObjectDecode.get("type");
                        String airlineName = (String)jsonObjectDecode.get("airlineName");
                        long maxCapacity = (long)jsonObjectDecode.get("maxCapacity");
                        long airportId = (long)jsonObjectDecode.get("airportId");

                        System.out.println("Id: " + aircraftId + " \nType: " + type + " \nAirline Name:" + airlineName + " \nMaximum Capacity: " + maxCapacity + " \nAirport Id: " + airportId);

                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                } else {
                    System.out.println("Please provide a valid aircraft id.");
                }
                break;

            case "get_all_aircraft":
                if (args.length == 1) {
                    String command = ClientUI.AIRCRAFT_LIST_URL;
                    try {
                        String response = getRequest(command);
                        Object data = JSONValue.parse(response);
                        JSONArray jsonArrayDecode = (JSONArray) data;

                        for (Object allAircraftObj : jsonArrayDecode) {
                            JSONObject jsonObjectDecode = (JSONObject) allAircraftObj;

                            long aircraftId = (long)jsonObjectDecode.get("id");
                            String type = (String)jsonObjectDecode.get("type");
                            String airlineName = (String)jsonObjectDecode.get("airlineName");
                            long maxCapacity = (long)jsonObjectDecode.get("maxCapacity");
                            long airportId = (long)jsonObjectDecode.get("airportId");

                            System.out.println("Id: " + aircraftId + " \nType: " + type + " \nAirline Name:" + airlineName + " \nMaximum Capacity: " + maxCapacity + " \nAirport Id: " + airportId);
                        }
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                } else {
                    System.out.println("Please provide valid number of arguments (1).");
                }
                break;

            case "get_flight":
                if (args.length == 2) {
                    String id = args[1];
                    String command = ClientUI.FLIGHT_URL.replace("{id}", id);
                    try {
                        String response = getRequest(command);
                        Object data = JSONValue.parse(response);
                        JSONObject jsonObjectDecode = (JSONObject) data;

                        long flightId = (long)jsonObjectDecode.get("id");
                        String expDeparture = (String)jsonObjectDecode.get("expDeparture");
                        String expArrival = (String)jsonObjectDecode.get("expArrival");
                        long fromAirportId = (long)jsonObjectDecode.get("fromAirportId");
                        long toAirportId = (long)jsonObjectDecode.get("toAirportId");
                        long aircraftId = (long)jsonObjectDecode.get("aircraftId");
                        long passengerId = (long)jsonObjectDecode.get("passengerId");

                        System.out.println("Id: " + flightId + " \nExpected Departure: " + expDeparture + " \nExpected Arrival: " + expArrival + " \nFrom Airport Id: " + fromAirportId + " \nTo Airport Id: " + toAirportId + " \nAircraft Id: " + aircraftId + " \nPassenger Id: " + passengerId);

                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                } else {
                    System.out.println("Please provide a valid flight id.");
                }
                break;

            case "get_flights":
                if (args.length == 1) {
                    String command = ClientUI.FLIGHTS_URL;
                    try {
                        String response = getRequest(command);
                        Object data = JSONValue.parse(response);
                        JSONArray jsonArrayDecode = (JSONArray) data;

                        for (Object flightsObj : jsonArrayDecode) {
                            JSONObject jsonObjectDecode = (JSONObject) flightsObj;

                            long flightId = (long)jsonObjectDecode.get("id");
                            String expDeparture = (String)jsonObjectDecode.get("expDeparture");
                            String expArrival = (String)jsonObjectDecode.get("expArrival");
                            long fromAirportId = (long)jsonObjectDecode.get("fromAirportId");
                            long toAirportId = (long)jsonObjectDecode.get("toAirportId");
                            long aircraftId = (long)jsonObjectDecode.get("aircraftId");
                            long passengerId = (long)jsonObjectDecode.get("passengerId");

                            System.out.println("Id: " + flightId + " \nExpected Departure: " + expDeparture + " \nExpected Arrival: " + expArrival + " \nFrom Airport Id: " + fromAirportId + " \nTo Airport Id: " + toAirportId + " \nAircraft Id: " + aircraftId + " \nPassenger Id: " + passengerId);

                        }
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                } else {
                    System.out.println("Please provide valid number of arguments (1).");
                }
                break;

            case "get_passenger":
                if (args.length == 2) {
                    String id = args[1];
                    String command = ClientUI.PASSENGER_URL.replace("{id}", id);
                    try {
                        String response = getRequest(command);
                        Object data = JSONValue.parse(response);
                        JSONObject jsonObjectDecode = (JSONObject) data;

                        long passengerId = (long)jsonObjectDecode.get("id");
                        String firstName = (String)jsonObjectDecode.get("firstName");
                        String lastName = (String)jsonObjectDecode.get("lastName");
                        String phoneNumber = (String)jsonObjectDecode.get("phoneNumber");
                        long homeCityId = (long)jsonObjectDecode.get("homeCityId");

                        System.out.println("Id: " + passengerId + " Name: " + firstName + " " + lastName + " \n Phone Number: " + phoneNumber + " \nHome City Id: " + homeCityId);

                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                } else {
                    System.out.println("Please provide a valid passenger id.");
                }
                break;

            case "get_passengers":
                if (args.length == 1) {
                    String command = ClientUI.PASSENGERS_URL;
                    try {
                        String response = getRequest(command);
                        Object data = JSONValue.parse(response);
                        JSONArray jsonArrayDecode = (JSONArray) data;

                        for (Object passengersObj : jsonArrayDecode) {
                            JSONObject jsonObjectDecode = (JSONObject) passengersObj;

                            long passengerId = (long)jsonObjectDecode.get("id");
                            String firstName = (String)jsonObjectDecode.get("firstName");
                            String lastName = (String)jsonObjectDecode.get("lastName");
                            String phoneNumber = (String)jsonObjectDecode.get("phoneNumber");
                            long homeCityId = (long)jsonObjectDecode.get("homeCityId");

                            System.out.println("Id: " + passengerId + " Name: " + firstName + " " + lastName + " \n Phone Number: " + phoneNumber + " \nHome City Id: " + homeCityId);

                        }
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                } else {
                    System.out.println("Please provide valid number of arguments (1).");
                }
                break;

            case "get_cities_airports":
                if (args.length == 2) {
                    String id = args[1];
                    String command = ClientUI.CITY_URL.replace("{id}", id);
                    try {
                        String response = getRequest(command);
                        Object data = JSONValue.parse(response);
                        JSONObject jsonObjectDecode = (JSONObject) data;

                        long cityId = (long)jsonObjectDecode.get("id");
                        String cityName = (String)jsonObjectDecode.get("name");

                        JSONArray airportsArray = (JSONArray) jsonObjectDecode.get("airports");

                        for (Object airportsObj : airportsArray) {
                            JSONObject airports = (JSONObject) airportsObj;
                            long airportsId = (long) airports.get("id");
                            String name = (String) airports.get("name");
                            String code = (String) airports.get("code");
                            System.out.println("City Id: " + cityId + " \nName of City: " + cityName + " \nAirports Id: " + airportsId + " \nAirports Name: " + name + " \nAirports Code: " + code);
                        }
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                } else {
                    System.out.println("Please provide a valid city id.");
                }
                break;

            case "get_aircraft_list_for_passenger":
                if (args.length == 2) {
                    String id = args[1];
                    String command = ClientUI.PASSENGERS_FLIGHTS_URL.replace("{id}", id);
                    try {
                        String response = getRequest(command);
                        Object data = JSONValue.parse(response);
                        JSONArray jsonArrayDecode = (JSONArray) data;

                        for (Object pAAObj : jsonArrayDecode) {
                            JSONObject jsonObjectDecode = (JSONObject) pAAObj;

                            long pAAId = (long) jsonObjectDecode.get("aircraftId");

                            String aircraftIdString = Long.toString(pAAId);
                            String pAACommand = ClientUI.AIRCRAFT_URL.replace("{id}", aircraftIdString);

                            String pAAResponse = getRequest(pAACommand);
                            Object pAAData = JSONValue.parse(pAAResponse);
                            JSONObject pAAJsonObjectDecode = (JSONObject) pAAData;

                            long aircraftId = (long) pAAJsonObjectDecode.get("id");
                            String type = (String) pAAJsonObjectDecode.get("type");
                            String airlineName = (String) pAAJsonObjectDecode.get("airlineName");
                            long maxCapacity = (long) pAAJsonObjectDecode.get("maxCapacity");
                            long airportId = (long) pAAJsonObjectDecode.get("airportId");

                            System.out.println("Aircraft Id: " + aircraftId + " \nAircraft Type: " + type + " \nAirline Name: " + airlineName + " \nMaximum Capacity" + maxCapacity + " \nAirport Id: " + airportId);
                        }

                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                } else {
                    System.out.println("Please provide a valid passenger id.");
                }
                break;

            case "get_takeoff_and_landing":
                if (args.length == 2) {
                    String id = args[1];
                    String command2 = ClientUI.AIRCRAFT_DESTINATIONS_URL.replace("{id}", id);
                    String command = ClientUI.AIRCRAFT_URL.replace("{id}", id);
                    try {
                        String response = getRequest(command);
                        Object data = JSONValue.parse(response);
                        JSONObject jsonObjectDecode = (JSONObject) data;

                        String response2 = getRequest(command2);
                        Object data2 = JSONValue.parse(response2);
                        JSONArray jsonArrayDecode2 = (JSONArray) data2;

                        long airportId = (long) jsonObjectDecode.get("airportId");

                        String airportIdString = Long.toString(airportId);
                        String takeoffCommand = ClientUI.AIRPORT_URL.replace("{id}", airportIdString);

                        String takeoffResponse = getRequest(takeoffCommand);
                        Object takeoffData = JSONValue.parse(takeoffResponse);
                        JSONObject takeoffJsonObjectDecode = (JSONObject) takeoffData;

                        long airportId1 = (long) takeoffJsonObjectDecode.get("id");
                        String name = (String) takeoffJsonObjectDecode.get("name");
                        String code = (String) takeoffJsonObjectDecode.get("code");
                        System.out.println("Take off from:");
                        System.out.println("Id: " + airportId1 + " \nAirline Name: " + name + " \nAirline Code: " + code);

                        System.out.println("\nLanding:");

                        for (Object landingObj : jsonArrayDecode2) {
                            JSONObject jsonObjectDecode2 = (JSONObject) landingObj;

                            long airportId2 = (long) jsonObjectDecode2.get("id");
                            String name2 = (String) jsonObjectDecode2.get("name");
                            String code2 = (String) jsonObjectDecode2.get("code");

                            System.out.println("Id: " + airportId2 + " \nAirline Name: " + name2 + " \nAirline Code: " + code2 + "\n");

                        }


                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                } else {
                    System.out.println("Please provide a valid passenger id.");
                }
                break;

            case "get_airports_list_for_passenger":
                if (args.length == 2) {
                    String id = args[1];
                    String command = ClientUI.PASSENGERS_FLIGHTS_URL.replace("{id}", id);
                    try {
                        String response = getRequest(command);
                        Object data = JSONValue.parse(response);
                        JSONArray jsonArrayDecode = (JSONArray) data;

                        for (Object passengerAirportsObj : jsonArrayDecode) {
                            JSONObject jsonObjectDecode = (JSONObject) passengerAirportsObj;

                            long fromAirportId = (long) jsonObjectDecode.get("fromAirportId");
                            long toAirportId = (long) jsonObjectDecode.get("toAirportId");

                            String fromAirportIdString = Long.toString(fromAirportId);
                            String fPACommand = ClientUI.AIRPORT_URL.replace("{id}", fromAirportIdString);

                            String fPAResponse = getRequest(fPACommand);
                            Object fPAData = JSONValue.parse(fPAResponse);
                            JSONObject fPAJsonObjectDecode = (JSONObject) fPAData;

                            long airportId = (long) fPAJsonObjectDecode.get("id");
                            String name = (String) fPAJsonObjectDecode.get("name");
                            String code = (String) fPAJsonObjectDecode.get("code");

                            System.out.println("Airport Id: " + airportId + " \nName: " + name + " \nCode" + code);

                            String toAirportIdString = Long.toString(toAirportId);
                            String tPACommand = ClientUI.AIRPORT_URL.replace("{id}", toAirportIdString);

                            String tPAResponse = getRequest(tPACommand);
                            Object tPAData = JSONValue.parse(tPAResponse);
                            JSONObject tPAJsonObjectDecode = (JSONObject) tPAData;

                            long airportId2 = (long) tPAJsonObjectDecode.get("id");
                            String name2 = (String) tPAJsonObjectDecode.get("name");
                            String code2 = (String) tPAJsonObjectDecode.get("code");

                            System.out.println("Airport Id: " + airportId2 + " \nName: " + name2 + " \nCode" + code2);
                        }

                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                } else {
                    System.out.println("Please provide a valid passenger id.");
                }
                break;

            default:
                System.out.println("Unknown command. Enter a valid command or 'help' for all commands.");
        }
    }

    public static String getRequest(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        return EntityUtils.toString(httpResponse.getEntity());
    }

    public static String getRequest(CloseableHttpClient httpClient, String url) {
        try {
            HttpGet httpGet = new HttpGet(url);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            return EntityUtils.toString(httpResponse.getEntity());
        } catch (IOException e) {
            return ("Error: " + e.getMessage());
        }
    }
}

