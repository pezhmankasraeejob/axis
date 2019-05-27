package se.softhouse.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ingredient")
public class Ingredient implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(nullable = false, name = "name")
    private String name;

    @OneToMany(mappedBy = "recipe")
    private Set<IngredientRecipe> ingredientRecipes = new HashSet<IngredientRecipe>();

    public Ingredient()
    {
    }

    public Ingredient(int id, String name)
    {
        super();
        this.id = id;
        this.name = name;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Set<IngredientRecipe> getIngredientRecipes()
    {
        return ingredientRecipes;
    }

    public void setIngredientRecipes(Set<IngredientRecipe> ingredientRecipes)
    {
        this.ingredientRecipes = ingredientRecipes;
    }

}
