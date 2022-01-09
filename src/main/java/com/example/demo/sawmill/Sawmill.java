package com.example.demo.sawmill;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Sawmill {
    @Id
    @SequenceGenerator(
            name="sawmill_sequence",
            sequenceName = "sawmill_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy =  GenerationType.SEQUENCE,
            generator = "sawmill_sequence"

    )
    private Long id;
    private String name;
    private String city;
    private String country;

    @CreationTimestamp
    private LocalDate created_at;

    @UpdateTimestamp
    private LocalDate updated_at;

    public Sawmill() {
    }

    public Sawmill(Long id,
                   String name,
                   String city,
                   String country,
                   LocalDate created_at,
                   LocalDate updated_at) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.country = country;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Sawmill(String name, String city, String country, LocalDate created_at, LocalDate updated_at) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Sawmill(String name, String city, String country) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.created_at =LocalDate.now();
        this.updated_at=LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "Sawmill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}

