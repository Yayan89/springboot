package com.datson.springcloudstream.baldung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcessorController {

    final ProcessorCustom processorCustom;

    @Autowired
    public ProcessorController(ProcessorCustom processorCustom) {
        this.processorCustom = processorCustom;
    }

    @GetMapping("/api/{number}")
    public void getANumber(@PathVariable int number) {
        processorCustom.routeValues(number);
    }
}
