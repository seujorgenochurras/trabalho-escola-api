package io.github.seujorgenochurras.apiescolatrabalho.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CEP {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private String cepCode;

   private String cityName;
   private String roadName;
   private String stateName;

   public String getCepCode() {
      return cepCode;
   }

   public CEP setCepCode(String cepCode) {
      this.cepCode = cepCode;
      return this;
   }

   public String getCityName() {
      return cityName;
   }

   public CEP setCityName(String cityName) {
      this.cityName = cityName;
      return this;
   }

   public String getRoadName() {
      return roadName;
   }

   public CEP setRoadName(String roadName) {
      this.roadName = roadName;
      return this;
   }

   public String getStateName() {
      return stateName;
   }

   public CEP setStateName(String stateName) {
      this.stateName = stateName;
      return this;
   }
}
