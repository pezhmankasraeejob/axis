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
@Table(name = "recipe")
public class Recipe implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "people")
    private Integer people;

    @OneToMany(mappedBy = "ingredient")
    private Set<IngredientRecipe> employerDeliveryAgent = new HashSet<IngredientRecipe>();

    public Recipe(Integer id, String name, Integer people)
    {
        super();
        this.id = id;
        this.name = name;
        this.people = people;
    }

}
