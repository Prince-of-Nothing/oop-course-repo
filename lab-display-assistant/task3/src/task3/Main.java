package task3;

import java.util.Scanner;
import task1.Display;

public class Main {
    public static void main(String[] args) {
        Assistant assistant = new Assistant("Display Assistant");

        // Create multiple Display objects
        Display display1 = new Display(19200, 10800, 215, "Dell 110' Monitor");
        Display display2 = new Display(2560, 1440, 250, "LG Ultron 27");
        Display display3 = new Display(384, 216, 300, "Samsung HUD 11'");
        Display display4 = new Display(5120, 2880, 230, "Valve Gamecube Monitor");
        Display display5 = new Display(1920, 1080, 215, "HP Sect 22");
   
        // Assigned all displays to the assistant
        assistant.assignDisplay(display1);
        assistant.assignDisplay(display2);
        assistant.assignDisplay(display3);
        assistant.assignDisplay(display4);
        assistant.assignDisplay(display5);
        // Assist with display comparison, so the user chooses the most expensive one (I am joking here)
        assistant.assist();
        // Buy a display that the user wants
        Scanner scan = new Scanner(System.in);
        System.out.println("\nAvailable displays to purchase:");
        assistant.listAvailableDisplays();  // Added method to list available displays, so the user can see a numerical representation

        System.out.print("\nEnter the number of the display to buy (1-" + assistant.getAssignedDisplaysCount() + "): ");
        int choice = scan.nextInt();

        if (choice > 0 && choice <= assistant.getAssignedDisplaysCount()) {
            Display selectedDisplay = assistant.getDisplayByIndex(choice - 1);
            assistant.buyDisplay(selectedDisplay);
        } else {
            System.out.println("Invalid choice. Please select a valid display number.");
        }

        // Print how many displays and remaining displays
        System.out.println("\nRemaining displays:");
        assistant.listAvailableDisplays();

        scan.close(); // Close the scanner to prevent resource leaks
}
}