package dev.luka.cookbook.model;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class ReceiptModel {

    private Long id;
    private String name;
    private List<ReceiptItemModel> receiptItems;
}
