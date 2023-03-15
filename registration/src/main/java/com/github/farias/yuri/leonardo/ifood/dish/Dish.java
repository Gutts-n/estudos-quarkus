package com.github.farias.yuri.leonardo.ifood.dish;

import com.github.farias.yuri.leonardo.ifood.restaurant.Restaurant;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "dish")
@Tag(name = "Dish")
public class Dish extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;

    public String description;

    @ManyToOne
    public Restaurant restaurant;

    public BigDecimal price;

}
