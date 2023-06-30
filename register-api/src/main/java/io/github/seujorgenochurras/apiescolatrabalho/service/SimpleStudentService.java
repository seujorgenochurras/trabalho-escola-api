package io.github.seujorgenochurras.apiescolatrabalho.service;

import io.github.seujorgenochurras.apiescolatrabalho.domain.SimpleStudent;
import io.github.seujorgenochurras.apiescolatrabalho.respository.SimpleStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;

@Service
public class SimpleStudentService {
    @Autowired
    private SimpleStudentRepository simpleStudentRepository;

    @Transient
    public SimpleStudent save(SimpleStudent student) {
        return simpleStudentRepository.save(student);
    }
}
