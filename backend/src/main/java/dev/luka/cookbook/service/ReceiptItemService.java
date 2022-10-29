package dev.luka.cookbook.service;

import dev.luka.cookbook.domain.entity.Receipt;
import dev.luka.cookbook.domain.entity.ReceiptItem;
import dev.luka.cookbook.domain.repository.ReceiptItemRepository;
import dev.luka.cookbook.model.ReceiptItemModel;
import dev.luka.cookbook.model.ReceiptModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public interface ReceiptItemService {

    List<ReceiptItemModel> getAll();

    List<ReceiptItemModel> getAllItemsForReceipt(Receipt receipt);

    ReceiptItemModel insert(ReceiptItemModel receiptItemModel, ReceiptModel receiptModel);
}
