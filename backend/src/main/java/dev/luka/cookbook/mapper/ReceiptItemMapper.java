package dev.luka.cookbook.mapper;

import dev.luka.cookbook.domain.entity.ReceiptItem;
import dev.luka.cookbook.model.ReceiptItemModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReceiptItemMapper {
    ReceiptItemMapper INSTANCE = Mappers.getMapper(ReceiptItemMapper.class);

    ReceiptItemModel entityToModel(ReceiptItem receiptItem);

    @Mapping(target = "receipt", ignore = true)
    ReceiptItem modelToEntity(ReceiptItemModel receiptItemModel);

    List<ReceiptItemModel> entityToModel(List<ReceiptItem> receiptItems);

    @Mapping(target = "receipt", ignore = true)
    List<ReceiptItem> modelToEntity(List<ReceiptItemModel> receiptItems);
}
