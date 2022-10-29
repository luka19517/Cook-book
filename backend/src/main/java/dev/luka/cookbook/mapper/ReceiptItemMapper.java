package dev.luka.cookbook.mapper;

import dev.luka.cookbook.domain.entity.ReceiptItem;
import dev.luka.cookbook.model.ReceiptItemModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReceiptItemMapper {
    ReceiptItemMapper INSTANCE = Mappers.getMapper(ReceiptItemMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "receipt", target="receiptModel")
    ReceiptItemModel receiptItemToModel(ReceiptItem receiptItem);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "quantity", target = "quantity")
    ReceiptItem receiptItemModelToEntity(ReceiptItemModel receiptItemModel);
}



/*
@Mapper 1
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper( CarMapper.class ); 3

    @Mapping(source = "numberOfSeats", target = "seatCount")
    CarDto carToCarDto(Car car); 2
}
 */

