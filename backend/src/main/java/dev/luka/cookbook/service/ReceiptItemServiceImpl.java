package dev.luka.cookbook.service;


import dev.luka.cookbook.domain.entity.Receipt;
import dev.luka.cookbook.domain.entity.ReceiptItem;
import dev.luka.cookbook.domain.repository.ReceiptItemRepository;
import dev.luka.cookbook.domain.repository.ReceiptRepository;
import dev.luka.cookbook.mapper.ReceiptItemMapper;
import dev.luka.cookbook.model.ReceiptItemModel;
import dev.luka.cookbook.model.ReceiptModel;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class ReceiptItemServiceImpl implements ReceiptItemService {

    @Autowired
    private ReceiptItemRepository receiptItemRepository;

    @Autowired
    private ReceiptRepository receiptRepository;


    @Override
    public ReceiptItemModel getForId(Long id) {
        Optional<ReceiptItem> targetReceiptItemOptional = receiptItemRepository.findById(id);
        if (targetReceiptItemOptional.isPresent())
            return ReceiptItemMapper.INSTANCE.receiptItemToModel(targetReceiptItemOptional.get());
        else
            return null;
    }

    @Override
    public List<ReceiptItemModel> getAll() {
        List<ReceiptItemModel> receiptItemModels = new ArrayList<>();

        List<ReceiptItem> receiptItems = receiptItemRepository.findAll();
        for (ReceiptItem item : receiptItems) {
            receiptItemModels.add(ReceiptItemMapper.INSTANCE.receiptItemToModel(item));
        }

        return receiptItemModels;
    }

    @Override
    public List<ReceiptItemModel> getAllItemsForReceipt(ReceiptModel receiptModel) {
        List<ReceiptItemModel> receiptItemModels = new ArrayList<>();

        List<ReceiptItem> receiptItems = receiptItemRepository.findByReceipt(receiptRepository.findByName(receiptModel.getName()));
        for (ReceiptItem item : receiptItems) {
            receiptItemModels.add(ReceiptItemMapper.INSTANCE.receiptItemToModel(item));
        }

        return receiptItemModels;

    }

    @Override
    public ReceiptItemModel insert(ReceiptItemModel receiptItemModel) {
        ReceiptItem receiptItem = ReceiptItemMapper.INSTANCE.receiptItemModelToEntity(receiptItemModel);

        Receipt receipt = receiptRepository.findById(receiptItemModel.getReceiptModel().getId()).get();
        receiptItem.setReceipt(receipt);
        receiptItemRepository.save(receiptItem);

        return ReceiptItemMapper.INSTANCE.receiptItemToModel(receiptItem);
    }

    @Override
    public ReceiptItemModel update(ReceiptItemModel receiptItemModel) {
        ReceiptItem receiptItem = ReceiptItemMapper.INSTANCE.receiptItemModelToEntity(receiptItemModel);

        Receipt receipt = receiptRepository.findById(receiptItemModel.getReceiptModel().getId()).get();
        receiptItem.setReceipt(receipt);

        receiptItemRepository.save(receiptItem);

        return ReceiptItemMapper.INSTANCE.receiptItemToModel(receiptItem);
    }

    @Override
    public Boolean delete(ReceiptItemModel receiptItemModel) {
        Optional<ReceiptItem> optionalReceiptItem = receiptItemRepository.findById(receiptItemModel.getId());
        if (optionalReceiptItem.isPresent()) {
            ReceiptItem receiptItemToDelete = optionalReceiptItem.get();
            receiptItemRepository.delete(receiptItemToDelete);
            return true;
        }
        return false;
    }


}
