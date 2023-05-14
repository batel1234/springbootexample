package com.javatpoint.controller;

import com.javatpoint.model.Category;
import com.javatpoint.model.User;
import com.javatpoint.service.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/api/categroy")
public class CategoryController {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categorys")
    public List<Category> getAllCategory(){ // מציג את כול הקטגוריות
        return categoryRepository.findAll();
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Category> getCategory(@PathVariable Long id){
//        Optional<Category> c= categoryRepository.findById(id); // אם זה קיים תחזיר אם זה לא קיים קטגוריה לא נימצא
//        return c.map(category1 -> ResponseEntity.ok().body(category1))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
    @PostMapping
    public ResponseEntity<Category> creatCategory(@RequestBody Category c)  throws URISyntaxException { //הוספה של קטגוריה חדשה
        Category newCategory= categoryRepository.save(c);
        return ResponseEntity.created(new URI("/api/category/"+newCategory.getId())).body(newCategory);
    }
    @PutMapping("/{id}")
    // עדכון של קטגוריה
    public ResponseEntity<?> updateCategory(@PathVariable Long id ,@RequestBody Category c)throws URISyntaxException{
        if(id!=c.getId())
            return ResponseEntity.badRequest().build();
        Category updateCategory= categoryRepository.save(c);
        return ResponseEntity.created(new URI("/api/category/"+updateCategory.getId())).body(updateCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){// מחיקת קטגוריה
        categoryRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
