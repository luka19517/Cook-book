package dev.luka.cookbook.service;

import dev.luka.cookbook.config.TestConfig;
import dev.luka.cookbook.model.ReceiptItemModel;
import dev.luka.cookbook.model.ReceiptModel;
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


    @Test
    public void testInsertUpdate() {
        Assertions.assertEquals(0, receiptService.getAll().size());

        ReceiptItemModel receiptItem1 = new ReceiptItemModel();
        receiptItem1.setName("Secer");
        receiptItem1.setQuantity(2.0);

        ReceiptItemModel receiptItem2 = new ReceiptItemModel();
        receiptItem2.setName("Voda");
        receiptItem2.setQuantity(3.0);

        List<ReceiptItemModel> receiptItemList = new ArrayList<>();
        receiptItemList.add(receiptItem1);
        receiptItemList.add(receiptItem2);


        ReceiptModel receipt = new ReceiptModel();
        receipt.setName("Baklava");
        receipt.setReceiptItems(receiptItemList);

        Long receiptId = receiptService.save(receipt).getId();

        Assertions.assertEquals(1, receiptService.getAll().size());

        ReceiptModel receiptLoaded = receiptService.getForId(receiptId);
        Assertions.assertEquals(2, receiptLoaded.getReceiptItems().size());

        Assertions.assertEquals("Secer", receiptLoaded.getReceiptItems().get(0).getName());
        Assertions.assertEquals("Voda", receiptLoaded.getReceiptItems().get(1).getName());

        receiptLoaded.setName("Baklava-Nova");

        ReceiptItemModel receiptItem3 = new ReceiptItemModel();
        receiptItem3.setName("Limun");
        receiptItem3.setQuantity(3.0);
        receiptLoaded.getReceiptItems().add(receiptItem3);

        receiptService.save(receiptLoaded);

        Assertions.assertEquals(1, receiptService.getAll().size());

        ReceiptModel receiptLoadedUpdated = receiptService.getForId(receiptId);
        Assertions.assertEquals("Baklava-Nova", receiptLoadedUpdated.getName());
        Assertions.assertEquals(3, receiptLoadedUpdated.getReceiptItems().size());

    }

    @Test
    public void testDelete() {
        Assertions.assertEquals(0, receiptService.getAll().size());

        ReceiptItemModel receiptItem1 = new ReceiptItemModel();
        receiptItem1.setName("Secer");
        receiptItem1.setQuantity(2.0);

        ReceiptItemModel receiptItem2 = new ReceiptItemModel();
        receiptItem2.setName("Voda");
        receiptItem2.setQuantity(3.0);

        List<ReceiptItemModel> receiptItemList = new ArrayList<>();
        receiptItemList.add(receiptItem1);
        receiptItemList.add(receiptItem2);


        ReceiptModel receipt = new ReceiptModel();
        receipt.setName("Baklava");
        receipt.setReceiptItems(receiptItemList);

        receipt = receiptService.save(receipt);

        Assertions.assertEquals(1, receiptService.getAll().size());



        ReceiptModel receipt2 = new ReceiptModel();
        receipt2.setName("Sendvic");
        receipt2.setReceiptItems(receiptItemList.subList(0, 1));

        receipt2 = receiptService.save(receipt2);

        Assertions.assertEquals(2, receiptService.getAll().size());

        receiptService.delete(receipt);
        Assertions.assertEquals(1, receiptService.getAll().size());

        receiptService.delete(receipt2);
        Assertions.assertEquals(0, receiptService.getAll().size());

    }

    @Test
    public void testOneToMany() {
        ReceiptModel receipt = new ReceiptModel();
        receipt.setName("Baklava");

        receipt.setReceiptItems(new ArrayList<>());

        ReceiptItemModel model = new ReceiptItemModel();
        model.setName("Secer");
        model.setQuantity(2.0);

        receipt.getReceiptItems().add(model);
        receipt = receiptService.save(receipt);

        Assertions.assertEquals(1, receiptService.getAll().size());

        ReceiptModel newReceipt = receiptService.getForId(receipt.getId());
        Assertions.assertEquals(1, newReceipt.getReceiptItems().size());
        Assertions.assertEquals("Secer", newReceipt.getReceiptItems().get(0).getName());


    }
}
