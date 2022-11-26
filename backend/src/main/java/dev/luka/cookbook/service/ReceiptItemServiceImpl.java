package dev.luka.cookbook.service;


import dev.luka.cookbook.domain.entity.Receipt;
import dev.luka.cookbook.domain.entity.ReceiptItem;
import dev.luka.cookbook.domain.repository.ReceiptItemRepository;
import dev.luka.cookbook.domain.repository.ReceiptRepository;
import dev.luka.cookbook.mapper.ReceiptItemMapper;
import dev.luka.cookbook.mapper.ReceiptMapper;
import dev.luka.cookbook.model.ReceiptItemModel;
import dev.luka.cookbook.model.ReceiptModel;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class ReceiptItemServiceImpl implements ReceiptItemService {

    @Autowired
    private ReceiptItemRepository receiptItemRepository;

    @Autowired
    private ReceiptRepository receiptRepository;


    @Override
    public ReceiptItemModel getForId(Long id) {
        return ReceiptItemMapper.INSTANCE.entityToModel(receiptItemRepository.getReferenceById(id));
    }

    @Override
    public List<ReceiptItemModel> getAll() {
        return ReceiptItemMapper.INSTANCE.entityToModel(receiptItemRepository.findAll());
    }

    @Override
    public List<ReceiptItemModel> getAllItemsForReceipt(ReceiptModel receiptModel) {
        Receipt receipt = ReceiptMapper.INSTANCE.modelToEntity(receiptModel);
        return ReceiptItemMapper.INSTANCE.entityToModel(receiptItemRepository.findByReceipt(receipt));

    }

    @Override
    public ReceiptItemModel insert(ReceiptItemModel receiptItemModel) {
        ReceiptItem receiptItem = ReceiptItemMapper.INSTANCE.modelToEntity(receiptItemModel);
        receiptItemRepository.save(receiptItem);
        return ReceiptItemMapper.INSTANCE.entityToModel(receiptItem);
    }

    @Override
    public ReceiptItemModel update(ReceiptItemModel receiptItemModel) {
        ReceiptItem receiptItem = ReceiptItemMapper.INSTANCE.modelToEntity(receiptItemModel);
        receiptItemRepository.save(receiptItem);
        return ReceiptItemMapper.INSTANCE.entityToModel(receiptItem);
    }

    @Override
    public void delete(ReceiptItemModel receiptItemModel) {
        receiptItemRepository.delete(ReceiptItemMapper.INSTANCE.modelToEntity(receiptItemModel));
    }


}
