package fr.lukam.greeting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class GreeterTest {

    private final Greeter greeter = new Greeter();

    @ParameterizedTest(name = "we should greet people given a name")
    @ValueSource(strings = {"Bob", "John", "Jack"})
    public void greet_shouldReturnHelloFollowedByName_givenOneName(String name) {

        String result = greeter.greet(name);

        assertThat(result).isEqualTo("Hello, " + name + ".");
    }

    @Test
    @DisplayName("we should greeting \"my friend\" given name is null")
    public void greet_shouldReturnHelloMyFriend_givenNullName() {

        String result = greeter.greet((String) null);

        assertThat(result).isEqualTo("Hello, my friend.");
    }

    @ParameterizedTest(name = "we should return an upper case greeting given an upper case name")
    @ValueSource(strings = {"BOB", "JOHN", "JACK"})
    @DisplayName("we should return an upper case greeting given an upper case name")
    public void greet_shouldReturnUpperCaseGreeting_givenUpperCaseName(String name) {

        String result = greeter.greet(name);

        assertThat(result).isEqualTo("HELLO " + name + "!");
    }

    @ParameterizedTest(name = "we should greet people in one sentence separated by an \"and\" given 2 names")
    @ValueSource(strings = {"Bob,John", "John,Jack", "Jack,Bob"})
    @DisplayName("we should greet people in one sentence separated by an \"and\" given 2 names")
    public void greet_shouldReturnGreetingForTwoNames_givenTwoNames(String name) {

        String[] names = name.split(",");

        String result = greeter.greet(names);

        assertThat(result).isEqualTo("Hello, " + names[0] + " and " + names[1] + ".");
    }

    @ParameterizedTest(name = "we should greet people in one sentence separated by a comma and an \"and\" given 3 names")
    @ValueSource(strings = {"Bob,John,Jack", "John,Jack,Bob", "Jack,Bob,John"})
    @DisplayName("we should greet people in one sentence separated by a comma and an \"and\" given 3 names")
    public void greet_shouldReturnGreetingFor3Names_given3Names(String name) {

        String[] names = name.split(",");

        String result = greeter.greet(names);

        assertThat(result).isEqualTo("Hello, " + names[0] + ", " + names[1] + " and " + names[2] + ".");
    }

    @ParameterizedTest(name = "we should greet people in one sentence separated by 2 comma and an \"and\" given 4 names")
    @ValueSource(strings = {"Bob,John,Jack,Philipp", "John,Jack,Philipp,Bob", "Jack,Philipp,Bob,John"})
    @DisplayName("we should greet people in one sentence separated by 2 comma and an \"and\" given 4 names")
    public void greet_shouldReturnGreetingFor4Names_given4Names(String name) {

        String[] names = name.split(",");

        String result = greeter.greet(names);

        assertThat(result).isEqualTo("Hello, " + names[0] + ", " + names[1] + ", " + names[2] + " and " + names[3] + ".");
    }

    @Nested
    class LowerAndUpperNames {

        @Test
        @DisplayName("1 - we should greet people separating upper case and lower case when given upper case and lower case names")
        public void greet_shouldReturnGreetingForLowerAndUpperNames_givenLowerAndUpperNames1() {

            String[] names = new String[]{"John", "DAVID", "Jack", "PHILIPP", "Bob"};

            String result = greeter.greet(names);

            assertThat(result).isEqualTo("Hello, John, Jack and Bob. AND HELLO DAVID AND PHILIPP!");
        }

        @Test
        @DisplayName("2 - we should greet people separating upper case and lower case when given upper case and lower case names")
        public void greet_shouldReturnGreetingForLowerAndUpperNames_givenLowerAndUpperNames2() {

            String[] names = new String[]{"Bob", "John", "Jack", "PHILIPP", "DAVID"};

            String result = greeter.greet(names);

            assertThat(result).isEqualTo("Hello, Bob, John and Jack. AND HELLO PHILIPP AND DAVID!");
        }

        @Test
        @DisplayName("3 - we should greet people separating upper case and lower case when given upper case and lower case names")
        public void greet_shouldReturnGreetingForLowerAndUpperNames_givenLowerAndUpperNames3() {

            String[] names = new String[]{"Jack", "PHILIPP", "Bob", "DAVID", "John"};

            String result = greeter.greet(names);

            assertThat(result).isEqualTo("Hello, Jack, Bob and John. AND HELLO PHILIPP AND DAVID!");
        }

    }

    @ParameterizedTest(name = "we should greet people in one upper case sentence separated by a comma and an \"and\" given 3 upper case names")
    @ValueSource(strings = {"BOB,JOHN,JACK", "JOHN,JACK,BOB", "JACK,JOHN,BOB"})
    @DisplayName("we should greet people in one upper case sentence separated by a comma and an \"and\" given 3 upper case names")
    public void greet_shouldReturnGreetingFor3UpperNames_given3UpperNames(String name) {

        String[] names = name.split(",");

        String result = greeter.greet(names);

        assertThat(result).isEqualTo("HELLO " + names[0] + ", " + names[1] + " AND " + names[2] + "!");
    }

    @ParameterizedTest(name = "we should greet people reformating names given many names separated by commas")
    @ValueSource(strings = {"Bob_John,Jack", "John,Jack_Bob", "Jack_John,Bob"})
    @DisplayName("we should greet people reformating names given many names separated by commas")
    public void greet_shouldReformatNamesAndReturnHelloFollowedByNames_givenNamesWithComma(String name) {

        String[] names = name.split("_");

        String result = greeter.greet(names);

        String[] expectedNames = name.replace("_", ",").split(",");
        assertThat(result).isEqualTo("Hello, " + expectedNames[0] + ", " + expectedNames[1] + " and " + expectedNames[2] + ".");
    }

    @Nested
    class EscaptedComma {

        @Test
        @DisplayName("1 - we should greet people without reformating names given many names separated by escaped commas")
        public void greet_shouldReturnHelloFollowedByNames_givenNamesWithEscapedComma1() {

            String[] names = new String[]{"Bob", "\"John, Jack\""};

            String result = greeter.greet(names);

            assertThat(result).isEqualTo("Hello, " + names[0] + " and " + names[1].substring(1, names[1].length() - 1) + ".");
        }

        @Test
        @DisplayName("2 - we should greet people without reformating names given many names separated by escaped commas")
        public void greet_shouldReturnHelloFollowedByNames_givenNamesWithEscapedComma2() {

            String[] names = new String[]{"\"John, Jack\"", "Bob"};

            String result = greeter.greet(names);

            assertThat(result).isEqualTo("Hello, " + names[0].substring(1, names[0].length() - 1) + " and " + names[1] + ".");
        }

    }

    @ParameterizedTest(name = "we should greet people reformating names given many names separated by misescaped commas")
    @ValueSource(strings = {"Bob_\"John,Jack", "John,Jack_Bob\"", "Jack_\"John,Bob"})
    @DisplayName("we should greet people reformating names given many names separated by misescaped commas")
    public void greet_shouldReformatNamesAndReturnHelloFollowedByNames_givenNamesWithCommaHalfEscaped(String name) {

        String[] names = name.split("_");

        String result = greeter.greet(names);

        String[] expectedNames = name.replace("_", ",").split(",");
        assertThat(result).isEqualTo("Hello, " + expectedNames[0] + ", " + expectedNames[1] + " and " + expectedNames[2] + ".");
    }

}
