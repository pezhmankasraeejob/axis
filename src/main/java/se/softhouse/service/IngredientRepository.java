package se.softhouse.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import se.softhouse.domain.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer>
{
    List<Ingredient> findAll();

    Ingredient save(Ingredient ingredient);
}
