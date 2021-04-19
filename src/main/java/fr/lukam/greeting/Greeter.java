package fr.lukam.greeting;

import java.util.Arrays;

public class Greeter {

    public String greet(String... names) {

        names = Arrays.stream(names)
                .map(this::formatName)
                .flatMap(Arrays::stream)
                .toArray(String[]::new);

        return formatGreeting(names);
    }

    private String[] formatName(String name) {

        if (name == null) {
            name = "my friend";
        }

        if (!name.startsWith("\"") || !name.endsWith("\"")) {
            return name.replace(" ", "")
                    .replace("myfriend", "my friend")
                    .split(",");
        }

        return new String[]{name.substring(1, name.length() - 1)};
    }

    private String formatGreeting(String[] names) {
        String lowerCaseFormat = buildSubgreeting(names, false);
        String upperCaseFormat = buildSubgreeting(names, true);

        return (!lowerCaseFormat.isEmpty() ? "Hello, " + lowerCaseFormat + "." : "")
                + (!lowerCaseFormat.isEmpty() && !upperCaseFormat.isEmpty() ? " AND " : "")
                + (!upperCaseFormat.isEmpty() ? "HELLO " + upperCaseFormat + "!" : "");
    }

    private String buildSubgreeting(String[] names, boolean upperCase) {

        names = Arrays.stream(names)
                .filter(name -> name.toUpperCase().equals(name) == upperCase)
                .toArray(String[]::new);

        if (names.length == 0) {
            names = new String[]{""};
        }

        StringBuilder subGreeting = new StringBuilder(names[0]);

        for (int i = 1; i < names.length; i++) {
            String separator = i != names.length - 1 ? ", " : (upperCase ? " AND " : " and ");
            subGreeting.append(separator).append(names[i]);
        }

        return subGreeting.toString();
    }

}
