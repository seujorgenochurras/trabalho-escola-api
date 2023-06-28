package io.github.seujorgenochurras.apiescolatrabalho.service;

import io.github.seujorgenochurras.apiescolatrabalho.assembler.StudentAssembler;
import io.github.seujorgenochurras.apiescolatrabalho.domain.SimpleStudent;
import io.github.seujorgenochurras.apiescolatrabalho.dto.SimpleStudentDto;
import io.github.seujorgenochurras.apiescolatrabalho.dto.StudentDto;
import io.github.seujorgenochurras.apiescolatrabalho.respository.SimpleStudentRepository;
import io.github.seujorgenochurras.apiescolatrabalho.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;

@Service
public class StudentService {

   @Autowired
   private StudentRepository studentRepository;

   @Autowired
   private SimpleStudentRepository simpleStudentRepository;


   @Transient
   public void saveStudent(StudentDto studentDto){
      //TODO
      //studentRepository.save(StudentAssembler.assemble(studentDto));
   }

   @Transient
   public SimpleStudent saveSimpleStudent(SimpleStudent simpleStudent){
      return simpleStudentRepository.save(simpleStudent);
   }
}
