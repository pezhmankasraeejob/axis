package se.softhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import se.softhouse.domain.Recipe;
import se.softhouse.service.RecipeService;

@RestController
public class RecipeController
{
    @Autowired
    private RecipeService recipeService;

    @RequestMapping(value = "/recipe", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public List<Recipe> getAllRecipe()
    {
        return recipeService.getAll();
    }

    @RequestMapping(value = "/recipe/{recipe_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    public Recipe getById(@PathVariable("recipe_id") Integer recipeId)
    {
        return recipeService.getById(recipeId);
    }
}