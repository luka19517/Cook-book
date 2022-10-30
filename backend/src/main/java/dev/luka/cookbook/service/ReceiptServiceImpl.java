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
import java.util.Optional;

@Data
@Service
public class ReceiptServiceImpl implements ReceiptService {

    @Autowired
    private ReceiptRepository receiptRepository;


    @Override
    public ReceiptModel getForId(Long id) {
        Optional<Receipt> targetReceiptOptional = receiptRepository.findById(id);
        if (targetReceiptOptional.isPresent())
            return ReceiptMapper.INSTANCE.receiptToModel(targetReceiptOptional.get());
        else
            return null;
    }

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

        return ReceiptMapper.INSTANCE.receiptToModel(receipt);
    }

    @Override
    public ReceiptModel update(ReceiptModel receiptModel) {
        Receipt receipt = ReceiptMapper.INSTANCE.receiptModelToEntity(receiptModel);
        receiptRepository.save(receipt);

        return ReceiptMapper.INSTANCE.receiptToModel(receipt);
    }

    @Override
    public Boolean delete(ReceiptModel receiptModel) {

        Optional<Receipt> optionalReceipt = receiptRepository.findById(receiptModel.getId());
        if (optionalReceipt.isPresent()) {
            Receipt receiptToDelete = optionalReceipt.get();
            receiptRepository.delete(receiptToDelete);
            return true;
        }

        return false;
    }

}
