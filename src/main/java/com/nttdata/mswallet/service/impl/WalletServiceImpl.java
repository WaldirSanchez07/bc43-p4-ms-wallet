package com.nttdata.mswallet.service.impl;

import com.nttdata.mswallet.dto.request.AssociationRequest;
import com.nttdata.mswallet.dto.request.WalletRequest;
import com.nttdata.mswallet.dto.response.ObjectResponse;
import com.nttdata.mswallet.mapper.WalletRequestMapper;
import com.nttdata.mswallet.repository.WalletRepository;
import com.nttdata.mswallet.service.WalletService;
import io.reactivex.rxjava3.core.Maybe;
import org.springframework.stereotype.Service;

/**
 * Implementation to WalletService.
 */
@Service
public class WalletServiceImpl implements WalletService {

  private final WalletRepository walletRepository;

  public WalletServiceImpl(WalletRepository walletRepository) {
    this.walletRepository = walletRepository;
  }

  @Override
  public Maybe<ObjectResponse> saveWallet(WalletRequest request) {
    System.out.println(request.getDocNumber());
    return walletRepository
            .saveWallet(WalletRequestMapper.INSTANCE.map(request))
            .map(obj -> new ObjectResponse(201, "Monedero creado!", obj));
  }

  @Override
  public Maybe<ObjectResponse> associateDebitCard(AssociationRequest request) {
    var msjSuccess = "Se asocio su tarjeta de débito con éxito!";

    return walletRepository
            .findWalletById(request.getWalletId())
            .flatMap(wallet -> {
              wallet.setDebitCardId(request.getDebitCardId());
              return walletRepository.saveWallet(wallet)
                      .map(obj -> new ObjectResponse(200, msjSuccess, obj));
            });
  }

}
