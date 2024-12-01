package com.mycompany.app;
 
import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
 
public class JsonWriter {
    public void writeToJson(List<PaymentRequest> paymentRequests) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("paymentRequests.json"), paymentRequests);
    }
}
 