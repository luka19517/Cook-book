package dev.luka.cookbook;

import dev.luka.cookbook.domain.entity.Receipt;
import dev.luka.cookbook.domain.repository.ReceiptItemRepository;
import dev.luka.cookbook.domain.repository.ReceiptRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CookBookApplicationTests {

	@Autowired
	ReceiptRepository receiptRepo;

	@Autowired
	ReceiptItemRepository receiptItemRepo;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepos1(){
		System.out.println(((List<Receipt>)receiptRepo.findAll()).size());
	}

	@Test
	void testRepos2(){
		Receipt receipt = receiptRepo.findById((long)1).get();
		System.out.println(receiptItemRepo.findByReceipt(receipt).size());
	}


}
