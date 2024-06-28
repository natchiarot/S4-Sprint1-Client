package com.S4sprint1.client;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ApiClientTest {
    @Mock
    private CloseableHttpClient httpClient;
    @Mock
    private CloseableHttpResponse httpResponse;
    @Mock
    private HttpEntity httpEntity;
    @Mock
    private StatusLine statusLine;

    @Mock
    private CloseableHttpClient client;

    @Mock
    private CloseableHttpResponse response;

    @Mock
    private HttpEntity entity;

    @Mock
    private ApiClient apiCLient;

    @Mock
    private ClientUI clientUI;

    @Mock
    private HttpGet httpGet;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        ApiClient apiCLient = new ApiClient();
    }

    @Test
    public void testGetRequest() throws IOException {
        String url = "http://localhost:8080/city/1";
        String expectedResponse = "{\"id\":1,\"name\":\"New York\",\"state\":\"North Carolina\",\"population\":516456,\"airports\":[{\"id\":10,\"name\":\"Sydney Kingsford Smith Airport\",\"code\":\"TGY\"}]}";
        when(httpClient.execute(any(HttpGet.class))).thenReturn(httpResponse);
        when(httpResponse.getEntity()).thenReturn(httpEntity);
        when(httpEntity.getContent()).thenReturn(new ByteArrayInputStream(expectedResponse.getBytes()));
        when(httpResponse.getStatusLine()).thenReturn(statusLine);
        when(statusLine.getStatusCode()).thenReturn(200);
        String response = ApiClient.getRequest(httpClient, url);
        assertEquals(expectedResponse, response);
    }

    @Test
    public void testGetRequestError() throws IOException {
        String url = "http://localhost:8080/city/1";
        when(httpClient.execute(any(HttpGet.class))).thenReturn(httpResponse);
        when(httpResponse.getEntity()).thenReturn(httpEntity);
        when(httpResponse.getStatusLine()).thenReturn(statusLine);
        when(statusLine.getStatusCode()).thenReturn(404);
        String response = ApiClient.getRequest(httpClient, url);
        assertNull(response);
    }

    @Test
    public void testGetRequestException() throws IOException {
        String url = "http://localhost:8080/1";
        when(httpClient.execute(any(HttpGet.class))).thenThrow(new IOException());
        String response = ApiClient.getRequest(httpClient, url);
        assertEquals("Error: null", response);
    }
}
