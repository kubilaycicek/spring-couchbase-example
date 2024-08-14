package com.kubilaycicek.customer_service.api.payload.model;

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
    @Field
    private String name;
    @Field
    private String surname;
    @Field
    private String email;
    @Field
    private String phone;
    @Field
    private String address;

    public Customer(String name, String surname, String email, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
}