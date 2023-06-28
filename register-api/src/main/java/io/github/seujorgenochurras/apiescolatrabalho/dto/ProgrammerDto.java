package io.github.seujorgenochurras.apiescolatrabalho.dto;

import io.github.seujorgenochurras.apiescolatrabalho.domain.HumanLanguage;
import io.github.seujorgenochurras.apiescolatrabalho.domain.ProgrammingLanguage;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProgrammerDto {
   @NotNull
   private List<ProgrammingLanguage> dominatedProgrammingLanguages = new ArrayList<>();
   @NotNull
   private List<HumanLanguage> dominatedHumanLanguages = new ArrayList<>();
   @NotNull
   private int yearsOfCode;
   @NotNull
   @Range(min = 18, max = 70)
   private int age;

   private String name;

   @NotNull
   private OffsetDateTime birthDay;
   @NotNull

   private String preferredVarsNomination;
   @NotNull
   private String preferredClassesNomination;
   @NotNull
   private String preferredFilesNomination;

   public List<ProgrammingLanguage> getDominatedProgrammingLanguages() {
      return dominatedProgrammingLanguages;
   }

   public ProgrammerDto setDominatedProgrammingLanguages(List<ProgrammingLanguage> dominatedProgrammingLanguages) {
      this.dominatedProgrammingLanguages = dominatedProgrammingLanguages;
      return this;
   }

   public String getName() {
      return name;
   }

   public ProgrammerDto setName(String name) {
      this.name = name;
      return this;
   }

   public List<HumanLanguage> getDominatedHumanLanguages() {
      return dominatedHumanLanguages;
   }

   public ProgrammerDto setDominatedHumanLanguages(List<HumanLanguage> dominatedHumanLanguages) {
      this.dominatedHumanLanguages = dominatedHumanLanguages;
      return this;
   }

   public int getYearsOfCode() {
      return yearsOfCode;
   }

   public ProgrammerDto setYearsOfCode(int yearsOfCode) {
      this.yearsOfCode = yearsOfCode;
      return this;
   }

   public OffsetDateTime getBirthDay() {
      return birthDay;
   }

   public ProgrammerDto setBirthDay(OffsetDateTime birthDay) {
      this.birthDay = birthDay;
      return this;
   }

   public int getAge() {
      return age;
   }

   public ProgrammerDto setAge(int age) {
      this.age = age;
      return this;
   }

   public String getPreferredVarsNomination() {
      return preferredVarsNomination;
   }

   public ProgrammerDto setPreferredVarsNomination(String preferredVarsNomination) {
      this.preferredVarsNomination = preferredVarsNomination;
      return this;
   }

   public String getPreferredClassesNomination() {
      return preferredClassesNomination;
   }

   public ProgrammerDto setPreferredClassesNomination(String preferredClassesNomination) {
      this.preferredClassesNomination = preferredClassesNomination;
      return this;
   }

   public String getPreferredFilesNomination() {
      return preferredFilesNomination;
   }

   public ProgrammerDto setPreferredFilesNomination(String preferredFilesNomination) {
      this.preferredFilesNomination = preferredFilesNomination;
      return this;
   }
}
