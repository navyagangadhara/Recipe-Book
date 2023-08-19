package com.example.RecipeBook.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
	public class Recipe {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    private String title;
	    private String description;
	    private int preparationTime;
	    private int cookingTime;
	    private int servings;
	    private String instructions;
	    
	    @ManyToOne
	    private User author;
	    
	    @ManyToMany
	    private List<Ingredient> ingredients;
	    
	    @ManyToMany
	    private List<Category> categories;
	    
	    @ManyToOne
	    private Cuisine cuisine;
	    
	    @OneToMany(mappedBy = "recipe")
	    private List<Review> reviews;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getPreparationTime() {
			return preparationTime;
		}

		public void setPreparationTime(int preparationTime) {
			this.preparationTime = preparationTime;
		}

		public int getCookingTime() {
			return cookingTime;
		}

		public void setCookingTime(int cookingTime) {
			this.cookingTime = cookingTime;
		}

		public int getServings() {
			return servings;
		}

		public void setServings(int servings) {
			this.servings = servings;
		}

		public String getInstructions() {
			return instructions;
		}

		public void setInstructions(String instructions) {
			this.instructions = instructions;
		}

		public User getAuthor() {
			return author;
		}

		public void setAuthor(User author) {
			this.author = author;
		}

		public List<Ingredient> getIngredients() {
			return ingredients;
		}

		public void setIngredients(List<Ingredient> ingredients) {
			this.ingredients = ingredients;
		}

		public List<Category> getCategories() {
			return categories;
		}

		public void setCategories(List<Category> categories) {
			this.categories = categories;
		}

		public Cuisine getCuisine() {
			return cuisine;
		}

		public void setCuisine(Cuisine cuisine) {
			this.cuisine = cuisine;
		}

		public List<Review> getReviews() {
			return reviews;
		}

		public void setReviews(List<Review> reviews) {
			this.reviews = reviews;
		}

		@Override
		public String toString() {
			return "Recipe [id=" + id + ", title=" + title + ", description=" + description + ", preparationTime="
					+ preparationTime + ", cookingTime=" + cookingTime + ", servings=" + servings + ", instructions="
					+ instructions + ", author=" + author + ", ingredients=" + ingredients + ", categories="
					+ categories + ", cuisine=" + cuisine + ", reviews=" + reviews + "]";
		}
	    
	    // Other fields, getters, setters
	    
	}



