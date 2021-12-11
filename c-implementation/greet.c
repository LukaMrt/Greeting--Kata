#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>

bool isUpperCase(char *name);

void splitNames(int count, char *const *name, int *lowerCaseCount, int *upperCaseCount, char ***lowerCaseNames,
                char ***upperCaseNames);

void greet(int count, char *names[count], char **greeting)  {

    int lowerCaseCount = 0;
    int upperCaseCount = 0;

    char **lowerCaseNames = malloc(sizeof(char *) * count);
    char **upperCaseNames = malloc(sizeof(char *) * count);

    splitNames(count, names, &lowerCaseCount, &upperCaseCount,
               &lowerCaseNames, &upperCaseNames);

    if (lowerCaseCount == 0 && upperCaseCount == 0) {
        asprintf(greeting, "Hello, my friend");
        return;
    }

    if (lowerCaseCount != 0) {
        asprintf(greeting, "Hello");

        for (int i = 0; i < lowerCaseCount; i++) {
            char *separator = (i == lowerCaseCount - 1 && i != 0) ? " and" : ",";
            asprintf(greeting, "%s%s %s", *greeting, separator, lowerCaseNames[i]);
        }

    }

    asprintf(greeting, "%s.", *greeting);

    if (upperCaseCount == 0) {
        return;
    }

    asprintf(greeting, "%s AND ", *greeting);

    if (lowerCaseCount == 0) {
        asprintf(greeting, "");
    }

    asprintf(greeting, "%sHELLO", *greeting);

    for (int i = 0; i < upperCaseCount; i++) {
        char *separator = (i == upperCaseCount - 1 && i != 0) ? " AND" : ",";
        asprintf(greeting, "%s%s %s", *greeting, separator, upperCaseNames[i]);
    }

    asprintf(greeting, "%s!", *greeting);
}

void splitNames(int count, char *const *name, int *lowerCaseCount, int *upperCaseCount,
                char ***lowerCaseNames, char ***upperCaseNames) {

    for (int i = 0; i < count; i++) {

        if (isUpperCase(name[i])) {
            (*upperCaseCount)++;
            (*upperCaseNames) = realloc((*upperCaseNames), sizeof(char *) * (*upperCaseCount));
            (*upperCaseNames)[(*upperCaseCount) - 1] = name[i];
            continue;
        }

        (*lowerCaseCount)++;
        (*lowerCaseNames) = realloc((*lowerCaseNames), sizeof(char *) * (*lowerCaseCount));

        char **current = malloc(sizeof(char *));
        asprintf(current, "%s", name[i]);

        if (name[i] == NULL) {
            asprintf(current, "my friend");
        }

        (*lowerCaseNames)[(*lowerCaseCount) - 1] = malloc(sizeof(char) * strlen(*current));
        strcpy((*lowerCaseNames)[(*lowerCaseCount) - 1], *current);
    }

}

bool isUpperCase(char *name) {

    if (name == NULL) {
        return false;
    }

    for (int i = 0; i < strlen(name); i++) {

        if (name[i] < 'A' || 'Z' < name[i]) {
            return false;
        }

    }

    return true;
}
