package com.datyan.configclient.controller;

import com.datyan.configclient.model.Database;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/db")
@Profile("dev")
public class DBController {

    @Value("${database.url}")
    private String dbUrl;

    @GetMapping("/getFirstName")
    public ResponseEntity<Database> getFirstName() {
        Database database = Database.builder().url(dbUrl).build();
        return new ResponseEntity<>(database, HttpStatus.OK);
    }
}
