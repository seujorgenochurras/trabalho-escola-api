package io.github.seujorgenochurras.apiescolatrabalho.service;


import io.github.seujorgenochurras.apiescolatrabalho.domain.Programmer;
import io.github.seujorgenochurras.apiescolatrabalho.respository.ProgrammerRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgrammerService {

   @Autowired
   private ProgrammerRepository programmerRepository;

   @Transactional
   public void saveProgrammer(@Valid Programmer programmer) {
      programmerRepository.save(programmer);
   }

}