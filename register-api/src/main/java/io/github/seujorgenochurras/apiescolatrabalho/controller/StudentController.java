package io.github.seujorgenochurras.apiescolatrabalho.controller;

import io.github.seujorgenochurras.apiescolatrabalho.assembler.SimpleStudentAssembler;
import io.github.seujorgenochurras.apiescolatrabalho.domain.SimpleStudent;
import io.github.seujorgenochurras.apiescolatrabalho.domain.Student;
import io.github.seujorgenochurras.apiescolatrabalho.dto.SimpleStudentDto;
import io.github.seujorgenochurras.apiescolatrabalho.dto.StudentDto;
import io.github.seujorgenochurras.apiescolatrabalho.service.SimpleStudentService;
import io.github.seujorgenochurras.apiescolatrabalho.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

   @Autowired
   private StudentService studentService;
   @Autowired
   private SimpleStudentService simpleStudentService;

   @Autowired
   private SimpleStudentAssembler simpleStudentAssembler;

   @PostMapping("/student")
   @ResponseStatus(HttpStatus.CREATED)
   public ResponseEntity<SimpleStudent> saveStudent(@RequestBody SimpleStudentDto studentDto){
      System.out.println("meu piru");
      SimpleStudent student = simpleStudentAssembler.assemble(studentDto);
      return ResponseEntity.ok(studentService.saveSimpleStudent(student));
   }
   @GetMapping("hello")
   public boolean mtAss(){
      return true;
   }
}
