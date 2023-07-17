package examples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
public class TranslationEngineTest {

    private TranslatorEngine translatorEngine;

    @BeforeEach
    public void setUp() {
        translatorEngine = new TranslatorEngine();
    }

    @Test
    public void testTranlsateHello() {
        assertEquals("Bonjour", translatorEngine.tranlate("Hello"));
    }

    @Test
    public void testTranlsateYes() {
        assertEquals("Oui", translatorEngine.tranlate("Yes"));
    }

    @Test
    public void testTranlsateNo() {
        assertEquals("Non", translatorEngine.tranlate("No"));
    }

}