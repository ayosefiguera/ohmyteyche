package com.ohmytyche.core.user.application.services;

import com.ohmytyche.core.user.domain.ports.in.CreateUserCase;
import com.ohmytyche.core.user.domain.ports.in.DeleteUserUseCase;
import com.ohmytyche.core.user.domain.ports.in.RetrieveUserUseCase;
import com.ohmytyche.core.user.domain.ports.in.UpdateUserUserCase;

/**
 * This interface extends several use case interfaces, including user creation, retrieval, updating, and deletion.
 */
public interface UserService extends CreateUserCase, RetrieveUserUseCase, UpdateUserUserCase, DeleteUserUseCase {

}
