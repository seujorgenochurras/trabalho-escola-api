package io.github.seujorgenochurras.apiescolatrabalho.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Programmer extends User {

   @ManyToMany
   private List<ProgrammingLanguage> dominatedProgrammingLanguages = new ArrayList<>();

   @ManyToMany
   private List<HumanLanguage> dominatedHumanLanguages = new ArrayList<>();

   private int yearsOfCode;

   private int age;

   private String preferredVarsNomination;
   private String preferredClassesNomination;
   private String preferredFilesNomination;

   public List<ProgrammingLanguage> getDominatedProgrammingLanguages() {
      return dominatedProgrammingLanguages;
   }

   public Programmer setDominatedProgrammingLanguages(List<ProgrammingLanguage> dominatedProgrammingLanguages) {
      this.dominatedProgrammingLanguages = dominatedProgrammingLanguages;
      return this;
   }

   public List<HumanLanguage> getDominatedHumanLanguages() {
      return dominatedHumanLanguages;
   }

   public Programmer setDominatedHumanLanguages(List<HumanLanguage> dominatedHumanLanguages) {
      this.dominatedHumanLanguages = dominatedHumanLanguages;
      return this;
   }

   public int getYearsOfCode() {
      return yearsOfCode;
   }

   public Programmer setYearsOfCode(int yearsOfCode) {
      this.yearsOfCode = yearsOfCode;
      return this;
   }

   public int getAge() {
      return age;
   }

   public Programmer setAge(int age) {
      this.age = age;
      return this;
   }

   public String getPreferredVarsNomination() {
      return preferredVarsNomination;
   }

   public Programmer setPreferredVarsNomination(String preferredVarsNomination) {
      this.preferredVarsNomination = preferredVarsNomination;
      return this;
   }

   public String getPreferredClassesNomination() {
      return preferredClassesNomination;
   }

   public Programmer setPreferredClassesNomination(String preferredClassesNomination) {
      this.preferredClassesNomination = preferredClassesNomination;
      return this;
   }

   public String getPreferredFilesNomination() {
      return preferredFilesNomination;
   }

   public Programmer setPreferredFilesNomination(String preferredFilesNomination) {
      this.preferredFilesNomination = preferredFilesNomination;
      return this;
   }
}
