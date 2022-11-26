package dev.luka.cookbook.mapper;

import dev.luka.cookbook.domain.entity.Receipt;
import dev.luka.cookbook.model.ReceiptModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReceiptMapper {
    ReceiptMapper INSTANCE = Mappers.getMapper(ReceiptMapper.class);

    ReceiptModel entityToModel(Receipt receipt);

    Receipt modelToEntity(ReceiptModel receiptModel);

    List<ReceiptModel> entityToModel(List<Receipt> receiptList);
}


