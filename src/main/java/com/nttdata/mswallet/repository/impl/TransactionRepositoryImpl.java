package com.nttdata.mswallet.repository.impl;

import com.nttdata.mswallet.dao.entity.TransactionEntity;
import com.nttdata.mswallet.dao.repository.TransactionRepositoryReactive;
import com.nttdata.mswallet.repository.TransactionRepository;
import io.reactivex.rxjava3.core.Maybe;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * Implementation TransactionRepository.
 */
@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

  private final TransactionRepositoryReactive transactionRepository;

  public TransactionRepositoryImpl(TransactionRepositoryReactive transactionRepository) {
    this.transactionRepository = transactionRepository;
  }

  @Override
  public Maybe<TransactionEntity> saveTransaction(TransactionEntity transaction) {
    Mono<TransactionEntity> mono =  transactionRepository.save(transaction);
    return Maybe.fromPublisher(mono);
  }

}
