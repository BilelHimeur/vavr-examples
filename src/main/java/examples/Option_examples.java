package examples;

import io.vavr.control.Option;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Option_examples {
    // The main goal of Option is to eliminate null checks in our code by leveraging the Java type system.
    @Test
    public void givenValue_whenCreatesOption_thenCorrect() {
        Option<Object> noneOption = Option.of(null);
        Option<Object> someOption = Option.of("val");

        assertEquals("None", noneOption.toString());
        assertEquals("Some(val)", someOption.toString());
    }

    @Test
    public void givenNull_whenCreatesOption_thenCorrect() {
        String name = null;
        Option<String> nameOption = Option.of(name);

        assertEquals("baeldung", nameOption.getOrElse("baeldung"));
    }

    @Test
    public void givenNonNull_whenCreatesOption_thenCorrect() {
        String name = "baeldung";
        Option<String> nameOption = Option.of(name);

        assertEquals("baeldung", nameOption.getOrElse("notbaeldung"));
    }
}
