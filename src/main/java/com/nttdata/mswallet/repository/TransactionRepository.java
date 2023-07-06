package com.nttdata.mswallet.repository;

import com.nttdata.mswallet.dao.entity.TransactionEntity;
import io.reactivex.rxjava3.core.Maybe;

/**
 * Define the methods.
 */
public interface TransactionRepository {

  Maybe<TransactionEntity> saveTransaction(TransactionEntity transaction);

}
