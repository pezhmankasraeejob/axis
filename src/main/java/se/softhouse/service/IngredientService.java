package se.softhouse.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.softhouse.domain.Ingredient;

@Service
public class IngredientService
{
    @Autowired
    private IngredientRepository ingredientRepository;

    public List<Ingredient> getAll()
    {
        List<Ingredient> ingredientList = new ArrayList<Ingredient>();

        ingredientRepository.findAll().forEach(ingredientList::add);
        return ingredientList;
    }

    public Ingredient getById(Integer ingredientId)
    {
        Ingredient ingredient = ingredientRepository.findAll().stream().filter(t -> t.getId().equals(ingredientId))
                .findFirst().get();
        return ingredient;
    }

    public Ingredient add(Ingredient ingredient)
    {

        Ingredient savedIngrediet = ingredientRepository
                .save(new Ingredient(ingredient.getId(), ingredient.getName(), ingredient.getIngredientRecipes()));

        return savedIngrediet;
    }
}
