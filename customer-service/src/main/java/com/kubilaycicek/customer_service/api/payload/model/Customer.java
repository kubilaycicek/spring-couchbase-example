package com.kubilaycicek.customer_service.api.payload.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import java.util.UUID;

@Document
@Getter
@Setter
@NoArgsConstructor
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

}