package com.nttdata.mswallet.dao.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * It represents the "wallets" collection.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "wallets")
public class WalletEntity {

  @Id
  private String id;
  private String docNumber;
  private String phoneNumber;
  private String phoneImei;
  private String debitCardId;
  private String email;
  private Double balance;
  private LocalDateTime createdAt;

}
