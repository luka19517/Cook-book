package dev.luka.cookbook.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.luka.cookbook.model.ReceiptItemModel;
import dev.luka.cookbook.model.ReceiptModel;
import dev.luka.cookbook.service.ReceiptItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receiptItemService")
public class ReceiptItemController {

    @Autowired
    ReceiptItemService service;

    @GetMapping("/getForId/{id}")
    public ResponseEntity<String> getForId(@PathVariable("id") Long id) {
        ObjectMapper mapper = new ObjectMapper();
        ReceiptItemModel receiptItem = service.getForId(id);
        try {
            String receiptJson = mapper.writeValueAsString(receiptItem);
            return new ResponseEntity<>(receiptJson, HttpStatus.OK);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/getAllItemsForReceipt")
    public ResponseEntity<String> getAllItemsForReceipt(@RequestBody() String data) {
        ObjectMapper mapper = new ObjectMapper();
        List<ReceiptItemModel> receiptItems;
        try {
            receiptItems = service.getAllItemsForReceipt(mapper.readValue(data, ReceiptModel.class));
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Error while parsing request body");
        }
        try {
            String receiptItemsJson = mapper.writeValueAsString(receiptItems);
            return new ResponseEntity<>(receiptItemsJson, HttpStatus.OK);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Error while converting to json");
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<String> insert(@RequestBody() String data) {
        ObjectMapper mapper = new ObjectMapper();
        ReceiptItemModel insertedReceiptItem;
        try {
            insertedReceiptItem = service.insert(mapper.readValue(data, ReceiptItemModel.class));
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Error while parsing request body");
        }
        try {
            String insertedReceiptItemJson = mapper.writeValueAsString(insertedReceiptItem);
            return new ResponseEntity<>(insertedReceiptItemJson, HttpStatus.OK);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Error while converting to json");
        }
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody() String data) {
        ObjectMapper mapper = new ObjectMapper();
        ReceiptItemModel updatedReceiptItem;
        try {
            updatedReceiptItem = service.update(mapper.readValue(data, ReceiptItemModel.class));
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Error while parsing request body");
        }
        try {
            String updatedReceiptJson = mapper.writeValueAsString(updatedReceiptItem);
            return new ResponseEntity<>(updatedReceiptJson, HttpStatus.OK);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Error while converting to json");
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody() String data) {
        ObjectMapper mapper = new ObjectMapper();
        Boolean isDeleted;
        try {
            service.delete(mapper.readValue(data, ReceiptItemModel.class));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Error while parsing request body");
        }
    }

}
