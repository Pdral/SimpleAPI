package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class Controller {

    @GetMapping("/connector")
    public ResponseEntity<String> testConnector() throws IOException {
        StringBuilder data = new StringBuilder();
        try {
            File myObj = new File("file.json");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data.append(myReader.nextLine());
            }
            myReader.close();
            System.out.println("Size read from file: " + data.length());
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
//        ObjectMapper objectMapper = new ObjectMapper();
//        String variable = objectMapper.readValue(new File("src/main/resources/static/file.json"), String.class);
//        System.out.println(variable.length());
        return ok(data.toString());
    }
}
