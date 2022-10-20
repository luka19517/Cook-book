package dev.luka.cookbook.service;

import dev.luka.cookbook.domain.entity.Receipt;
import dev.luka.cookbook.domain.entity.ReceiptItem;
import dev.luka.cookbook.domain.repository.ReceiptItemRepository;
import dev.luka.cookbook.model.ReceiptItemModel;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class ReceiptItemServiceImpl implements ReceiptItemService {

    @Autowired
    private ReceiptItemRepository receiptItemRepository;


    @Override
    public List<ReceiptItemModel> getAll() {
        List<ReceiptItemModel> receiptItemModels = new ArrayList<>();

        List<ReceiptItem> receiptItems = (List<ReceiptItem>) receiptItemRepository.findAll();
        for (ReceiptItem item : receiptItems){
            receiptItemModels.add(toModel(item));
        }

        return receiptItemModels;
    }

    @Override
    public List<ReceiptItemModel> getAllItemsForReceipt(Receipt receipt){
        List<ReceiptItemModel> receiptItemModels = new ArrayList<>();

        List<ReceiptItem> receiptItems = receiptItemRepository.findByReceipt(receipt);
        for(ReceiptItem item: receiptItems){
            receiptItemModels.add(toModel(item));
        }

        return receiptItemModels;

    }

    @Override
    public ReceiptItemModel toModel(ReceiptItem item) {
        ReceiptItemModel receiptItemModel = new ReceiptItemModel();
        receiptItemModel.setId(item.getId());
        receiptItemModel.setName(item.getName());
        receiptItemModel.setQuantity(item.getQuantity());

        return receiptItemModel;
    }
}
