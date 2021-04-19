package fr.lukam.greeting;

public class Main {

    public static void main(String[] args) {

        Greeter greeter = new Greeter();

        System.out.println(greeter.greet("Bob"));
        System.out.println(greeter.greet("BOB"));
        System.out.println(greeter.greet("Bob", "John"));
        System.out.println(greeter.greet("Bob", "John", "David"));
        System.out.println(greeter.greet("Bob", "JOHN"));
        System.out.println(greeter.greet("Bob", "DAVID", "John"));
        System.out.println(greeter.greet("Bob", "David, John"));
        System.out.println(greeter.greet("Bob", "DAVID, John"));
        System.out.println(greeter.greet("Bob", "\"David, John\""));

    }

}
