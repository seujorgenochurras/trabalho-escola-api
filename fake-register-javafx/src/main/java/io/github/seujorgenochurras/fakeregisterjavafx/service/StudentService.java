package io.github.seujorgenochurras.fakeregisterjavafx.service;

import com.google.gson.Gson;
import io.github.seujorgenochurras.fakeregisterjavafx.domain.Student;

import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class StudentService {
    public static PostedStudent postStudent(Student student) {
        Gson gson = new Gson();
        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://127.0.0.1:8080/register/student"))
                    .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(student)))
                    .version(HttpClient.Version.HTTP_2)
                    .setHeader("Content-Type", "application/json")
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            return new PostedStudent(response.statusCode(), response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static class PostedStudent{
        private int statusCode;
        private String body;

        public PostedStudent(int statusCode, String body) {
            this.statusCode = statusCode;
            this.body = body;
        }

        public boolean isSuccessful(){
            return this.statusCode >= 200 && this.statusCode <300;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public String getBody() {
            return body;
        }
    }
}
