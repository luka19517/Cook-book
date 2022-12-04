package dev.luka.cookbook.service;

import dev.luka.cookbook.model.ReceiptModel;

import java.util.List;

public interface ReceiptService {

    ReceiptModel getForId(Long id);

    List<ReceiptModel> getAll();

    ReceiptModel save(ReceiptModel receiptModel);

    List<ReceiptModel> completeReceipt(String query);

    void delete(ReceiptModel receiptModel);

}
