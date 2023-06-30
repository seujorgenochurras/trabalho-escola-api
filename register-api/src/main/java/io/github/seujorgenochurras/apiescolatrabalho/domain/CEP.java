package io.github.seujorgenochurras.apiescolatrabalho.domain;

import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;

@Entity
@Table(name = "cep")
public class CEP {

   @Id
   @SerializedName("cep")
   @Column(name = "id", nullable = false, length = 10)
   private String cepCode;

   @SerializedName("city")
   @Column(name = "city", nullable = false, length = 100)
   private String cityName;

   @SerializedName("street")
   @Column(name = "street_name", nullable = false, length = 100)
   private String roadName;

   @SerializedName("state")
   @Column(name = "state", nullable = false, length = 100)
   private String stateName;

   @Column(name = "neighborhood", nullable = false, length = 100)
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
