package io.github.seujorgenochurras.apiescolatrabalho.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "simple_students")
public class SimpleStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, name = "uuid", length = 36)
    private String uuid;

    @Column(nullable = false, name = "name", length = 100)
    private String name;

    @Column(nullable = false, name = "birth_date")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "cep_fk", nullable = false)
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
