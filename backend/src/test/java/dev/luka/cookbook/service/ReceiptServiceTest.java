package dev.luka.cookbook.service;

import dev.luka.cookbook.config.TestConfig;
import dev.luka.cookbook.domain.repository.ReceiptTypeRepository;
import dev.luka.cookbook.mapper.ReceiptTypeMapper;
import dev.luka.cookbook.model.IngredientModel;
import dev.luka.cookbook.model.ReceiptModel;
import dev.luka.cookbook.model.ReceiptTypeModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Configurable
@ContextConfiguration(classes = {TestConfig.class})
@Transactional
@SpringBootTest
public class ReceiptServiceTest {

    @Autowired
    private ReceiptService receiptService;

    @Autowired
    private ReceiptTypeRepository receiptTypeRepository;


    @Test
    public void testInsertUpdate() {
        Assertions.assertEquals(0, receiptService.getAll().size());

        ReceiptTypeModel receiptType = new ReceiptTypeModel();
        receiptType.setId("K");
        receiptType.setName("Kuvano jelo");
        receiptTypeRepository.save(ReceiptTypeMapper.INSTANCE.modelToEntity(receiptType));


        IngredientModel ingredient1 = new IngredientModel();
        ingredient1.setName("Secer");
        ingredient1.setQuantity(2.0);
        ingredient1.setUnit("gr");

        IngredientModel ingredient2 = new IngredientModel();
        ingredient2.setName("Voda");
        ingredient2.setQuantity(3.0);
        ingredient1.setUnit("l");

        List<IngredientModel> ingredients = new ArrayList<>();
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);


        ReceiptModel receipt = new ReceiptModel();
        receipt.setName("Baklava");
        receipt.setIngredients(ingredients);
        receipt.setType(receiptType);
        receipt.setDescription("Description");

        Long receiptId = receiptService.save(receipt).getId();

        Assertions.assertEquals(1, receiptService.getAll().size());

        ReceiptModel receiptLoaded = receiptService.getForId(receiptId);
        Assertions.assertEquals(2, receiptLoaded.getIngredients().size());

        Assertions.assertEquals("Secer", receiptLoaded.getIngredients().get(0).getName());
        Assertions.assertEquals("Voda", receiptLoaded.getIngredients().get(1).getName());

        receiptLoaded.setName("Baklava-Nova");

        IngredientModel ingredient = new IngredientModel();
        ingredient.setName("Limun");
        ingredient.setQuantity(3.0);
        ingredient.setUnit("kom");
        receiptLoaded.getIngredients().add(ingredient);

        receiptService.save(receiptLoaded);

        Assertions.assertEquals(1, receiptService.getAll().size());

        ReceiptModel receiptLoadedUpdated = receiptService.getForId(receiptId);
        Assertions.assertEquals("Baklava-Nova", receiptLoadedUpdated.getName());
        Assertions.assertEquals(3, receiptLoadedUpdated.getIngredients().size());

    }

    @Test
    public void testDelete() {
        Assertions.assertEquals(0, receiptService.getAll().size());

        ReceiptTypeModel receiptType = new ReceiptTypeModel();
        receiptType.setId("dezert");
        receiptType.setName("dezert");
        receiptTypeRepository.save(ReceiptTypeMapper.INSTANCE.modelToEntity(receiptType));

        IngredientModel ingredient1 = new IngredientModel();
        ingredient1.setName("Secer");
        ingredient1.setQuantity(2.0);
        ingredient1.setUnit("gr");


        IngredientModel ingredient2 = new IngredientModel();
        ingredient2.setName("Voda");
        ingredient2.setQuantity(3.0);
        ingredient2.setUnit("l");

        List<IngredientModel> receiptItemList = new ArrayList<>();
        receiptItemList.add(ingredient1);
        receiptItemList.add(ingredient2);


        ReceiptModel receipt = new ReceiptModel();
        receipt.setName("Baklava");
        receipt.setIngredients(receiptItemList);
        receipt.setType(receiptType);
        receipt.setDescription("Description");

        receipt = receiptService.save(receipt);

        Assertions.assertEquals(1, receiptService.getAll().size());


        ReceiptModel receipt2 = new ReceiptModel();
        receipt2.setName("Sendvic");
        receipt2.setIngredients(receiptItemList.subList(0, 1));
        receipt2.setType(receiptType);
        receipt2.setDescription("description");

        receipt2 = receiptService.save(receipt2);

        Assertions.assertEquals(2, receiptService.getAll().size());

        receiptService.delete(receipt);
        Assertions.assertEquals(1, receiptService.getAll().size());

        receiptService.delete(receipt2);
        Assertions.assertEquals(0, receiptService.getAll().size());

    }

    @Test
    public void testOneToMany() {

        ReceiptTypeModel receiptType = new ReceiptTypeModel();
        receiptType.setId("dezert");
        receiptType.setName("dezert");
        receiptTypeRepository.save(ReceiptTypeMapper.INSTANCE.modelToEntity(receiptType));


        ReceiptModel receipt = new ReceiptModel();
        receipt.setName("Baklava");
        receipt.setDescription("description");
        receipt.setType(receiptType);
        receipt.setIngredients(new ArrayList<>());

        IngredientModel model = new IngredientModel();
        model.setName("Secer");
        model.setQuantity(2.0);
        model.setUnit("gr");

        receipt.getIngredients().add(model);
        receipt = receiptService.save(receipt);

        Assertions.assertEquals(1, receiptService.getAll().size());

        ReceiptModel newReceipt = receiptService.getForId(receipt.getId());
        Assertions.assertEquals(1, newReceipt.getIngredients().size());
        Assertions.assertEquals("Secer", newReceipt.getIngredients().get(0).getName());


    }
}
