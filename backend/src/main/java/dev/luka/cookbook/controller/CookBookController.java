package dev.luka.cookbook.controller;

import dev.luka.cookbook.domain.entity.ReceiptItem;
import dev.luka.cookbook.model.ReceiptItemModel;
import dev.luka.cookbook.model.ReceiptModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://192.168.1.123:3000")
public class CookBookController {

    @GetMapping("/home")
    public String hello() {
        return "Cook book";
    }

    @GetMapping("/getAllReceipts")
    public String getAllReceipts(){
        return "IMPLEMENT ME";
    }

    @GetMapping("/getAllReceiptItems")
    public String getAllReceiptItems(@RequestParam Long receiptId){
        return "IMPLEMENT ME";
    }

    @GetMapping("/addNewReceipt")
    public String addNewReceipt(@RequestParam ReceiptItemModel receiptItemModel){
        return "IMPLEMENT ME";
    }
    @GetMapping("/addReceiptItem")
    public String addReceiptItem(@RequestParam ReceiptItemModel receiptItemModel, @RequestParam Long receiptId){
        return "IMPLEMENT ME";
    }

    @GetMapping("/deleteReceipt")
    public String deleteReceipt(@RequestParam Long receiptId){
        return "IMPLEMENT ME";
    }

    @GetMapping("/deleteReceiptItem")
    public String deleteReceiptItem(@RequestParam Long receiptItemId){
        return "IMPLEMENT ME";
    }

    @GetMapping("/editReceipt")
    public String editReceipt(@RequestParam ReceiptModel newReceipt){
        return "IMPLEMENT ME";
    }
    @GetMapping("/editReceiptItem")
    public String editReceiptItem(@RequestParam ReceiptItemModel newReceiptItem){
        return "IMPLEMENT ME";
    }


}
