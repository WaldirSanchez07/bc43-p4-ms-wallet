package com.nttdata.mswallet.service;

import com.nttdata.mswallet.dto.request.AssociationRequest;
import com.nttdata.mswallet.dto.request.WalletRequest;
import com.nttdata.mswallet.dto.response.ObjectResponse;
import io.reactivex.rxjava3.core.Maybe;

/**
 * define methods.
 */
public interface WalletService {

  Maybe<ObjectResponse> saveWallet(WalletRequest request);

  Maybe<ObjectResponse> associateDebitCard(AssociationRequest request);

}
