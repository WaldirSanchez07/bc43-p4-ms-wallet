package com.nttdata.mswallet.dao.repository;

import com.nttdata.mswallet.dao.entity.TransactionEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Data access.
 */
public interface TransactionRepositoryReactive
        extends ReactiveMongoRepository<TransactionEntity, String> {

}
