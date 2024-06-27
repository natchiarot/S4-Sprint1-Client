package com.S4sprint1.client;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
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

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class ClientUITest {
    @Mock
    private CloseableHttpClient httpClient;
    @Mock
    private CloseableHttpResponse httpResponse;
    @Mock
    private HttpEntity httpEntity;
    @Mock
    private StatusLine statusLine;

    private ApiClient apiCLient;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        apiCLient = new ApiClient();
    }

    @Test
    public void testGetRequest() throws IOException {
        String url = "http://localhost:8080/city/1";
        String expectedResponse = "{\"id\":1,\"name\":\"New York\",\"state\":\"North Carolina\",\"population\":516456,\"airports\":[{\"id\":10,\"name\":\"Sydney Kingsford Smith Airport\",\"code\":\"TGY\"}]}";
        when(httpClient.execute(any(HttpGet.class))).thenReturn(httpResponse);
        when(httpResponse.getEntity()).thenReturn(httpEntity);
        when(httpResponse.getStatusLine()).thenReturn(statusLine);
        when(statusLine.getStatusCode()).thenReturn(200);
        String response = getRequest(url);
        assertEquals(expectedResponse, response);
    }

    @Test
    public void testGetRequestIOException() throws IOException {
        String command = "http://localhost:8080/";
        String response = getRequest(command);
        String expectedResponse = "Not Found";

        Object data = JSONValue.parse(response);
        JSONObject jsonObjectDecode = (JSONObject) data;

        String error = (String)jsonObjectDecode.get("error");
        System.out.println("Error: " + error);

        when(httpClient.execute(any(HttpGet.class))).thenThrow(new IOException());
        assertEquals(expectedResponse, error);
    }

    @Test
    public void testRun() {
        apiCLient.command = "get airport";
        apiCLient.run();
    }

    @Test
    public void testRunGetCity() {
        clientUI.command = "get city";
        clientUI.run();
    }

    @Test
    public void testRunGetCities() {
        clientUI.command = "get cities";
        clientUI.run();
    }

    @Test
    public void testRunGetAirports() {
        clientUI.command = "get airports";
        clientUI.run();
    }
}
