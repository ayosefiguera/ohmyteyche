package com.ohmytyche.core.transaction.application.services;

import com.ohmytyche.core.transaction.domain.ports.in.CreateTransactionUseCase;
import com.ohmytyche.core.transaction.domain.ports.in.DeleteTransactionUseCase;
import com.ohmytyche.core.transaction.domain.ports.in.RetrieveTransactionUseCase;
import com.ohmytyche.core.transaction.domain.ports.in.UpdateTransactionUseCase;

/**
 * This interface extends several use case interfaces, including transaction creation, retrieval, updating, and deletion.
 */
public interface TransactionService extends CreateTransactionUseCase, RetrieveTransactionUseCase, UpdateTransactionUseCase, DeleteTransactionUseCase {

}
