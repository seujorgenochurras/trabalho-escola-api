package io.github.seujorgenochurras.apiescolatrabalho.service;

import io.github.seujorgenochurras.apiescolatrabalho.assembler.StudentAssembler;
import io.github.seujorgenochurras.apiescolatrabalho.dto.StudentDto;
import io.github.seujorgenochurras.apiescolatrabalho.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;

@Service
public class StudentService {

   @Autowired
   private StudentRepository studentRepository;


   @Transient
   public void saveStudent(StudentDto studentDto){
      studentRepository.save(StudentAssembler.assemble(studentDto));
   }

}
