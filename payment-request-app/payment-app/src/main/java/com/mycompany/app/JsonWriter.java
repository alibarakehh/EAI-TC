package com.mycompany.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonWriter {
    public void writeToJson(PaymentRequest paymentRequest) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("paymentRequest.json"), paymentRequest);
    }
}
