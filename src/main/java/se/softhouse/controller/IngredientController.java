package se.softhouse.controller;

import java.net.URI;
import java.util.ArrayList;
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

import se.softhouse.domain.Ingredient;
import se.softhouse.service.IngredientService;

@RestController
public class IngredientController
{
    @Autowired
    private IngredientService ingredientService;

    @RequestMapping(value = "/ingredient", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    public List<Ingredient> getSearchIngredient(@RequestParam(value = "q", required = false) String qValue)
    {
        List<Ingredient> ingredientList = new ArrayList<Ingredient>();

        if (qValue == null || qValue == "")
            ingredientList = ingredientService.getAll();
        else
        {
            ingredientList.add(ingredientService.getAll().stream().filter(t -> t.getName().equalsIgnoreCase(qValue))
                    .findFirst().get());
        }

        return ingredientList;
    }

    @RequestMapping(value = "/ingredient/{ingredient_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    public Ingredient getById(@PathVariable("ingredient_id") Integer ingredientId,
            @RequestParam(value = "p", required = false) String pValue)
    {
        System.out.println("P = " + pValue);
        return ingredientService.getById(ingredientId);
    }

    @RequestMapping(value = "/ingredient", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    public ResponseEntity<Object> addIngredient(@RequestBody Ingredient ingredient)
    {
        Ingredient addedIngredient = ingredientService.add(ingredient);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(addedIngredient.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @RequestMapping(value = "/ingredient/{ingredient_id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    public ResponseEntity<Object> updateIngredient(@PathVariable("ingredient_id") Integer ingredientId,
            @RequestBody Ingredient ingredient)
    {
        Ingredient updatedIngredient = ingredientService.update(ingredientId, ingredient);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(updatedIngredient.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
