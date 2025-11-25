package task3;
import task1.Display;

import java.util.ArrayList;
import java.util.List;

public class Assistant {
    private String assistantName;
    private List<Display> assignedDisplays;

    public Assistant(String assistantName) {
        this.assistantName = assistantName;
        this.assignedDisplays = new ArrayList<>();
    }

    // Adds a Display object to the assignedDisplays list
    // Adds a Display object to the assignedDisplays list
    public void assignDisplay(Display d) {
        assignedDisplays.add(d);
        System.out.println("Assigned display: " + d.getModel());
    }

    // Iterates through assignedDisplays, comparing each Display with every other Display
 public void assist() {
        System.out.println("\n" + assistantName + " assisting with display comparison:");
        if (assignedDisplays.isEmpty()) {
            System.out.println("No displays assigned.");
            return;
        }
// Compare each display with every other display
        for (int DisplayIndex = 0; DisplayIndex < assignedDisplays.size(); DisplayIndex++) {
            Display currentDisplay = assignedDisplays.get(DisplayIndex);
            for (int comparedDisplayIndex = DisplayIndex + 1; comparedDisplayIndex < assignedDisplays.size(); comparedDisplayIndex++) {
                Display otherDisplay = assignedDisplays.get(comparedDisplayIndex);
                System.out.println("\nComparing " + currentDisplay.getModel() + " with " + otherDisplay.getModel() + ":");
                currentDisplay.compareWithMonitor(otherDisplay);
            }
        }
    }
    // Removes a display from the list and returns it
    public Display buyDisplay(Display d) {
    }

    // Returns the number of assigned displays
    public int getAssignedDisplaysCount() {
    }

    // Returns the Display object at the specified index
    public Display getDisplayByIndex(int index) {
    }

    // Lists all available displays for purchase
    public void listAvailableDisplays() {
        
    }
}