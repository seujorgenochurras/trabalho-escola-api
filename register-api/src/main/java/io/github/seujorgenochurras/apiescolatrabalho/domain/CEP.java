package io.github.seujorgenochurras.apiescolatrabalho.domain;

import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;

@Entity
public class CEP {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @SerializedName("cep")
   private String cepCode;

   @SerializedName("city")
   private String cityName;

   @SerializedName("street")
   private String roadName;

   @SerializedName("state")
   private String stateName;

   private String neighborhood;

   public String getCepCode() {
      return cepCode;
   }

   public CEP setCepCode(String cepCode) {
      this.cepCode = cepCode;
      return this;
   }

   public String getNeighborhood() {
      return neighborhood;
   }

   public CEP setNeighborhood(String neighborhood) {
      this.neighborhood = neighborhood;
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
