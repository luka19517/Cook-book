package dev.luka.cookbook.service;

import dev.luka.cookbook.domain.entity.Receipt;
import dev.luka.cookbook.domain.entity.ReceiptItem;
import dev.luka.cookbook.domain.repository.ReceiptRepository;
import dev.luka.cookbook.mapper.ReceiptItemMapper;
import dev.luka.cookbook.mapper.ReceiptMapper;
import dev.luka.cookbook.model.ReceiptModel;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class ReceiptServiceImpl implements ReceiptService {

    @Autowired
    private ReceiptRepository receiptRepository;

    @Override
    public ReceiptModel getForId(Long id) {
        return ReceiptMapper.INSTANCE.entityToModel(receiptRepository.getReferenceById(id));
    }

    @Override
    public List<ReceiptModel> getAll() {
        return ReceiptMapper.INSTANCE.entityToModel(receiptRepository.findAll());
    }

    @Override
    public ReceiptModel save(ReceiptModel receiptModel) {
        Receipt receipt;

        if (receiptModel.getId() != null) {
            //poslat za update
            receipt = ReceiptMapper.INSTANCE.modelToEntity(receiptModel);

        } else {
            //poslat za insert
            receipt = new Receipt();
            receipt.setName(receiptModel.getName());
            receipt = receiptRepository.save(receipt);

        }
        List<ReceiptItem> receiptItems = ReceiptItemMapper.INSTANCE.modelToEntity(receiptModel.getReceiptItems());
        for (ReceiptItem item : receiptItems) {
            item.setReceipt(receipt.getId());
        }
        receipt.setReceiptItems(receiptItems);

        receiptRepository.save(receipt);
        return ReceiptMapper.INSTANCE.entityToModel(receipt);
    }

    @Override
    public void delete(ReceiptModel receiptModel) {
        receiptRepository.delete(ReceiptMapper.INSTANCE.modelToEntity(receiptModel));
    }

}
