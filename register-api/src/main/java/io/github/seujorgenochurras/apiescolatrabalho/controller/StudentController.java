package io.github.seujorgenochurras.apiescolatrabalho.controller;

import io.github.seujorgenochurras.apiescolatrabalho.assembler.SimpleStudentAssembler;
import io.github.seujorgenochurras.apiescolatrabalho.domain.SimpleStudent;
import io.github.seujorgenochurras.apiescolatrabalho.dto.SimpleStudentDto;
import io.github.seujorgenochurras.apiescolatrabalho.service.SimpleStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

   @Autowired
   private SimpleStudentService simpleStudentService;

   @Autowired
   private SimpleStudentAssembler simpleStudentAssembler;

   @PostMapping("/register/student")
   @ResponseStatus(HttpStatus.CREATED)
   public ResponseEntity<SimpleStudent> saveStudent(@RequestBody(required = false) SimpleStudentDto studentDto){
      return ResponseEntity.ok(simpleStudentService.save(simpleStudentAssembler.assemble(studentDto)));
   }
}
