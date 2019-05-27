package se.softhouse.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class IngredientListPrimaryKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Column(name = "recipe_id")
    private Integer recipeId;
    @Column(name = "ingredient_id")
    private Integer ingredientId;

    public IngredientListPrimaryKey()
    {

    }

    public IngredientListPrimaryKey(Integer recipeId, Integer ingredientId)
    {
        this.recipeId = recipeId;
        this.ingredientId = ingredientId;
    }

    public Integer getRecipeId()
    {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId)
    {
        this.recipeId = recipeId;
    }

    public Integer getIngredientId()
    {
        return ingredientId;
    }

    public void setIngredientId(Integer ingredientId)
    {
        this.ingredientId = ingredientId;
    }

    @Override
    public String toString()
    {
        return "IngredientListPrimaryKey [recipeId=" + recipeId + ", ingredientId=" + ingredientId + "]";
    }

}
