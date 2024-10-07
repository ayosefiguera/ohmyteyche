package com.ohmytyche.core.category.infrastructure.config;

import com.ohmytyche.core.category.application.services.CategoryService;
import com.ohmytyche.core.category.application.services.CategoryServiceImpl;
import com.ohmytyche.core.category.application.usecases.CreateCategoryUseCaseImpl;
import com.ohmytyche.core.category.application.usecases.DeleteCategoryUseCaseImpl;
import com.ohmytyche.core.category.application.usecases.RetrieveCategoryUseCaseImpl;
import com.ohmytyche.core.category.application.usecases.UpdateCategoryUseCaseImpl;
import com.ohmytyche.core.category.domain.models.Category;
import com.ohmytyche.core.category.domain.ports.out.CategoryRepositoryPort;
import com.ohmytyche.core.category.infrastructure.entities.CategoryEntity;
import com.ohmytyche.core.category.infrastructure.mapper.CategoryMapper;
import com.ohmytyche.core.category.infrastructure.repositories.JpaCategoryRepository;
import com.ohmytyche.core.category.infrastructure.repositories.JpaCategoryRepositoryAdapter;
import com.ohmytyche.core.generics.mapper.AbstractEntityMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for Category-related beans in the application.
 */
@Configuration
public class CategoryConfig {

    @Bean
    public CategoryService categoryService(final CategoryRepositoryPort categoryRepositoryPort) {
        return new CategoryServiceImpl(
                new CreateCategoryUseCaseImpl(categoryRepositoryPort),
                new RetrieveCategoryUseCaseImpl(categoryRepositoryPort),
                new UpdateCategoryUseCaseImpl(categoryRepositoryPort),
                new DeleteCategoryUseCaseImpl(categoryRepositoryPort)
        );
    }

    @Bean
    public CategoryRepositoryPort categoryRepositoryPort(final JpaCategoryRepository jpaCategoryRepository, final AbstractEntityMapper<CategoryEntity, Category> categoryMapper) {
        return new JpaCategoryRepositoryAdapter(jpaCategoryRepository, categoryMapper);
    }

    @Bean
    public AbstractEntityMapper<CategoryEntity, Category> categoryMapper() {
        return new CategoryMapper();
    }
}
