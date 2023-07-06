package com.nttdata.mswallet.repository.impl;

import com.nttdata.mswallet.dao.entity.BalanceEntity;
import com.nttdata.mswallet.dao.repository.BalanceRepositoryReactive;
import com.nttdata.mswallet.repository.BalanceRepository;
import io.reactivex.rxjava3.core.Maybe;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * Implementation to BalanceRepository.
 */
@Repository
public class BalanceRepositoryImpl implements BalanceRepository {

  private final BalanceRepositoryReactive balanceRepository;

  public BalanceRepositoryImpl(BalanceRepositoryReactive balanceRepository) {
    this.balanceRepository = balanceRepository;
  }

  @Override
  public Maybe<Double> findLastBalanceByAccountId(String accountId) {
    return balanceRepository
            .findFirstByAccountIdOrderByDateDesc(accountId)
            .map(obj -> obj.getAmount())
            .switchIfEmpty(Maybe.just(0.0));
  }

  @Override
  public Maybe<BalanceEntity> saveBalance(BalanceEntity balance) {
    Mono<BalanceEntity> mono = balanceRepository.save(balance);
    return Maybe.fromPublisher(mono);
  }

}
