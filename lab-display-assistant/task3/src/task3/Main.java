package task3;

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
   
    }
}