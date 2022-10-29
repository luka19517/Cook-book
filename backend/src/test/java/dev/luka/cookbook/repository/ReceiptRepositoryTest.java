package dev.luka.cookbook.repository;

import dev.luka.cookbook.config.TestConfig;
import dev.luka.cookbook.domain.entity.Receipt;
import dev.luka.cookbook.domain.repository.ReceiptRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.Optional;

@Configurable
@ContextConfiguration(classes = {TestConfig.class})
@Transactional
@ExtendWith(SpringExtension.class)
public class ReceiptRepositoryTest {

    @Autowired
    ReceiptRepository repo;


    @Test
    public void testSaveDelete() {
        Receipt receipt = new Receipt();
        receipt.setName("Baklava");
        repo.save(receipt);
        Assertions.assertEquals(1, repo.findAll().size());
        repo.flush();
        receipt = repo.findById(receipt.getId()).get();
        repo.delete(receipt);
        Assertions.assertEquals(0, repo.findAll().size());
    }
}
