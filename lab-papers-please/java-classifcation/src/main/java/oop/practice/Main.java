package oop.practice;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
  public static void main(String[] args) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    File inputFile = new File("lab-papers-please\\java-classifcation\\src\\main\\resources\\test-input.json");
    JsonNode data = mapper.readTree(inputFile).get("data");

    Universe starWars = new Universe("starWars", new ArrayList<>());
    Universe hitchhikers = new Universe("hitchHiker", new ArrayList<>());
    Universe marvel = new Universe("marvel", new ArrayList<>());
    Universe rings = new Universe("rings", new ArrayList<>());

    Scanner scanner = new Scanner(System.in);

    for (JsonNode entry : data) {
      String entryAsString = entry.toString();
      System.out.println(entryAsString);
      String userInput = scanner.nextLine();
      switch (userInput) {
        case "1":
          starWars.individuals().add(entry);
          break;
        case "2":
          hitchhikers.individuals().add(entry);
          break;
        case "3":
          marvel.individuals().add(entry);
          break;
        case "4":
          rings.individuals().add(entry);
          break;
        default:
          System.out.println("Invalid input");
      }
    }

    scanner.close();
    mapper.writeValue(new File("lab-papers-please\\output\\starwars.json"), starWars);
    mapper.writeValue(new File("lab-papers-please\\output\\hitchhiker.json"), hitchhikers);
    mapper.writeValue(new File("lab-papers-please\\output\\rings.json"), rings);
    mapper.writeValue(new File("lab-papers-please\\output\\marvel.json"), marvel);




    Character character1 = new Character(0, false, "Kashyyyk", 253, Arrays.asList("HAIRY", "TALL"));





    // Creating another character with default constructor and using setters


    Character character2 = new Character();
    character2.setId(1);
    character2.setIsHumanoid(true);
    character2.setPlanet("Betelgeuse");
    character2.setAge(59);
    character2.setTraits(Arrays.asList("EXTRA_ARMS", "EXTRA_HEAD"));
    // Print character details
    System.out.println(character1);
    System.out.println(character2);
  }
  
}

record Universe(
    String name,
    List<JsonNode> individuals
) { }