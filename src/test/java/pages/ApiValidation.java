package pages;

import io.restassured.response.Response;
import jdk.jfr.ContentType;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;


public class ApiValidation {
    protected Response postMethod(String name, String gender, String email, String status) {
        String requestBody = updateBody(name, gender, email, status);
        Response response = (Response) given().headers("Authorization", "Bearer 6f2e7993ee1b5fafcd799ef42bb59b9f2d8ed06d96411f1759b1bc1c98e3fcec",
                "Content Type", "application/json", "Accept", "*/*").body(requestBody).post();

        return response;
    }

    private String updateBody(String name, String gender, String email, String status) {
        String body = null;
        try {
            body = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") +
                    File.separator + "src/test/resources/data/userDetails.json")));
            body = body.replaceAll("replaceName", name);
            body = body.replaceAll("replaceEmail", email);
            body = body.replaceAll("replaceGender", gender);
            body = body.replaceAll("replacestatus", status);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return body;
    }
}
