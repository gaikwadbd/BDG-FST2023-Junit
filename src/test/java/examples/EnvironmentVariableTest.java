package examples;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.util.Map;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class EnvironmentVariableTest {

    @Test
    @EnabledIfEnvironmentVariable(named = "PROCESSOR_IDENTIFIER", matches = ".*Intel64 Family 6.*")
    void onIntel64() {
        System.out.println("Run this on Intel6 Family 6 only.");
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "NUMBER_OF_PROCESSORS", matches = "8")
    void onProcessor8() {
        System.out.println("Run this if 8 processors.");
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "CURRENT_ENV", matches = ".*development.*")
    void notOnDeveloperPC() {
        System.out.println("Do not run this if env variables 'CURRENT_ENV' matches .*development.* ");
    }

    @Disabled("print environment variables.")
    @Test
    void printEnvironmentProperties() {
        Map<String, String> env = System.getenv();
        env.forEach((k, v) -> System.out.println(k + ":" + v));
    }
    @Test
    @EnabledOnJre(JRE.JAVA_9)
    void onJava9() {
        System.out.println("Run this on Java 9");
    }

    @Test
    @EnabledOnJre({JRE.JAVA_12, JRE.JAVA_13})
    void onJava12OrJava13() {
        System.out.println("Run this on Java 12 or Java 13");
    }

    @Test
    @DisabledOnJre(JRE.JAVA_9)
    void notOnJava9() {
        System.out.println("Do not run this on Java 9");
    }
    @Test
    @EnabledOnOs({OS.LINUX, OS.WINDOWS})
    void onLinuxOrWindows() {
        System.out.println("Run this on Linux or Windows!");
    }

    @Test
    @EnabledOnOs({OS.WINDOWS})
    void onWindows() {
        System.out.println("Run this on Windows!");
    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    void notOnWindows() {
        System.out.println("Do not run this on Windows!");
    }

    @Test
    @DisabledOnOs({OS.WINDOWS, OS.AIX, OS.SOLARIS, OS.MAC})
    void notOnWindowsOrAixOrSolarisOrMac() {
        System.out.println("Do not run this on Windows, AIX, Solaris or MAC!");
    }
    @Test
    @EnabledIfSystemProperty(named = "java.vm.name", matches = ".*OpenJDK.*")
    void onOpenJDK() {
        System.out.println("Run this on OpenJDK!");
    }

    @Test
    @DisabledIfSystemProperty(named = "user.country", matches = "MY")
    void notOnCountryMalaysia() {
        System.out.println("Do not run this on country code MY");
    }

    @Disabled("print system properties.")
    @Test
    void printSystemProperties() {
        Properties properties = System.getProperties();
        properties.forEach((k, v) -> System.out.println(k + ":" + v));
    }
    @Disabled("Disabled until CustomerService is up!")
    @Test
    void test1Plus1() {
        assertEquals(2, 1 + 1);
    }
    @Disabled("Disabled until CustomerService is up!")
    @Test
    void test2Plus2() {
        assertEquals(4, 2 + 2);
    }
}
