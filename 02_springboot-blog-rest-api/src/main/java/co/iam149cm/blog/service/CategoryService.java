package co.iam149cm.blog.service;

import co.iam149cm.blog.entity.Category;
import co.iam149cm.blog.payload.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto addCategory(CategoryDto categoryDto);

    CategoryDto getCategory(long categoryId);

    List<CategoryDto> getAllCategories();

}
