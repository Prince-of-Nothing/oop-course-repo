package test.java.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.oop.practice.cars.model.Car;
import main.java.oop.practice.station.CarStation;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueProcessingTest {

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    void processQueueFiles() throws Exception {
        Path queueDir = Paths.get("C:\\Users\\Unknown\\Documents\\GitHub\\oop-course-repo\\queue");
        Path processedDir = Paths.get("C:\\Users\\Unknown\\Documents\\GitHub\\oop-course-repo\\JSONProcessed");

        // Ensure folders exist
        Files.createDirectories(queueDir);
        Files.createDirectories(processedDir);

        CarStation station = new CarStation();

        // Move processed files back to queue before processing
        try (Stream<Path> processedFiles = Files.list(processedDir)) {
            processedFiles.forEach(file -> {
                try {
                    Files.move(file, queueDir.resolve(file.getFileName()));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }

        // Process all JSON files in queue
        try (Stream<Path> queueFiles = Files.list(queueDir)
                .filter(p -> p.toString().toLowerCase().endsWith(".json"))
                .sorted(Comparator.comparing(Path::getFileName))) {

            queueFiles.forEach(path -> {
                try {
                    Car car = mapper.readValue(path.toFile(), Car.class);
                    station.addCar(car);

                    // Move to processed folder after processing
                    Files.move(path, processedDir.resolve(path.getFileName()));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }

        // Serve queued cars
        station.serveCars();

        // Replace these with expected numbers according to your test data
        int expectedGasCars = 2;
        int expectedElectricCars = 1;
   }
}
