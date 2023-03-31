package co.iam149cm.blog.service;

import co.iam149cm.blog.entity.Category;
import co.iam149cm.blog.payload.CategoryDto;

public interface CategoryService {
    CategoryDto addCategory(CategoryDto categoryDto);

}
