package com.nttdata.mswallet.controller;

import com.nttdata.mswallet.dto.request.AssociationRequest;
import com.nttdata.mswallet.dto.request.TransactionRequest;
import com.nttdata.mswallet.dto.request.WalletRequest;
import com.nttdata.mswallet.dto.response.ObjectResponse;
import com.nttdata.mswallet.service.TransactionService;
import com.nttdata.mswallet.service.WalletService;
import io.reactivex.rxjava3.core.Maybe;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API Rest Full.
 */
@AllArgsConstructor
@RestController
@RequestMapping("api/wallet")
public class WalletController {

  private final WalletService walletService;
  private final TransactionService transactionService;

  @PostMapping(value = "/create", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Maybe<ObjectResponse> saveWallet(@RequestBody WalletRequest request) {
    return walletService.saveWallet(request);
  }

  @PostMapping(value = "/associate", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Maybe<ObjectResponse> saveWalletAssociate(@RequestBody AssociationRequest request) {
    return walletService.associateDebitCard(request);
  }

  @PostMapping(value = "/transfer", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Maybe<ObjectResponse> saveTransfer(@RequestBody TransactionRequest request) {
    return transactionService.saveTransaction(request);
  }

}
