package io.github.seujorgenochurras.apiescolatrabalho.assembler;

import io.github.seujorgenochurras.apiescolatrabalho.domain.SimpleStudent;
import io.github.seujorgenochurras.apiescolatrabalho.dto.SimpleStudentDto;
import io.github.seujorgenochurras.apiescolatrabalho.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class SimpleStudentAssembler {

    @Autowired
    private CepService cepService;

    public SimpleStudent assemble(SimpleStudentDto simpleStudentDto){
        SimpleStudent student = new SimpleStudent();
        student.setUuid((UUID.randomUUID().toString()))
                .setName(simpleStudentDto.name)
                .setCep(cepService.fetchCep(simpleStudentDto.cep))
                .setBirthDate(LocalDate.parse(simpleStudentDto.birthDate));
        return student;
    }
}

