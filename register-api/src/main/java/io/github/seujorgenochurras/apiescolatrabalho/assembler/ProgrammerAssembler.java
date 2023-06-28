package io.github.seujorgenochurras.apiescolatrabalho.assembler;

import io.github.seujorgenochurras.apiescolatrabalho.domain.Programmer;
import io.github.seujorgenochurras.apiescolatrabalho.domain.UserRole;
import io.github.seujorgenochurras.apiescolatrabalho.dto.ProgrammerDto;

import java.util.UUID;

public class ProgrammerAssembler {
   public static Programmer assemble(ProgrammerDto programmerDto){
      Programmer newProgrammer = new Programmer();
      newProgrammer.setAge(programmerDto.getAge())
              .setDominatedHumanLanguages(programmerDto.getDominatedHumanLanguages())
              .setDominatedProgrammingLanguages(programmerDto.getDominatedProgrammingLanguages())
              .setYearsOfCode(programmerDto.getYearsOfCode())
              .setBirthDate(programmerDto.getBirthDay())
              .setUserId(UUID.randomUUID().toString())
              .setUsername(programmerDto.getName())
              .setUserRole(UserRole.PROGRAMMER);
      return newProgrammer;
   }
}
