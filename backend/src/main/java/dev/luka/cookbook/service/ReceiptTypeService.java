package dev.luka.cookbook.service;

import dev.luka.cookbook.model.ReceiptTypeModel;

import java.util.List;

public interface ReceiptTypeService {

    ReceiptTypeModel getForId(String id);

    List<ReceiptTypeModel> getAll();

    ReceiptTypeModel save(ReceiptTypeModel receiptTypeModel);


    void delete(ReceiptTypeModel receiptTypeModel);
}
