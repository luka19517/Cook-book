package dev.luka.cookbook.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.luka.cookbook.model.ReceiptModel;
import dev.luka.cookbook.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receiptService")
public class ReceiptController {

    @Autowired
    private ReceiptService service;

    @GetMapping("/getForId/{id}")
    public ResponseEntity<String> getForId(@PathVariable("id") Long id) {
        ObjectMapper mapper = new ObjectMapper();
        ReceiptModel receipt = service.getForId(id);
        try {
            String receiptJson = mapper.writeValueAsString(receipt);
            return new ResponseEntity<>(receiptJson, HttpStatus.OK);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<String> getAll() {
        ObjectMapper mapper = new ObjectMapper();
        List<ReceiptModel> receiptList = service.getAll();
        try {
            String receiptListJson = mapper.writeValueAsString(receiptList);
            return new ResponseEntity<>(receiptListJson, HttpStatus.OK);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Error while converting to json");
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<String> insert(@RequestBody(required = true) String data) {
        ObjectMapper mapper = new ObjectMapper();
        ReceiptModel insertedReceipt;
        try {
            insertedReceipt = service.insert(mapper.readValue(data, ReceiptModel.class));
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Error while parsing request body");
        }
        try {
            String insertedReceiptJson = mapper.writeValueAsString(insertedReceipt);
            return new ResponseEntity<>(insertedReceiptJson, HttpStatus.OK);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Error while converting to json");
        }
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody(required = true) String data) {
        ObjectMapper mapper = new ObjectMapper();
        ReceiptModel updatedReceipt;
        try {
            updatedReceipt = service.update(mapper.readValue(data, ReceiptModel.class));
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Error while parsing request body");
        }
        try {
            String updatedReceiptJson = mapper.writeValueAsString(updatedReceipt);
            return new ResponseEntity<>(updatedReceiptJson, HttpStatus.OK);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Error while converting to json");
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody(required = true) String data) {
        ObjectMapper mapper = new ObjectMapper();
        Boolean isDeleted;
        try {
            isDeleted = service.delete(mapper.readValue(data, ReceiptModel.class));
            return new ResponseEntity<>(isDeleted.toString(), HttpStatus.OK);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Error while parsing request body");
        }
    }

}
