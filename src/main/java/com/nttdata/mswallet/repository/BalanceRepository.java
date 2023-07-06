package com.nttdata.mswallet.repository;

import com.nttdata.mswallet.dao.entity.BalanceEntity;
import io.reactivex.rxjava3.core.Maybe;

/**
 * Define the methods.
 */
public interface BalanceRepository {

  Maybe<Double> findLastBalanceByAccountId(String accountId);

  Maybe<BalanceEntity> saveBalance(BalanceEntity balance);

}
