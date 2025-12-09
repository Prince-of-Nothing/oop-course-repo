import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

import test.QueueTest;
import test.SemaphoreTest;
import test.CarServiceTest;

import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        System.out.println("Running Tests...");

        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(
                        selectClass(QueueTest.class),
                        selectClass(SemaphoreTest.class),
                        selectClass(CarServiceTest.class)
                )
                .build();

        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();

        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);

        TestExecutionSummary summary = listener.getSummary();
        summary.printTo(new PrintWriter(System.out));

        if (summary.getTestsFailedCount() > 0) {
            System.out.println("\nSOME TESTS FAILED!");
            summary.getFailures().forEach(failure -> {
                System.out.println("Failed: " + failure.getTestIdentifier().getDisplayName());
                System.out.println(failure.getException());
            });
        } else {
            System.out.println("\nALL TESTS PASSED SUCCESSFULLY!");
        }
    }
}