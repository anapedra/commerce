package com.anapedra.commerce.services;

import com.anapedra.commerce.dtos.CategoryDTO;
import com.anapedra.commerce.entities.Category;
import com.anapedra.commerce.repositories.CategoryRepository;
import com.anapedra.commerce.services.exceptionservice.DataBaseException;
import com.anapedra.commerce.services.exceptionservice.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

     private final CategoryRepository categoryRepository;
     private final AuthService authService;
    public CategoryService(CategoryRepository categoryRepository, AuthService authService) {
        this.categoryRepository = categoryRepository;
        this.authService = authService;
    }
    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll(){
        List<Category> list=categoryRepository.findAll();
        return list.stream().map(CategoryDTO::new).collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id){
        Optional<Category> obj=categoryRepository.findById(id);
        Category entity=obj.orElseThrow(
                ()-> new ResourceNotFoundException("Id "+id+" not found"));
        return new CategoryDTO(entity);
    }
    @Transactional
    public CategoryDTO insert(CategoryDTO dto) {
        Category entity = new Category();
        entity.setMomentRegistration(Instant.now());
        copyDtoToEntity(dto, entity);
        entity = categoryRepository.save(entity);
        return new CategoryDTO(entity);
    }

    @Transactional
    public CategoryDTO update(Long id, CategoryDTO dto) {
        try {
            Category entity = categoryRepository.getOne(id);
            entity.setMomentUpdate(Instant.now());
            copyDtoToEntity(dto, entity);
            entity = categoryRepository.save(entity);
            return new CategoryDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public void delete(Long id) {
        try {
            categoryRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
    }

    private void copyDtoToEntity(CategoryDTO dto, Category entity) {
        entity.setDescription(dto.getDescription());


    }


}
