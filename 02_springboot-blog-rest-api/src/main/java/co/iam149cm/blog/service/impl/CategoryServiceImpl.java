package co.iam149cm.blog.service.impl;

import co.iam149cm.blog.entity.Category;
import co.iam149cm.blog.payload.CategoryDto;
import co.iam149cm.blog.repository.CategoryRepository;
import co.iam149cm.blog.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);  // convert
        Category savedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory, CategoryDto.class);
    }
}
