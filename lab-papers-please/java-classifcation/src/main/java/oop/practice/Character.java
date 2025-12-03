package oop.practice;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Character {
    @JsonProperty("id")
    private int id;
    @JsonProperty("isHumanoid")
    private boolean isHumanoid;
    @JsonProperty("planet")
    private String planet;
    @JsonProperty("age")
    private int age;
    @JsonProperty("traits")
    private List<String> traits;

    // Constructor
    public Character(int id, boolean isHumanoid, String planet, int age, List<String> traits) {
        this.id = id;
        this.isHumanoid = isHumanoid;
        this.planet = planet;
        this.age = age;
        this.traits = traits;
    }

    // Default Constructor
    public Character() {}

    // Getters and Setters
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    
    public void setIsHumanoid(boolean isHumanoid) {
        this.isHumanoid = isHumanoid;
    }

    public boolean getIsHumanoid() {
        return isHumanoid;
    }


    public void setPlanet(String planet) {
        this.planet = planet;
    } 

    public String getPlanet() {
        return planet;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

      public void setTraits(List<String> traits) {
        this.traits = traits;
    }

    public List<String> getTraits() {
        return traits;
    }

    // toString method for displaying character details
    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", isHumanoid=" + isHumanoid +
                ", planet='" + planet + '\'' +
                ", age=" + age +
                ", traits=" + traits +
                '}';
    }
}