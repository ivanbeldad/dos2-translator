package com.rackian.dos2translator.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class JsonSaver implements Saver {

    @Override
    public void save(File file, Object object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("src/main/resources/calls.json"), object);
        } catch (Exception ex) {
        }
    }

}
