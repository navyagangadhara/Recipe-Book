package com.example.RecipeBook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RecipeBook.entity.Recipe;
import com.example.RecipeBook.repository.RecipeRepository;

@RestController
	@RequestMapping("/api")
	public class RecipeController {

	    @Autowired
	    private RecipeRepository recipeRepository;

	    @GetMapping("/recipes/")
	    public List<Recipe> getAllRecipes() {
	        return recipeRepository.findAll();
	    }

	    @GetMapping("/recipes/{id}")
	    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id) {
	        Optional<Recipe> recipe = recipeRepository.findById(id);
	        return recipe.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	    }

	    @PostMapping("/recipes/")
	    public Recipe addRecipe(@RequestBody Recipe recipe) {
	        // Set author, createdAt, updatedAt, etc.
	        return recipeRepository.save(recipe);
	    }

	    @PutMapping("/recipes/{id}")
	    public ResponseEntity<Recipe> updateRecipe(@PathVariable Long id, @RequestBody Recipe updatedRecipe) {
	        java.util.Optional<Recipe> existingRecipe = recipeRepository.findById(id);
	        if (((java.util.Optional<Recipe>) existingRecipe).isPresent()) {
	            Recipe recipe = (Recipe) existingRecipe.get();
	            // Update recipe fields
	            return ResponseEntity.ok(recipeRepository.save(recipe));
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/recipes/{id}")
	    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
	        recipeRepository.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }
	}



