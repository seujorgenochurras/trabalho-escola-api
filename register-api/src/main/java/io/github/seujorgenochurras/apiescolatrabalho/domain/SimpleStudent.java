package io.github.seujorgenochurras.apiescolatrabalho.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class SimpleStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    private String name;
    private LocalDate birthDate;

    @ManyToOne
    private CEP cep;

    public String getName() {
        return name;
    }

    public SimpleStudent setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public SimpleStudent setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public CEP getCep() {
        return cep;
    }

    public SimpleStudent setCep(CEP cep) {
        this.cep = cep;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public SimpleStudent setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }
}
