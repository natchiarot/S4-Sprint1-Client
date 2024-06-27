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
                System.out.println("Help page:");

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
                        System.out.println(cityId + " " + name + " " + state + " " + population);

                    } catch (IOException e) {
                    e.printStackTrace();
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

                            System.out.println(cityId + " " + name + " " + state + " " + population);
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
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
                        System.out.println(airportId + " " + name + " " + code);

                    } catch (IOException e) {
                        e.printStackTrace();
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

                            System.out.println(airportId + " " + name + " " + code);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
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

                        System.out.println(aircraftId + " " + type + " " + airlineName + " " + maxCapacity + " " + airportId);

                    } catch (IOException e) {
                        e.printStackTrace();
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

                            System.out.println(aircraftId + " " + type + " " + airlineName + " " + maxCapacity + " " + airportId);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
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

                        System.out.println(flightId + " " + expDeparture + " " + expArrival + " " + fromAirportId + " " + toAirportId + " " + aircraftId + " " + passengerId);

                    } catch (IOException e) {
                        e.printStackTrace();
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

                            System.out.println(flightId + " " + expDeparture + " " + expArrival + " " + fromAirportId + " " + toAirportId + " " + aircraftId + " " + passengerId);

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
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

                        System.out.println(passengerId + " " + firstName + " " + lastName + " " + phoneNumber + " " + homeCityId);

                    } catch (IOException e) {
                        e.printStackTrace();
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

                            System.out.println(passengerId + " " + firstName + " " + lastName + " " + phoneNumber + " " + homeCityId);

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
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
                            System.out.println(cityId + " " + cityName + " " + airportsId + " " + name + " " + code);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
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

                            System.out.println(aircraftId + " " + type + " " + airlineName + " " + maxCapacity + " " + airportId);
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Please provide a valid passenger id.");
                }
                break;

            case "get_takeoff_and_landing":
                if (args.length == 2) {
                    String id = args[1];
                    String command = ClientUI.PASSENGERS_FLIGHTS_URL.replace("{id}", id);
                    try {
                        String response = getRequest(command);
                        Object data = JSONValue.parse(response);
                        JSONArray jsonArrayDecode = (JSONArray) data;

                        for (Object takeoffLandingObj : jsonArrayDecode) {
                            JSONObject jsonObjectDecode = (JSONObject) takeoffLandingObj;

                            long fromAirportId = (long) jsonObjectDecode.get("fromAirportId");
                            long toAirportId = (long) jsonObjectDecode.get("toAirportId");

                            String fromAirportIdString = Long.toString(fromAirportId);
                            String takeoffCommand = ClientUI.AIRPORT_URL.replace("{id}", fromAirportIdString);

                            String takeoffResponse = getRequest(takeoffCommand);
                            Object takeoffData = JSONValue.parse(takeoffResponse);
                            JSONObject takeoffJsonObjectDecode = (JSONObject) takeoffData;

                            long airportId = (long) takeoffJsonObjectDecode.get("id");
                            String name = (String) takeoffJsonObjectDecode.get("name");
                            String code = (String) takeoffJsonObjectDecode.get("code");

                            System.out.println("Take off from: " + airportId + " " + name + " " + code);

                            String toAirportIdString = Long.toString(toAirportId);
                            String landCommand = ClientUI.AIRPORT_URL.replace("{id}", toAirportIdString);

                            String landResponse = getRequest(landCommand);
                            Object landData = JSONValue.parse(landResponse);
                            JSONObject landJsonObjectDecode = (JSONObject) landData;

                            long airportId2 = (long) landJsonObjectDecode.get("id");
                            String name2 = (String) landJsonObjectDecode.get("name");
                            String code2 = (String) landJsonObjectDecode.get("code");

                            System.out.println("Landing: " + airportId2 + " " + name2 + " " + code2);
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
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

                            System.out.println(airportId + " " + name + " " + code);

                            String toAirportIdString = Long.toString(toAirportId);
                            String tPACommand = ClientUI.AIRPORT_URL.replace("{id}", toAirportIdString);

                            String tPAResponse = getRequest(tPACommand);
                            Object tPAData = JSONValue.parse(tPAResponse);
                            JSONObject tPAJsonObjectDecode = (JSONObject) tPAData;

                            long airportId2 = (long) tPAJsonObjectDecode.get("id");
                            String name2 = (String) tPAJsonObjectDecode.get("name");
                            String code2 = (String) tPAJsonObjectDecode.get("code");

                            System.out.println(airportId2 + " " + name2 + " " + code2);
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
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

