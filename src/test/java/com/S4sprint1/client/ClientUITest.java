package com.S4sprint1.client;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.io.IOException;

import static com.S4sprint1.client.ApiClient.getRequest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ClientUITest {
    @Mock
    private CloseableHttpClient httpClient;
    @Mock
    private CloseableHttpResponse httpResponse;
    @Mock
    private HttpEntity httpEntity;
    @Mock
    private StatusLine statusLine;

    private ClientUI clientUI;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        clientUI = new ClientUI();
    }

    @Test
    public void testSetCommand() {
        clientUI.setCommand("get_city-1");
        assertEquals("get_city-1", clientUI.command);
    }

    @Test
    public void testSetCommandEmpty() {
        clientUI.setCommand("");
        assertEquals("", clientUI.command);
    }

    @Test
    public void testGetRequest() throws IOException {
        String url = "http://localhost:8080/";
        when(httpClient.execute(any(HttpGet.class))).thenReturn(httpResponse);
        when(httpResponse.getEntity()).thenReturn(httpEntity);
        when(httpEntity.getContent()).thenReturn(null);
        when(httpResponse.getStatusLine()).thenReturn(statusLine);
        when(statusLine.getStatusCode()).thenReturn(404);
        String response = getRequest(url).split(",")[1].trim();

        assertEquals("\"status\":404", response);
    }

    @Test
    public void testGetRequestIOException() throws IOException {
        String url = "http://localhost:8080/";
        when(httpClient.execute(any(HttpGet.class))).thenThrow(new IOException());
        String response = getRequest(url).split(",")[1].trim();

        assertEquals("\"status\":404", response);
    }

    @Test
    public void testRun() {
        clientUI.command = "get_city-1";
        clientUI.run();
        assertNull(clientUI.response);
    }

    @Test
    public void testRunGetCity() {
        clientUI.command = "get_city-1";
        clientUI.run();
    }

    @Test
    public void testRunGetCities() {
        clientUI.command = "get_cities";
        clientUI.run();
    }

    @Test
    public void testRunGetAirports() {
        clientUI.command = "get_airports";
        clientUI.run();
    }

    @Test
    public void testRunGetAirport() {
        clientUI.command = "get_airport-1";
        clientUI.run();
    }

    @Test
    public void testRunGetFlight() {
        clientUI.command = "get_flight-1";
        clientUI.run();
    }

    @Test
    public void testRunGetFlights() {
        clientUI.command = "get_flights";
        clientUI.run();
    }

    @Test
    public void testRunGetPassenger() {
        clientUI.command = "get_passenger-1";
        clientUI.run();
    }

    @Test
    public void testRunGetPassengers() {
        clientUI.command = "get_passengers";
        clientUI.run();
    }

    @Test
    public void testRunInvalidCommand() {
        clientUI.command = "invalid";
        clientUI.run();
    }
}
