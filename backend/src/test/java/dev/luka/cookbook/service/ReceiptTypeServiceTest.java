package dev.luka.cookbook.service;

import dev.luka.cookbook.config.TestConfig;
import dev.luka.cookbook.model.ReceiptTypeModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import javax.transaction.Transactional;
import java.util.List;

@Configurable
@ContextConfiguration(classes = {TestConfig.class})
@Transactional
@SpringBootTest
public class ReceiptTypeServiceTest {

    @Autowired
    private ReceiptTypeService receiptTypeService;


    @Test
    public void testInsertUpdateDelete() {
        int initialSize = receiptTypeService.getAll().size();

        ReceiptTypeModel receiptTypeModel1 = new ReceiptTypeModel();
        receiptTypeModel1.setId("kuvano");
        receiptTypeModel1.setName("Kuvano");

        receiptTypeModel1 = receiptTypeService.save(receiptTypeModel1);
        Assertions.assertEquals("kuvano", receiptTypeModel1.getId());
        Assertions.assertEquals(initialSize + 1, receiptTypeService.getAll().size());

        List<ReceiptTypeModel> types = receiptTypeService.getAll();
        ReceiptTypeModel receiptTypeModel2 = receiptTypeService.getForId("kuvano");
        receiptTypeModel2.setName("Kuvano2");
        receiptTypeService.save(receiptTypeModel2);

        receiptTypeModel2 = receiptTypeService.getForId("kuvano");
        Assertions.assertEquals("Kuvano2", receiptTypeModel2.getName());

        receiptTypeService.delete(receiptTypeModel2);

        Assertions.assertEquals(initialSize, receiptTypeService.getAll().size());

    }

}
