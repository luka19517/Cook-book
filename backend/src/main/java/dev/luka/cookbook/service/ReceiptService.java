package dev.luka.cookbook.service;

import dev.luka.cookbook.domain.entity.Receipt;
import dev.luka.cookbook.domain.repository.ReceiptItemRepository;
import dev.luka.cookbook.domain.repository.ReceiptRepository;
import dev.luka.cookbook.model.ReceiptModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ReceiptService {


    List<ReceiptModel> getAll();

    ReceiptModel insert(ReceiptModel receiptModel);

}
