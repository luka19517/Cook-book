package dev.luka.cookbook.mapper;

import dev.luka.cookbook.domain.entity.ReceiptType;
import dev.luka.cookbook.model.ReceiptTypeModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReceiptTypeMapper {
    ReceiptTypeMapper INSTANCE = Mappers.getMapper(ReceiptTypeMapper.class);

    ReceiptTypeModel entityToModel(ReceiptType ingredient);

    ReceiptType modelToEntity(ReceiptTypeModel ingredientModel);
}
