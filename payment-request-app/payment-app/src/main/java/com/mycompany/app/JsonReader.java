package com.mycompany.app;
 
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
public class JsonReader {
    public List<PaymentRequest> readFromJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("paymentRequests.json");
 
        // If the file doesn't exist, return an empty list
        if (!file.exists()) {
            return new ArrayList<>();
        }
 
        return mapper.readValue(file, new TypeReference<List<PaymentRequest>>() {});
    }
}