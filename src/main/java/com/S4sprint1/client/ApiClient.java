package com.S4sprint1.client;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.util.Scanner;

public class ApiClient {
    public static void main(String[] args) {
        ClientUI clientUI = new ClientUI();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a command: ");
        String command = scanner.nextLine();
        clientUI.setCommand(command);
        clientUI.run();
    }

    public static String getRequest(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        return EntityUtils.toString(httpResponse.getEntity());
    }
}

