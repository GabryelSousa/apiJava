package com.gabryelapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Casas implements Serializable {
     String id;
     String name;
     String headOfHouse;
     List<String> values;
     List<String> colors;
     String school;
     String mascot;
     String houseGhost;
     String founder;


     public String getId() {
          return id;
     }

     public void setId(String id) {
          this.id = id;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getHeadOfHouse() {
          return headOfHouse;
     }

     public void setHeadOfHouse(String headOfHouse) {
          this.headOfHouse = headOfHouse;
     }

     public List<String> getValues() {
          return values;
     }

     public void setValues(List<String> values) {
          this.values = values;
     }

     public List<String> getColors() {
          return colors;
     }

     public void setColors(List<String> colors) {
          this.colors = colors;
     }

     public String getSchool() {
          return school;
     }

     public void setSchool(String school) {
          this.school = school;
     }

     public String getMascot() {
          return mascot;
     }

     public void setMascot(String mascot) {
          this.mascot = mascot;
     }

     public String getHouseGhost() {
          return houseGhost;
     }

     public void setHouseGhost(String houseGhost) {
          this.houseGhost = houseGhost;
     }

     public String getFounder() {
          return founder;
     }

     public void setFounder(String founder) {
          this.founder = founder;
     }

    /* @JsonIgnore
     private Map<String, Object> additionalProperties = new HashMap<>();

     @JsonAnyGetter
     public Map<String, Object> getAdditionalProperties() {
          return this.additionalProperties;
     }

     @JsonAnySetter
     public void setAdditionalProperty(String name, Object value) {
          this.additionalProperties.put(name, value);
     }

     */

}
