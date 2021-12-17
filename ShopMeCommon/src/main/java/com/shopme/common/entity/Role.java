package com.shopme.common.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "roles")
public class Role {


    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    @Column(length = 40,nullable = false,unique = true)
    private String name;
    @Column(length = 150,nullable = false)
    private String description;

    public Role(String name, String description) {
        super();
        this.name = name;
        this.description = description;
    }

    public Role(String name) {
        super();
        this.name = name;
    }

    public Role() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Id.equals(role.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }

    public Role(Integer id) {
        Id = id;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
