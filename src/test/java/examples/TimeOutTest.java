package examples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

public class TimeOutTest {
    // timed out after 5 seconds
    @BeforeEach
    @Timeout(1)
    void setUpDB() throws InterruptedException {
        //TimeUnit.SECONDS.sleep(10);
    }

    // timed out after 500 miliseconds
    @Test
    @Timeout(value = 5, unit = TimeUnit.MILLISECONDS)
    void test_this() {
    }
    // timed out after 5 seconds
    @Test
    void test_timeout_fail() {
        // assertTimeout(Duration.ofSeconds(5), () -> delaySecond(10)); // this will fail
        assertTimeout(ofSeconds(10), () -> delaySecond(1));
    }

    void delaySecond(int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    void timeoutNotExceeded() {
        // The following assertion succeeds.
        assertTimeout(ofMinutes(2), () -> {
            // Perform task that takes less than 2 minutes.
            System.out.println("This test will pass");
        });
    }

    @Test
    void timeoutExceeded() {
        // The following assertion fails with an error message similar to:
        // execution exceeded timeout of 10 ms by 91 ms
        assertTimeout(ofMillis(100), () -> {
            // Simulate task that takes more than 10 ms.
            Thread.sleep(10);
        });
    }
}
