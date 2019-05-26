package se.softhouse.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "ingredient_recipe")
public class IngredientRecipe implements Serializable
{
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private IngredientListPrimaryKey ingredientListPrimaryKey;

    @ManyToOne
    @MapsId("recipeId") // This is the name of attr in EmployerDeliveryAgentPK class
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @ManyToOne
    @MapsId("ingredientId") // This is the name of attr in EmployerDeliveryAgentPK class
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @Column(name = "amount")
    private int amount;
}
