package com.ohmytyche.core.category.application.services;

import com.ohmytyche.core.category.domain.ports.in.CreateCategoryUseCase;
import com.ohmytyche.core.category.domain.ports.in.DeleteCategoryUseCase;
import com.ohmytyche.core.category.domain.ports.in.RetrieveCategoryUseCase;
import com.ohmytyche.core.category.domain.ports.in.UpdateCategoryUseCase;

/**
 * This interface extends several use case interfaces, including Category creation, retrieval, updating, and deletion.
 */
public interface CategoryService extends CreateCategoryUseCase, RetrieveCategoryUseCase, UpdateCategoryUseCase, DeleteCategoryUseCase {

}
