package com.ohmytyche.core.account.application.services;

import com.ohmytyche.core.account.domain.ports.in.CreateAccountUseCase;
import com.ohmytyche.core.account.domain.ports.in.DeleteAccountUseCase;
import com.ohmytyche.core.account.domain.ports.in.RetrieveAccountUseCase;
import com.ohmytyche.core.account.domain.ports.in.UpdateAccountUseCase;

/**
 * This interface extends several use case interfaces, including account creation, retrieval, updating, and deletion.
 */
public interface AccountService extends CreateAccountUseCase, RetrieveAccountUseCase, UpdateAccountUseCase, DeleteAccountUseCase {

}
