package examples;

import io.vavr.Function0;
import io.vavr.Function1;
import io.vavr.Function2;
import io.vavr.Function5;
import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Functional_Interfaces_examples {

    @Test
    public void givenJava8Function_whenWorks_thenCorrect() {
        Function<Integer, Integer> square = (num) -> num * num;
        int result = square.apply(2);

        assertEquals(4, result);
    }

    //The second only takes two parameters and produces a result:
    @Test
    public void givenJava8BiFunction_whenWorks_thenCorrect() {
        BiFunction<Integer, Integer, Integer> sum =
                (num1, num2) -> num1 + num2;
        int result = sum.apply(5, 7);

        assertEquals(12, result);
    }

    /*
    * Vavr extends the idea of functional interfaces in Java further by supporting up to a maximum of eight parameters
    * and spicing up the API with methods for memoization, composition, and currying.
    * Just like tuples, these functional interfaces are named according to the number of parameters they
    * take: Function0, Function1, Function2 etc. With Vavr, we would have written the above two functions like this:
    */

    @Test
    public void givenVavrFunction_whenWorks_thenCorrect() {
        Function1<Integer, Integer> square = (num) -> num * num;
        int result = square.apply(2);

        assertEquals(4, result);
    }

    @Test
    public void givenVavrBiFunction_whenWorks_thenCorrect() {
        Function2<Integer, Integer, Integer> sum =
                (num1, num2) -> num1 + num2;
        int result = sum.apply(5, 7);

        assertEquals(12, result);
    }

    // When there is no parameter but we still need an output, in Java 8 we would need
    // to use a Consumer type, in Vavr Function0 is there to help, ex:
    @Test
    public void whenCreatesFunction_thenCorrect0() {
        Function0<String> getClazzName = () -> this.getClass().getName();
        String className = getClazzName.apply();

        assertEquals("examples.Functional_Interfaces_examples", className);
    }

    // Function5 example:
    @Test
    public void whenCreatesFunction_thenCorrect5() {
        Function5<String, String, String, String, String, String> concat =
                (a, b, c, d, e) -> a + b + c + d + e;
        String finalString = concat.apply(
                "Hello ", "world", "! ", "Learn ", "Vavr");

        assertEquals("Hello world! Learn Vavr", finalString);
    }
}
