package dev.luka.cookbook.mapper;

import dev.luka.cookbook.domain.entity.ReceiptItem;
import dev.luka.cookbook.model.ReceiptItemModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReceiptItemMapper {
    ReceiptItemMapper INSTANCE = Mappers.getMapper(ReceiptItemMapper.class);

    ReceiptItemModel entityToModel(ReceiptItem receiptItem);

    ReceiptItem modelToEntity(ReceiptItemModel receiptItemModel);

    List<ReceiptItemModel> entityToModel(List<ReceiptItem> receiptItems);
}
