package com.example.spring5recipeapp.controllers;

import com.example.spring5recipeapp.domain.Category;
import com.example.spring5recipeapp.domain.UnitOfMeasure;
import com.example.spring5recipeapp.repositories.CategoryRepository;
import com.example.spring5recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
public class IndexController{

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"","/","index"})
    public String getIndexPage(){
        Optional<Category> category = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("Teaspoon");
        System.out.println("Category Id: "+ category.get().getId());
        System.out.println("Unit Of Measure Id: "+ unitOfMeasure.get().getId());
        return "index";
    }


}
