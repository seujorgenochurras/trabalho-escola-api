package io.github.seujorgenochurras.apiescolatrabalho.dto;

public class SimpleStudentDto {
    public String name;
    public String birthDate;
    public String cep;

    public String getName() {
        return name;
    }

    public SimpleStudentDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public SimpleStudentDto setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String getCep() {
        return cep;
    }

    public SimpleStudentDto setCep(String cep) {
        this.cep = cep;
        return this;
    }
}
