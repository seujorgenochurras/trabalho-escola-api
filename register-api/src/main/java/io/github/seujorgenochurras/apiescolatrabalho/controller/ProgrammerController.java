package io.github.seujorgenochurras.apiescolatrabalho.controller;

import io.github.seujorgenochurras.apiescolatrabalho.assembler.ProgrammerAssembler;
import io.github.seujorgenochurras.apiescolatrabalho.dto.ProgrammerDto;
import io.github.seujorgenochurras.apiescolatrabalho.service.ProgrammerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "register/")
public class ProgrammerController {

   @Autowired
   private ProgrammerService programmerService;

   @PostMapping(name = "programmer")
   public void registerProgrammer(@Valid ProgrammerDto programmerDto){
      programmerService.save(ProgrammerAssembler.assemble(programmerDto));
   }

}
