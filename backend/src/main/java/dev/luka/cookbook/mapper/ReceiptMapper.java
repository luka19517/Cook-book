package dev.luka.cookbook.mapper;

import dev.luka.cookbook.domain.entity.Receipt;
import dev.luka.cookbook.model.ReceiptModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReceiptMapper {
    ReceiptMapper INSTANCE = Mappers.getMapper(ReceiptMapper.class);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    ReceiptModel receiptToModel(Receipt receipt);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    Receipt receiptModelToEntity(ReceiptModel receiptModel);
}


