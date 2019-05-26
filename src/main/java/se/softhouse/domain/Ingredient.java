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
    private Set<IngredientRecipe> employerDeliveryAgent = new HashSet<IngredientRecipe>();

    public Ingredient(int id, String name)
    {
        super();
        this.id = id;
        this.name = name;
    }

}
