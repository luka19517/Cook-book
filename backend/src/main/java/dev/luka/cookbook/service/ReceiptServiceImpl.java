package dev.luka.cookbook.service;

import dev.luka.cookbook.domain.entity.Receipt;
import dev.luka.cookbook.domain.repository.ReceiptRepository;
import dev.luka.cookbook.mapper.ReceiptMapper;
import dev.luka.cookbook.model.ReceiptModel;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class ReceiptServiceImpl implements ReceiptService {

    @Autowired
    private ReceiptRepository receiptRepository;


    @Override
    public List<ReceiptModel> getAll() {
        List<ReceiptModel> receiptModels = new ArrayList<>();

        List<Receipt> receiptList = receiptRepository.findAll();
        for (Receipt receipt : receiptList) {
            receiptModels.add(ReceiptMapper.INSTANCE.receiptToModel(receipt));
        }

        return receiptModels;
    }

    @Override
    public ReceiptModel insert(ReceiptModel receiptModel) {
        Receipt receipt = ReceiptMapper.INSTANCE.receiptModelToEntity(receiptModel);
        receiptRepository.save(receipt);

        return receiptModel;
    }

}
