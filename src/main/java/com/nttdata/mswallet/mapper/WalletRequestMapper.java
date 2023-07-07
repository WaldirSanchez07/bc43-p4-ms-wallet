package com.nttdata.mswallet.mapper;

import com.nttdata.mswallet.dao.entity.WalletEntity;
import com.nttdata.mswallet.dto.request.WalletRequest;
import java.time.LocalDateTime;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper.
 */
@Mapper
public interface WalletRequestMapper {

  WalletRequestMapper INSTANCE = Mappers.getMapper(WalletRequestMapper.class);

  /**
   * WalletRequest to WalletEntity.

   * @param request type WalletRequest.
   * @return type WalletEntity.
   */
  default WalletEntity map(WalletRequest request) {
    return WalletEntity.builder()
            .id(UUID.randomUUID().toString())
            .docNumber(request.getDocNumber())
            .phoneNumber(request.getPhoneNumber())
            .phoneImei(request.getPhoneImei())
            .email(request.getEmail())
            .balance(5000.00)
            .createdAt(LocalDateTime.now())
            .build();
  }

}
