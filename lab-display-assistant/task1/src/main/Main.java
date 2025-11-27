package main;
//it took a while to find this info on reddit so to use a package you need to specify the path and the java file needed , instead of \, using . so if the path were src\task1\display , we would do import task1.display.<Java file name>;
import task1.Display;

public class Main {
    public static void main(String[] args) {
        Display display1 = new Display(5120, 2880, 218, "Monitor Apple Studio Display (MMYV3)");
        Display display2 = new Display(3840, 2160, 139, "Monitor ASUS ROG Swift OLED PG32UCDP");
        Display display3 = new Display(2560, 1440, 110, "Monitor ASUS ROG Strix OLED XG27AQDPG");
        //the minimum comparisons are 3 of 2 ...
        display1.compareWithMonitor(display2); // Compare display1 object with display2 based on display size and sharpness
        display1.compareWithMonitor(display3);
        display2.compareWithMonitor(display3);
    }
}