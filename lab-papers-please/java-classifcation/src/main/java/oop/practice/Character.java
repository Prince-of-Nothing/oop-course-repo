package oop.practice;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class Character {
    @JsonProperty("id")
    private int id;
    @JsonDeserialize(using = BooleanStateDeserializer.class)
    private BooleanState isHumanoid= BooleanState.UNKNOWN;
    @JsonProperty("planet")
    private String planet="UNKNOWN";
    @JsonProperty("age")
    private int age;
    @JsonProperty("traits")
    private List<String> traits;

    // Constructor
    
    public Character(int id, boolean isHumanoid, String planet, int age, List<String> traits) {
        this.id = id;
        if(isHumanoid){
            this.isHumanoid = BooleanState.TRUE;
        } 
        else if (isHumanoid) {
            this.isHumanoid = BooleanState.FALSE;
        } 
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

    
    public void setIsHumanoid(BooleanState isHumanoid) {
        this.isHumanoid = isHumanoid;
    }

   public BooleanState getIsHumanoid() {
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
         return "\nIndividual" +
                " ID:" + id + "\n{" +
                "\nisHumanoid=" + isHumanoid +
                "\nplanet='" + planet + '\'' +
                "\nage=" + age +
                "\ntraits=" + (traits == null ? "UNKNOWN" : traits) +
                "\n}";}



public static class BooleanStateDeserializer extends JsonDeserializer<BooleanState> {
    @Override
    public BooleanState deserialize(JsonParser p, DeserializationContext context)
            throws IOException {

        if (p.currentToken().isBoolean()) {
            return p.getBooleanValue() ? BooleanState.TRUE : BooleanState.FALSE;
        }

        return BooleanState.UNKNOWN;
    }
}
    
}