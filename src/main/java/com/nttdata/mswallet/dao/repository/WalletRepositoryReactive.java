package com.nttdata.mswallet.dao.repository;

import com.nttdata.mswallet.dao.entity.WalletEntity;
import io.reactivex.rxjava3.core.Maybe;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Data access.
 */
public interface WalletRepositoryReactive extends ReactiveMongoRepository<WalletEntity, String> {

  @Query("{ '_id': ?0 }")
  Maybe<WalletEntity> customFindById(String id);

  @Query("{ 'phoneNumber': ?0 }")
  Maybe<WalletEntity> customFindByPhoneNumber(String phoneNumber);

}
