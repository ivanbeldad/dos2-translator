package com.rackian.dos2translator.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rackian.dos2translator.model.ApiCalls;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class CountReader {

    public ApiCalls getApiCalls() {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("src/main/resources/calls.json");
        ApiCalls apiCalls;
        try {
            apiCalls = mapper.readValue(file, ApiCalls.class);
            return apiCalls;
        } catch (Exception ex) {
            return null;
        }
    }

}
