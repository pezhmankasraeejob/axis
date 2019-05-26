package se.softhouse.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class IngredientListPrimaryKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Column(name = "recipe_id")
    private int recipeId;
    @Column(name = "ingredient_id")
    private int ingredientId;

    public IngredientListPrimaryKey()
    {

    }

    public int getRecipeId()
    {
        return recipeId;
    }

    public void setRecipeId(int recipeId)
    {
        this.recipeId = recipeId;
    }

    public int getIngredientId()
    {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId)
    {
        this.ingredientId = ingredientId;
    }

}
