package dev.luka.cookbook.service;

import dev.luka.cookbook.domain.entity.Ingredient;
import dev.luka.cookbook.domain.entity.Receipt;
import dev.luka.cookbook.domain.repository.IngredientRepository;
import dev.luka.cookbook.domain.repository.ReceiptRepository;
import dev.luka.cookbook.mapper.IngredientMapper;
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
        receiptRepository.save(receipt);
        for (Ingredient ingredient : receipt.getIngredients()) {
            ingredient.setReceipt(receipt.getId());
            ingredientRepository.save(ingredient);
        }
        return ReceiptMapper.INSTANCE.entityToModel(receipt);
    }

    @Override
    public List<ReceiptModel> completeReceipt(String query) {
        return ReceiptMapper.INSTANCE.entityToModel(receiptRepository.completeReceipt(query));
    }

    @Override
    public void delete(ReceiptModel receiptModel) {
        List<Ingredient> ingredients = IngredientMapper.INSTANCE.modelToEntity(receiptModel.getIngredients());

        for (Ingredient ingredient : ingredients) {
            ingredientRepository.delete(ingredient);
        }
        receiptRepository.delete(ReceiptMapper.INSTANCE.modelToEntity(receiptModel));
    }

}
