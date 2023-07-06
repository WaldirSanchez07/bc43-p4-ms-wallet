package com.nttdata.mswallet.service;

import com.nttdata.mswallet.dto.request.TransactionRequest;
import com.nttdata.mswallet.dto.response.ObjectResponse;
import io.reactivex.rxjava3.core.Maybe;

/**
 * define methods.
 */
public interface TransactionService {

  Maybe<ObjectResponse> saveTransaction(TransactionRequest request);

}
