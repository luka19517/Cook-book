package dev.luka.cookbook.model;

import lombok.Data;

@Data
public class ReceiptItemModel {

    private Long id;
    private String name;
    private Double quantity;
    private ReceiptModel receiptModel;

}
