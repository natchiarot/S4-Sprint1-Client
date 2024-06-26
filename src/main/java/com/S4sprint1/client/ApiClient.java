package com.S4sprint1.client;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;

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
                        System.out.println("Response: " + response);
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
                        System.out.println("Response: " + response);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Please provide valid number of arguments (1).");
                }
                break;
            case "get_airportList":
                if (args.length == 2) {
                    String id = args[1];
                    String command = ClientUI.AIRPORT_URL.replace("{id}", id);
                    try {
                        String response = getRequest(command);
                        System.out.println("Response: " + response);
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
                        System.out.println("Response: " + response);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Please provide valid number of arguments (1).");
                }
                break;
            case "get_aircraft-{id}":
                if (args.length == 2) {
                    String id = args[1];
                    String command = ClientUI.AIRCRAFT_URL.replace("{id}", id);
                    try {
                        String response = getRequest(command);
                        System.out.println("Response: " + response);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Please provide a valid aircraft id.");
                }
                break;
            case "get_aircraftList":
                if (args.length == 1) {
                    String command = ClientUI.AIRCRAFTLIST_URL;
                    try {
                        String response = getRequest(command);
                        System.out.println("Response: " + response);
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
                        System.out.println("Response: " + response);
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
                        System.out.println("Response: " + response);
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
                        System.out.println("Response: " + response);
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
                        System.out.println("Response: " + response);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Please provide valid number of arguments (1).");
                }
                break;
            case "get_airports_city":
                if (args.length == 2) {
                    String id = args[1];
                    String command = ClientUI.CITY_URL.replace("{id}", id);
                    try {
                        String response = getRequest(command);
                        System.out.println("Response: " + response);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Please provide a valid airport id.");
                }
                break;
            case "get_aircraft_list_for_passenger":
                if (args.length == 2) {
                    String id = args[1];
                    String command = ClientUI.PASSENGERS_FLIGHTS_URL.replace("{id}", id);
                    try {
                        String response = getRequest(command);
                        System.out.println("Response: " + response);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Please provide a valid passenger id.");
                }
                break;
            case "get_passenger-{id}_airports_list":
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
}

