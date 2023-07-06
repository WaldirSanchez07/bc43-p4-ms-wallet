package com.nttdata.mswallet.mapper;

import com.nttdata.mswallet.dao.entity.TransactionEntity;
import com.nttdata.mswallet.dto.request.TransactionRequest;
import java.time.LocalDateTime;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper.
 */
@Mapper
public interface TransactionRequestMapper {

  TransactionRequestMapper INSTANCE = Mappers.getMapper(TransactionRequestMapper.class);

  /**
   * TransactionRequest to TransactionEntity.

   * @param request type TransactionRequest.
   * @return type TransactionEntity.
   */
  default TransactionEntity map(TransactionRequest request) {
    return TransactionEntity.builder()
            .id(UUID.randomUUID().toString())
            .type("Transferencia")
            .phoneNumber(request.getPhoneNumber())
            .anotherPhoneNumber(request.getAnotherPhoneNumber())
            .description(request.getDescription())
            .date(LocalDateTime.now())
            .build();
  }

}
