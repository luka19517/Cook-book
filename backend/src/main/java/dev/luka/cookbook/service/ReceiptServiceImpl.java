package dev.luka.cookbook.service;

import dev.luka.cookbook.domain.entity.Receipt;
import dev.luka.cookbook.domain.entity.ReceiptItem;
import dev.luka.cookbook.domain.repository.ReceiptItemRepository;
import dev.luka.cookbook.domain.repository.ReceiptRepository;
import dev.luka.cookbook.model.ReceiptItemModel;
import dev.luka.cookbook.model.ReceiptModel;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class ReceiptServiceImpl implements  ReceiptService{

    @Autowired
    private ReceiptRepository receiptRepository;

    @Autowired
    private ReceiptItemService receiptItemService;

    @Override
    public List<ReceiptModel> getAll() {
        List<ReceiptModel> receiptModels=new ArrayList<>();

        List<Receipt> receiptList = (List<Receipt>) receiptRepository.findAll();
        for(Receipt receipt : receiptList){
            receiptModels.add(toModel(receipt));
        }

        return receiptModels;
    }

    @Override
    public ReceiptModel toModel(Receipt receipt) {
        ReceiptModel receiptModel = new ReceiptModel();
        receiptModel.setId(receipt.getId());
        receiptModel.setName(receipt.getName());
        receiptModel.setReceiptItems(receiptItemService.getAllItemsForReceipt(receipt));

        return receiptModel;
    }

}
