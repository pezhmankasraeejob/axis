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
    @MapsId("id")
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @Column(name = "amount")
    private Integer amount;

    public IngredientRecipe()
    {
    }

    public IngredientListPrimaryKey getIngredientListPrimaryKey()
    {
        return ingredientListPrimaryKey;
    }

    public void setIngredientListPrimaryKey(IngredientListPrimaryKey ingredientListPrimaryKey)
    {
        this.ingredientListPrimaryKey = ingredientListPrimaryKey;
    }

    public Integer getAmount()
    {
        return amount;
    }

    public void setAmount(Integer amount)
    {
        this.amount = amount;
    }

    @Override
    public String toString()
    {
        return "IngredientRecipe [ingredientListPrimaryKey=" + ingredientListPrimaryKey + ", recipe=" + recipe
                + ", ingredient=" + ingredient + ", amount=" + amount + "]";
    }

}
