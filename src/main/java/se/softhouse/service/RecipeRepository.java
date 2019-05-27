package se.softhouse.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import se.softhouse.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Integer>
{
    List<Recipe> findAll();
}
