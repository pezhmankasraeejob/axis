package se.softhouse.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.softhouse.domain.Recipe;

@Service
public class RecipeService
{
    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> getAll()
    {
        List<Recipe> recipeList = new ArrayList<Recipe>();

        recipeRepository.findAll().forEach(recipeList::add);
        return recipeList;
    }

    public Recipe getById(Integer recipeId)
    {
        Recipe recipe = recipeRepository.findAll().stream().filter(t -> t.getId().equals(recipeId)).findFirst().get();
        return recipe;
    }

    public Recipe add(Recipe recipe)
    {
        Recipe savedRecipe = recipeRepository
                .save(new Recipe(recipe.getId(), recipe.getName(), recipe.getPeople(), recipe.getIngredientRecipes()));

        return savedRecipe;
    }

    public Recipe update(Integer recipeId, Recipe recipe)
    {
        Optional<Recipe> recipeTemp = recipeRepository.findById(recipeId);

        Recipe updatedRecipe = null;
        if(recipeTemp.isPresent())
        {
            updatedRecipe = recipeRepository
                    .save(new Recipe(recipeId, recipe.getName(), recipe.getPeople(), recipe.getIngredientRecipes()));
        }
        return updatedRecipe;
    }
}
