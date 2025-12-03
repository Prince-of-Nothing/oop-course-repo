package task4.barista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import task4.coffee.Americano;
import task4.coffee.Cappuccino;
import task4.coffee.Coffee;
import task4.coffee.Intensity;
import task4.coffee.PumpkinSpiceLatte;
import task4.coffee.SyrupCappuccino;
import task4.coffee.SyrupType;


public class Barista {
    List<String> coffeeOrders;
    public void start() {
        if (coffeeOrders == null || coffeeOrders.isEmpty()) {
            coffeeOrders = getUserCoffeeOrders();
        }

        for (String coffeeType : coffeeOrders) {
            System.out.println("Processing order for: " + coffeeType);
            handleCoffeeOrder(coffeeType);
        }

        System.out.println("All orders are complete. Thank you for visiting the Coffee Shop!");
    }

    private List<String> getUserCoffeeOrders() {
        List<String> coffeeOrders = new ArrayList<>();
        boolean ordering = true;

        while (ordering) {
            printMenu();
            int choice = getValidatedIntegerInput("Enter your choice (1-6):", 1, 6);

            switch (choice) {
                case 1 -> coffeeOrders.add("Coffee");
                case 2 -> coffeeOrders.add("Americano");
                case 3 -> coffeeOrders.add("Cappuccino");
                case 4 -> coffeeOrders.add("Syrup Cappuccino");
                case 5 -> coffeeOrders.add("Pumpkin Spice Latte");
                case 6 -> ordering = false;
                default -> System.out.println("Invalid choice. Please try again.");
            }

            if (ordering) {
                System.out.println("Would you like to order another coffee? (yes/no)");
                ordering = getUserConfirmation();
            }
        }

        return coffeeOrders;
    }

    private void handleCoffeeOrder(String coffeeType) {
        System.out.println("Would you like the Barista recommendation or customize it yourself?");
        System.out.println("1. Barista Recommendation");
        System.out.println("2. Customize");
        printSeparator();

        int choice = getValidatedIntegerInput("Enter your choice: ", 1, 2);
        Coffee coffee;

        if (choice == 1) {
            coffee = getBaristaRecommendation(coffeeType);
            System.out.println("Here is our recommended " + coffeeType + " just for you!");
        } else {
            coffee = getCustomCoffee(coffeeType);
            System.out.println("Your custom " + coffeeType + " is ready!");
        }

        coffee.printCoffeeDetails();


        coffee.makeCoffee();
        printSeparator();
    }

    private Coffee getBaristaRecommendation(String coffeeType) {
        return switch (coffeeType) {
            case "Coffee" -> new Coffee(Intensity.NORMAL);
            case "Americano" -> new Americano(Intensity.NORMAL, 150);
            case "Cappuccino" -> new Cappuccino(Intensity.NORMAL, 150);
            case "Syrup Cappuccino" -> new SyrupCappuccino(Intensity.NORMAL, 150, SyrupType.VANILLA);
            case "Pumpkin Spice Latte" -> new PumpkinSpiceLatte(Intensity.NORMAL, 150, 10);
            default -> throw new IllegalArgumentException("Unknown coffee type: " + coffeeType);
        };
    }

    private Coffee getCustomCoffee(String coffeeType) {
        Intensity intensity = getIntensity();
        int mlOfWater = 0, mlOfMilk = 0, mgOfSpice = 0;
        SyrupType syrup = null;

        switch (coffeeType) {
            case "Americano" -> {
                mlOfWater = getValidatedIntegerInput("Enter ml of water: ", 50, 300);
                return new Americano(intensity, mlOfWater);
            }
            case "Cappuccino" -> {
                mlOfMilk = getValidatedIntegerInput("Enter ml of milk: ", 50, 200);
                return new Cappuccino(intensity, mlOfMilk);
            }
            case "Syrup Cappuccino" -> {
                mlOfMilk = getValidatedIntegerInput("Enter ml of milk: ", 50, 200);
                syrup = getSyrupType();
                return new SyrupCappuccino(intensity, mlOfMilk, syrup);
            }
            case "Pumpkin Spice Latte" -> {
                mlOfMilk = getValidatedIntegerInput("Enter ml of milk: ", 50, 200);
                mgOfSpice = getValidatedIntegerInput("Enter mg of pumpkin spice: ", 1, 50);
                return new PumpkinSpiceLatte(intensity, mlOfMilk, mgOfSpice);
            }
            default -> throw new IllegalArgumentException("Unknown coffee type");
        }
    }

    private Intensity getIntensity() {
        System.out.println("Select coffee intensity:");
        System.out.println("1. Light");
        System.out.println("2. Normal");
        System.out.println("3. Strong");
        printSeparator();

        int intensityChoice = getValidatedIntegerInput("Enter intensity: ", 1, 3);
        return switch (intensityChoice) {
            case 1 -> Intensity.LIGHT;
            case 2 -> Intensity.NORMAL;
            case 3 -> Intensity.STRONG;
            default -> Intensity.NORMAL;
        };
    }

    private SyrupType getSyrupType() {
        System.out.println("Select syrup type:");
        SyrupType[] syrups = SyrupType.values();
        for (int i = 0; i < syrups.length; i++) {
            System.out.println((i + 1) + ". " + syrups[i]);
        }
        printSeparator();

        int syrupChoice = getValidatedIntegerInput("Enter syrup choice: ", 1, syrups.length);
        return syrups[syrupChoice - 1];
    }

    private boolean getUserConfirmation() {
        Scanner scanner = new Scanner(System.in);
        String response = scanner.next().trim().toLowerCase();
        return response.equals("yes") || response.equals("y");
    }

    private int getValidatedIntegerInput(String prompt, int minValue, int maxValue) {
        Scanner scanner = new Scanner(System.in);
        int value;

        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value >= minValue && value <= maxValue) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number between " + minValue + " and " + maxValue + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a number!");
                scanner.next(); // Clear invalid input
            }
        }
        return value;
    }

    private void printMenu() {
        System.out.println("Welcome to the Coffee Shop!");
        System.out.println("Choose your coffee type:");
        System.out.println("1. Coffee");
        System.out.println("2. Americano");
        System.out.println("3. Cappuccino");
        System.out.println("4. Syrup Cappuccino");
        System.out.println("5. Pumpkin Spice Latte");
        System.out.println("6. Exit");
        printSeparator();
    }

    private void printSeparator() {
        System.out.println("----------------------------------------------------------------");
    }
}