package io.github.seujorgenochurras.fakeregisterjavafx.domain;

import java.time.OffsetDateTime;

public class Student {
    private String name;
    private String cep;
    private String birthDate;

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public String getCep() {
        return cep;
    }

    public Student setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Student setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }
}
