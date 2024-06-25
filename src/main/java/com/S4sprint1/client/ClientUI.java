package com.S4sprint1.client;

import java.io.IOException;

import static com.S4sprint1.client.ApiClient.getRequest;

public class ClientUI {
    final String BASE_URL = "http://localhost:8080";
    final String CITY_URL = BASE_URL + "/city" + "/{id}";
    final String CITIES_URL = BASE_URL + "/cities";
    final String AIRPORT_URL = BASE_URL + "/airport" + "/{id}";
    final String AIRPORTS_URL = BASE_URL + "/airports";
    final String FLIGHT_URL = BASE_URL + "/flight" + "/{id}";
    final String FLIGHTS_URL = BASE_URL + "/flights";
    final String PASSENGER_URL = BASE_URL + "/passenger" + "/{id}";
    final String PASSENGERS_URL = BASE_URL + "/passengers";

    String response;
    String command;

    public void setCommand(String command) {
        this.command = command;
    }

    public void run() {
        switch (command) {
            case "get_city-id" -> {
                try {
                    command = CITY_URL.replace("/city", command.split("-")[0]);
                    command = CITY_URL.replace("/{id}", command.split("-")[1]);
                    response = getRequest(command);
                } catch (IOException e) {
                    System.out.println("Invalid command. Please provide a valid command.");
                }
            }
            case "get_cities" -> {
                try {
                    response = getRequest(CITIES_URL);
                } catch (IOException e) {
                    System.out.println("Invalid command. Please provide a valid command.");
                }
            }
            case "get_airport" -> {
                try {
                    command = AIRPORT_URL.replace("/airport", command.split("-")[0]);
                    command = AIRPORT_URL.replace("{id}", command.split("-")[1]);
                    response = getRequest(command);
                } catch (IOException e) {
                    System.out.println("Invalid command. Please provide a valid command.");
                }
            }
            case "get_airports" -> {
                try {
                    response = getRequest(AIRPORTS_URL);
                } catch (IOException e) {
                    System.out.println("Invalid command. Please provide a valid command.");
                }
            }
            case "get_flight" -> {
                try {
                    command = FLIGHT_URL.replace("/flight", command.split("-")[0]);
                    command = FLIGHT_URL.replace("{id}", command.split("-")[1]);
                    response = getRequest(command);
                } catch (IOException e) {
                    System.out.println("Invalid command. Please provide a valid command.");
                }
            }
            case "get_flights" -> {
                try {
                    response = getRequest(FLIGHTS_URL);
                } catch (IOException e) {
                    System.out.println("Invalid command. Please provide a valid command.");
                }
            }
            case "get_passenger" -> {
                try {
                    command = PASSENGER_URL.replace("/passenger", command.split("-")[0]);
                    command = PASSENGER_URL.replace("{id}", command.split("-")[1]);
                    response = getRequest(command);
                } catch (IOException e) {
                    System.out.println("Invalid command. Please provide a valid command.");
                }
            }
            case "get_passengers" -> {
                try {
                    response = getRequest(PASSENGERS_URL);
                } catch (IOException e) {
                    System.out.println("Invalid command. Please provide a valid command.");
                }
            }
            default -> System.out.println("Invalid command. Please provide a valid command.");
        }
        System.out.println(response);
    }
}
