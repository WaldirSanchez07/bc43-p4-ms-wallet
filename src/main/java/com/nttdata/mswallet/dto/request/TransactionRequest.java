package com.nttdata.mswallet.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Stores the transaction object of the request.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {

  private String phoneNumber; //number of the person sending money
  private String anotherPhoneNumber; //number of the person receiving the money
  private String description;
  private Double amount;

}
