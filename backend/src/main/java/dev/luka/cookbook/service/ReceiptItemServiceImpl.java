package dev.luka.cookbook.service;

import dev.luka.cookbook.domain.entity.Receipt;
import dev.luka.cookbook.domain.entity.ReceiptItem;
import dev.luka.cookbook.domain.repository.ReceiptItemRepository;
import dev.luka.cookbook.mapper.ReceiptItemMapper;
import dev.luka.cookbook.mapper.ReceiptMapper;
import dev.luka.cookbook.model.ReceiptItemModel;
import dev.luka.cookbook.model.ReceiptModel;
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
            receiptItemModels.add(ReceiptItemMapper.INSTANCE.receiptItemToModel( item ));
        }

        return receiptItemModels;
    }

    @Override
    public List<ReceiptItemModel> getAllItemsForReceipt(Receipt receipt){
        List<ReceiptItemModel> receiptItemModels = new ArrayList<>();

        List<ReceiptItem> receiptItems = receiptItemRepository.findByReceipt(receipt);
        for(ReceiptItem item: receiptItems){
            receiptItemModels.add(ReceiptItemMapper.INSTANCE.receiptItemToModel( item ));
        }

        return receiptItemModels;

    }

    @Override
    public ReceiptItemModel insert(ReceiptItemModel receiptItemModel, ReceiptModel receiptModel) {
        ReceiptItem receiptItem = ReceiptItemMapper.INSTANCE.receiptItemModelToEntity(receiptItemModel);
        receiptItem.setReceipt(ReceiptMapper.INSTANCE.receiptModelToEntity(receiptModel));
        receiptItemRepository.save(receiptItem);

        return  ReceiptItemMapper.INSTANCE.receiptItemToModel(receiptItem);
    }

}
