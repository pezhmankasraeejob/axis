package se.softhouse.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ingredient")
public class Ingredient implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(nullable = false, name = "name")
    private String name;

    @OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<IngredientRecipe> ingredientRecipes = new HashSet<IngredientRecipe>();

    public Ingredient()
    {
    }

    public Ingredient(Integer id, String name, Set<IngredientRecipe> ingredientRecipes)
    {
        super();
        this.id = id;
        this.name = name;
        this.ingredientRecipes.addAll(ingredientRecipes);
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
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
        this.ingredientRecipes.addAll(ingredientRecipes);
    }

    @Override
    public String toString()
    {
        return "Ingredient [id=" + id + ", name=" + name + ", ingredientRecipes=" + ingredientRecipes + "]";
    }

}
