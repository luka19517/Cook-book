package dev.luka.cookbook.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.luka.cookbook.model.ReceiptTypeModel;
import dev.luka.cookbook.requests.CompleteRequestModel;
import dev.luka.cookbook.service.ReceiptTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000/"})
@RestController
@RequestMapping("/receiptTypeService")
public class ReceiptTypeController {

    @Autowired
    private ReceiptTypeService service;

    @GetMapping("/getForId/{id}")
    public ResponseEntity<String> getForId(@PathVariable("id") String id) {
        ObjectMapper mapper = new ObjectMapper();
        ReceiptTypeModel receiptType = service.getForId(id);
        try {
            String receiptTypeJson = mapper.writeValueAsString(receiptType);
            return new ResponseEntity<>(receiptTypeJson, HttpStatus.OK);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<String> getAll() {
        ObjectMapper mapper = new ObjectMapper();
        List<ReceiptTypeModel> receiptTypeList = service.getAll();
        try {
            String receiptTypeListJson = mapper.writeValueAsString(receiptTypeList);
            return new ResponseEntity<>(receiptTypeListJson, HttpStatus.OK);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Error while converting to json");
        }
    }

    @PostMapping("/save")
    public ResponseEntity<String> insert(@RequestBody() String data) {
        ObjectMapper mapper = new ObjectMapper();
        ReceiptTypeModel insertedReceiptType;
        try {
            insertedReceiptType = service.save(mapper.readValue(data, ReceiptTypeModel.class));
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Error while parsing request body");
        }
        try {
            String insertedReceiptTypeJson = mapper.writeValueAsString(insertedReceiptType);
            return new ResponseEntity<>(insertedReceiptTypeJson, HttpStatus.OK);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Error while converting to json");
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody() String data) {
        ObjectMapper mapper = new ObjectMapper();
        Boolean isDeleted;
        try {
            service.delete(mapper.readValue(data, ReceiptTypeModel.class));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Error while parsing request body");
        }
    }

    @PostMapping("/completeReceiptType")
    public ResponseEntity<String> completeReceiptType(@RequestBody() String query) {
        ObjectMapper mapper = new ObjectMapper();
        CompleteRequestModel completeQuery;
        try {
            completeQuery = mapper.readValue(query, CompleteRequestModel.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        List<ReceiptTypeModel> receiptTypeList = service.completeReceiptType(completeQuery.getQuery());
        try {
            String receiptTypeListJson = mapper.writeValueAsString(receiptTypeList);
            return new ResponseEntity<>(receiptTypeListJson, HttpStatus.OK);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Error while converting to json");
        }
    }

}
