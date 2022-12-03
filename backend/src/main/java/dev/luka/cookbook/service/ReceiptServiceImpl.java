package dev.luka.cookbook.service;

import dev.luka.cookbook.domain.entity.Ingredient;
import dev.luka.cookbook.domain.entity.Receipt;
import dev.luka.cookbook.domain.repository.IngredientRepository;
import dev.luka.cookbook.domain.repository.ReceiptRepository;
import dev.luka.cookbook.mapper.IngredientMapper;
import dev.luka.cookbook.mapper.ReceiptMapper;
import dev.luka.cookbook.model.IngredientModel;
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

    @Autowired
    private IngredientRepository ingredientRepository;

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
        Receipt receipt = ReceiptMapper.INSTANCE.modelToEntity(receiptModel);
        receipt = receiptRepository.save(receipt);
        for (IngredientModel ingredient : receiptModel.getIngredients()) {
            Ingredient ingredientEntity = IngredientMapper.INSTANCE.modelToEntity(ingredient);
            ingredientEntity.setReceipt(receipt.getId());
            ingredientRepository.save(ingredientEntity);
        }
        return ReceiptMapper.INSTANCE.entityToModel(receipt);
    }

    @Override
    public void delete(ReceiptModel receiptModel) {
        receiptRepository.delete(ReceiptMapper.INSTANCE.modelToEntity(receiptModel));
    }

}
