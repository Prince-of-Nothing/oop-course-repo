package oop.practice;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class View {
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