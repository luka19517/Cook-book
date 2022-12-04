package dev.luka.cookbook.service;

import dev.luka.cookbook.domain.entity.ReceiptType;
import dev.luka.cookbook.domain.repository.ReceiptTypeRepository;
import dev.luka.cookbook.mapper.ReceiptTypeMapper;
import dev.luka.cookbook.model.ReceiptTypeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiptTypeServiceImpl implements ReceiptTypeService {

    @Autowired
    ReceiptTypeRepository receiptTypeRepository;

    @Override
    public ReceiptTypeModel getForId(String id) {
        return ReceiptTypeMapper.INSTANCE.entityToModel(receiptTypeRepository.getReferenceById(id));
    }

    @Override
    public List<ReceiptTypeModel> getAll() {
        return ReceiptTypeMapper.INSTANCE.entityToModel(receiptTypeRepository.findAll());
    }

    @Override
    public ReceiptTypeModel save(ReceiptTypeModel receiptTypeModel) {
        ReceiptType type = receiptTypeRepository.save(ReceiptTypeMapper.INSTANCE.modelToEntity(receiptTypeModel));
        receiptTypeRepository.save(type);
        return ReceiptTypeMapper.INSTANCE.entityToModel(type);
    }

    @Override
    public List<ReceiptTypeModel> completeReceiptType(String query) {
        return ReceiptTypeMapper.INSTANCE.entityToModel(receiptTypeRepository.completeReceiptType(query));
    }

    @Override
    public void delete(ReceiptTypeModel receiptTypeModel) {
        receiptTypeRepository.delete(ReceiptTypeMapper.INSTANCE.modelToEntity(receiptTypeModel));
    }
}
