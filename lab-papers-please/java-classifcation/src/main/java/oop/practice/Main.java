package oop.practice;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import oop.practice.Main.Universe;

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

  /*Manual maybe later  for (JsonNode entry : data) {
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
    }*/

   
    List<Character> individualsList = mapper.readValue(data.toString(), new TypeReference<List<Character>>() {});
  for (Character individuals : individualsList) {

      JsonNode entry = mapper.valueToTree(individuals);
      switch (Classification.getClassification(individuals)) {
        case 1:
        starWars.individuals().add(entry);
        break;
        case 2:
        hitchhikers.individuals().add(entry);
        break;
        case 3:
        marvel.individuals().add(entry);
        break;
        case 4:
        rings.individuals().add(entry);
        break;
        default:
          System.out.println("Something went wrong for id: " + individuals.getId());      }
    }

 mapper.writeValue(new File("./lab-papers-please/output/starwars.json"), starWars);
    mapper.writeValue(new File("./lab-papers-please/output/hitchhiker.json"), hitchhikers);
    mapper.writeValue(new File("./lab-papers-please/output/rings.json"), rings);
    mapper.writeValue(new File("./lab-papers-please/output/marvel.json"), marvel);

    System.out.println("\n");
    showStarWars();

    System.out.println("\n");
    showHitchhiker();

    System.out.println("\n");
    showMarvel();

    System.out.println("\n");
    showRings();
  }



record Universe(
    String name,
    List<JsonNode> individuals
) { }
public static void showStarWars() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File inputFile = new File("lab-papers-please\\output\\starwars.json");
        JsonNode data = mapper.readTree(inputFile).get("individuals");
        System.out.println("--------- Star Wars ---------");
        for(JsonNode entry : data){

            PrettyPrint.printEntry(entry);

        }
        System.out.println("-----------------------------");
    }
    public static void showHitchhiker() throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        File inputFile = new File("lab-papers-please\\output\\hitchhiker.json");
        JsonNode data = mapper.readTree(inputFile).get("individuals");
        System.out.println("--------- Hitchhiker ---------");
        for(JsonNode entry : data){

            PrettyPrint.printEntry(entry);

        }
        System.out.println("------------------------------");
    }
    public static void showMarvel() throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        File inputFile = new File("lab-papers-please\\output\\marvel.json");
        JsonNode data = mapper.readTree(inputFile).get("individuals");
        System.out.println("----------- Marvel -----------");
        for(JsonNode entry : data){

            PrettyPrint.printEntry(entry);

        }
        System.out.println("------------------------------");
    }
    public static void showRings() throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        File inputFile = new File("lab-papers-please\\output\\rings.json");
        JsonNode data = mapper.readTree(inputFile).get("individuals");
        System.out.println("----- Lord of the Rings ------");
        for(JsonNode entry : data){

            PrettyPrint.printEntry(entry);

        }
        System.out.println("------------------------------");
    }
}