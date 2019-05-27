package se.softhouse.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    public Recipe getById(@PathVariable("recipe_id") Integer recipeId,
            @RequestParam(value = "p", required = false) String pValue)
    {
        System.out.println("P = " + pValue);
        return recipeService.getById(recipeId);
    }

    @RequestMapping(value = "/recipe", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    public ResponseEntity<Object> addRecipe(@RequestBody Recipe recipe)
    {
        Recipe addedRecipe = recipeService.add(recipe);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(addedRecipe.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}