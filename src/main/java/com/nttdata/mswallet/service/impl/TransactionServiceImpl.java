package com.nttdata.mswallet.service.impl;

import com.nttdata.mswallet.dto.request.TransactionRequest;
import com.nttdata.mswallet.dto.response.ObjectResponse;
import com.nttdata.mswallet.mapper.TransactionRequestMapper;
import com.nttdata.mswallet.repository.TransactionRepository;
import com.nttdata.mswallet.repository.WalletRepository;
import com.nttdata.mswallet.service.TransactionService;
import io.reactivex.rxjava3.core.Maybe;
import org.springframework.stereotype.Service;

/**
 * Implementation to TransactionService.
 */
@Service
public class TransactionServiceImpl implements TransactionService {

  private final WalletRepository walletRepository;
  private final TransactionRepository transactionRepository;

  public TransactionServiceImpl(
          WalletRepository walletRepository,
          TransactionRepository transactionRepository
  ) {
    this.walletRepository = walletRepository;
    this.transactionRepository = transactionRepository;
  }

  @Override
  public Maybe<ObjectResponse> saveTransaction(TransactionRequest request) {
    var msjSuccess = "Transferencia realizada con éxito!";

    return walletRepository
            .findWalletByPhoneNumber(request.getPhoneNumber())
            .filter(wallet -> wallet.getBalance() >= request.getAmount())
            .flatMap(wallet -> transactionRepository
                      .saveTransaction(TransactionRequestMapper.INSTANCE.map(request))
                      .map(obj -> new ObjectResponse(200, msjSuccess, obj))
            ).switchIfEmpty(Maybe.error(new Throwable("No hay saldo disponible!")))
            .onErrorResumeNext(error -> Maybe.error(new Throwable(error.getMessage())));
  }

}
