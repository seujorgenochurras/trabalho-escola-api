package io.github.seujorgenochurras.apiescolatrabalho.controller;

import io.github.seujorgenochurras.apiescolatrabalho.dto.SimpleStudentDto;
import io.github.seujorgenochurras.apiescolatrabalho.dto.StudentDto;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
        public SimpleStudentDto getSmth(){
        return new SimpleStudentDto().setName("jhon").setCep("15081-100").setBirthDate("2023-01-01");
    }
}
