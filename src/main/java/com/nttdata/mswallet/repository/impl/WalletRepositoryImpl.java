package com.nttdata.mswallet.repository.impl;

import com.nttdata.mswallet.dao.entity.WalletEntity;
import com.nttdata.mswallet.dao.repository.WalletRepositoryReactive;
import com.nttdata.mswallet.repository.WalletRepository;
import io.reactivex.rxjava3.core.Maybe;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * Implementation to WalletRepository.
 */
@Repository
public class WalletRepositoryImpl implements WalletRepository {

  private final WalletRepositoryReactive walletRepository;

  public WalletRepositoryImpl(WalletRepositoryReactive walletRepository) {
    this.walletRepository = walletRepository;
  }

  @Override
  public Maybe<WalletEntity> saveWallet(WalletEntity transaction) {
    Mono<WalletEntity> mono = walletRepository.save(transaction);
    return Maybe.fromPublisher(mono);
  }

  @Override
  public Maybe<WalletEntity> findWalletById(String id) {
    return walletRepository.customFindById(id);
  }

  @Override
  public Maybe<WalletEntity> findWalletByPhoneNumber(String phoneNumber) {
    return walletRepository.customFindById(phoneNumber);
  }

}
