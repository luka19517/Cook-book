package dev.luka.cookbook.mapper;

import dev.luka.cookbook.domain.entity.Receipt;
import dev.luka.cookbook.domain.entity.ReceiptItem;
import dev.luka.cookbook.model.ReceiptItemModel;
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



/*
@Mapper 1
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper( CarMapper.class ); 3

    @Mapping(source = "numberOfSeats", target = "seatCount")
    CarDto carToCarDto(Car car); 2
}
 */

