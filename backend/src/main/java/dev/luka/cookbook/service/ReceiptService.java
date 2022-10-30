package dev.luka.cookbook.service;

import dev.luka.cookbook.model.ReceiptModel;

import java.util.List;

public interface ReceiptService {

    ReceiptModel getForId(Long id);

    List<ReceiptModel> getAll();

    ReceiptModel insert(ReceiptModel receiptModel);

    ReceiptModel update(ReceiptModel receiptModel);

    Boolean delete(ReceiptModel receiptModel);

}
