package io.github.seujorgenochurras.apiescolatrabalho.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HumanLanguage {
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private String humanLanguageId;

   private String languageName;

   public String getHumanLanguageId() {
      return humanLanguageId;
   }

   public HumanLanguage setHumanLanguageId(String humanLanguageId) {
      this.humanLanguageId = humanLanguageId;
      return this;
   }

   public String getLanguageName() {
      return languageName;
   }

   public HumanLanguage setLanguageName(String languageName) {
      this.languageName = languageName;
      return this;
   }
}
