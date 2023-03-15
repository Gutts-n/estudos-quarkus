package com.github.farias.yuri.leonardo.ifood.restaurant;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.annotation.security.RolesAllowed;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "restaurant")
@Tag(name = "Restaurant")
public class Restaurant extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @CreationTimestamp
    public Date creationDate;

    @UpdateTimestamp
    public Date updateDate;

    @OneToOne(cascade = CascadeType.ALL)
    public Localization localization;

    public String owner;

    public String cnpj;

    public String name;

}
