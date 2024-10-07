package com.ohmytyche.core.category.infrastructure.controllers;

import com.ohmytyche.core.category.application.services.CategoryService;
import com.ohmytyche.core.category.domain.models.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(final CategoryService categoryService) {
        setCategoryService(categoryService);
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody final Category category) {
        final Category createdCategory = getCategoryService().createCategory(category);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable final Long categoryId) {
        return getCategoryService().getCategoryById(categoryId)
                .map(category -> new ResponseEntity<>(category, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        final List<Category> accountList = getCategoryService().getAllCategories();
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }

    @PutMapping("/Update/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable final Long id, @RequestBody final Category updateCategory) {
        return getCategoryService().updateCategory(updateCategory)
                .map(account -> new ResponseEntity<>(account, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable final Long id) {
        if (getCategoryService().deleteCategory(id)) {
            return new ResponseEntity<>(true, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    protected CategoryService getCategoryService() {
        return categoryService;
    }

    public void setCategoryService(final CategoryService categoryService) {
        this.categoryService = categoryService;
    }
}
