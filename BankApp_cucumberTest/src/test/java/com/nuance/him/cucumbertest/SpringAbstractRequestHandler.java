package com.nuance.him.cucumbertest;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
public  class SpringAbstractRequestHandler {
    private static String baseURL="http://localhost:";
    private static String port="8081";
    static HttpURLConnection connection;

    static HttpURLConnection getConnection(final String method,final String url,JSONObject jsonObject) throws Exception {
        URL requestURL=new URL(baseURL+port+url);
        connection = (HttpURLConnection) requestURL.openConnection();
        connection.setRequestMethod(method);
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        if(method.equals("POST")) {
            OutputStream out = connection.getOutputStream();
            out.write(jsonObject.toString().getBytes());
        }
        return connection;
    }

    static String getResponse(HttpURLConnection connection) throws Exception{
        InputStream is = connection.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            response.append(line);
            response.append('\r');
        }
        rd.close();
        return response.toString();
    }


}
