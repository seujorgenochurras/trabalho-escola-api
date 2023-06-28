package io.github.seujorgenochurras.apiescolatrabalho.assembler;

import io.github.seujorgenochurras.apiescolatrabalho.domain.CEP;
import io.github.seujorgenochurras.apiescolatrabalho.domain.Student;
import io.github.seujorgenochurras.apiescolatrabalho.domain.UserRole;
import io.github.seujorgenochurras.apiescolatrabalho.dto.StudentDto;
import io.github.seujorgenochurras.apiescolatrabalho.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class StudentAssembler {
   @Autowired
   private CepService cepService;


   public Student assemble(StudentDto studentDto){
      Student newStudent = new Student();
      newStudent.setStudentCep(cepService.fetchCep(studentDto.studentCep))
              .setUsername(studentDto.username)
              .setUserId(UUID.randomUUID().toString())
              .setUserRole(UserRole.STUDENT)
              .setBirthDate(studentDto.birthDate);
    //TODO
      return newStudent;
   }
}
