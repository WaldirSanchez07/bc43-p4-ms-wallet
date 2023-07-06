package com.nttdata.mswallet.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Stores the wallet object of the request.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WalletRequest {

  private String docNumber;
  private String phoneNumber;
  private String phoneImei;
  private String email;

}
