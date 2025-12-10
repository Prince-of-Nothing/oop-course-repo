package main.java.oop.practice.station;

import com.fasterxml.jackson.core.Versioned;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.oop.practice.cars.model.Car;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduler {
    private static final int PROCESSING_INTERVAL_SEC = 2; // 2 seconds interval
    private static final String QUEUE_DIR = "oop-lab-3/Resources/src";
    //private static final String QUEUE_DIR = "OOP/src/main/resources/InputData"; // Adjust to your project setup
    private static Semaphore semaphore;
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static ScheduledExecutorService executorService;

    public static void main(String[] args) {
        // Single CarStation instance
        CarStation carStation = new CarStation();
        semaphore = new Semaphore(carStation);
        executorService = Executors.newSingleThreadScheduledExecutor();

        // Start processing cars at a fixed interval
        executorService.scheduleAtFixedRate(() -> {
            if (!processSingleCarFromFile()) {
                System.out.println("All cars have been processed. Stopping file processing.");
                executorService.shutdown(); // Stop processing cars
                serveCarsFromStation();     // Begin serving cars
            }
        }, 0, PROCESSING_INTERVAL_SEC, TimeUnit.SECONDS);
    }

    /**
     * Processes a single car from the file queue.
     *
     * @return true if a car was processed, false if no files were available
     */
    private static boolean processSingleCarFromFile() {
        File queueDir = new File(QUEUE_DIR);
        File[] files = queueDir.listFiles((dir, name) -> name.endsWith(".json"));

        if (files != null && files.length > 0) {
            File file = files[0]; // Process the first file in the directory
            try {
                String content = new String(Files.readAllBytes(Paths.get(file.getPath())));

                // JSON is a single car object
                Car car = objectMapper.readValue(content, Car.class);
                semaphore.getCarStation().addCar(car);


                Files.delete(file.toPath()); // Delete file after processing
                System.out.println("Processed file: " + file.getName());
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false; // No files to process
    }


    /**
     * Serves all cars in the station.
     */
    private static void serveCarsFromStation() {
        System.out.println("Serving all cars...");
        semaphore.getCarStation().serveCars(); // Unified serve method in CarStation
        System.out.println("All cars have been served.");
    }
}