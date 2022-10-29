package dev.luka.cookbook.service;

import dev.luka.cookbook.domain.entity.Receipt;
import dev.luka.cookbook.model.ReceiptItemModel;
import dev.luka.cookbook.model.ReceiptModel;

import java.util.List;

public interface ReceiptItemService {

    List<ReceiptItemModel> getAll();

    List<ReceiptItemModel> getAllItemsForReceipt(ReceiptModel receiptModel);

    ReceiptItemModel insert(ReceiptItemModel receiptItemModel);

}
