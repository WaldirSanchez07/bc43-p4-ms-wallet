package com.nttdata.mswallet.repository;

import com.nttdata.mswallet.dao.entity.WalletEntity;
import io.reactivex.rxjava3.core.Maybe;

/**
 * Define the methods.
 */
public interface WalletRepository {

  Maybe<WalletEntity> saveWallet(WalletEntity transaction);

  Maybe<WalletEntity> findWalletById(String id);

  Maybe<WalletEntity> findWalletByPhoneNumber(String phoneNumber);

}
