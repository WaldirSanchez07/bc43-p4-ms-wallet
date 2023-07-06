package com.nttdata.mswallet.dao.repository;

import com.nttdata.mswallet.dao.entity.BalanceEntity;
import io.reactivex.rxjava3.core.Maybe;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Data access.
 */
public interface BalanceRepositoryReactive extends ReactiveMongoRepository<BalanceEntity, String> {

  Maybe<BalanceEntity> findFirstByAccountIdOrderByDateDesc(String accountId);

}
