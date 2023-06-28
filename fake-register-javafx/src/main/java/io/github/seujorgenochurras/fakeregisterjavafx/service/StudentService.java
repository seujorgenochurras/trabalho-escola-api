package io.github.seujorgenochurras.fakeregisterjavafx.service;

import com.google.gson.Gson;
import io.github.seujorgenochurras.fakeregisterjavafx.domain.Student;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class StudentService {
    public static boolean postStudent(Student student)  {
        try {
            URL url = new URL("https://localhost:8080/register/student");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            Gson gson = new Gson();
            connection.getOutputStream()
                    .write(gson.toJson(student).getBytes(StandardCharsets.UTF_8));
            connection.getOutputStream().flush();
            connection.getOutputStream().close();


            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            connection.disconnect();
            return responseCode == 200;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
