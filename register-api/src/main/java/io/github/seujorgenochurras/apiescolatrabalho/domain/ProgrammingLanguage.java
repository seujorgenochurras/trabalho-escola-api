package io.github.seujorgenochurras.apiescolatrabalho.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProgrammingLanguage {
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private String programmingLanguageId;

   private String programmingLanguageName;

   public String getProgrammingLanguageName() {
      return programmingLanguageName;
   }

   public ProgrammingLanguage setProgrammingLanguageName(String programmingLanguageName) {
      this.programmingLanguageName = programmingLanguageName;
      return this;
   }

   public String getProgrammingLanguageId() {
      return programmingLanguageId;
   }

   public ProgrammingLanguage setProgrammingLanguageId(String programmingLanguageId) {
      this.programmingLanguageId = programmingLanguageId;
      return this;
   }
}
