package com.kubilaycicek.customer_service.api.payload.model;

import jakarta.validation.constraints.NotEmpty;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import java.util.UUID;

@Document
public class Customer {

    @Id
    private String id = UUID.randomUUID().toString();
    @NotEmpty(message = "Email must not be empty !")
    @Field
    private String name;
    @NotEmpty(message = "Email must not be empty !")
    @Field
    private String surname;
    @Field
    @NotEmpty(message = "Email must not be empty !")
    private String email;

    public Customer(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public @NotEmpty(message = "Email must not be empty !") String getName() {
        return name;
    }

    public void setName(@NotEmpty(message = "Email must not be empty !") String name) {
        this.name = name;
    }

    public @NotEmpty(message = "Email must not be empty !") String getSurname() {
        return surname;
    }

    public void setSurname(@NotEmpty(message = "Email must not be empty !") String surname) {
        this.surname = surname;
    }

    public @NotEmpty(message = "Email must not be empty !") String getEmail() {
        return email;
    }

    public void setEmail(@NotEmpty(message = "Email must not be empty !") String email) {
        this.email = email;
    }
}
