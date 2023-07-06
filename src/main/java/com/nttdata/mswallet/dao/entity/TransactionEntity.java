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
 * It represents the "transactions" collection.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "wallet_transactions")
public class TransactionEntity {

  @Id
  private String id;
  private String type; //Transferencia
  private String description;
  private String phoneNumber; //number of the person sending money
  private String anotherPhoneNumber; //number of the person receiving the money
  private Double amount;
  private LocalDateTime date;

}
