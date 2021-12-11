#include <stdio.h>
#include <stdlib.h>
#include "greet.h"

int main() {

    char **greeting = (char **) malloc(sizeof(char *));
    char **name = (char **) malloc(sizeof(char *) * 1);
    name[0] = (char *) malloc(sizeof(char) * 5);
    name[0] = "Luka";
    greet(1, name, greeting);
    printf("%s\n", *greeting);

    greeting = (char **) malloc(sizeof(char *));
    name = (char **) malloc(sizeof(char *) * 1);
    name[0] = (char *) malloc(sizeof(NULL));
    name[0] = NULL;
    greet(1, name, greeting);
    printf("%s\n", *greeting);

    greeting = (char **) malloc(sizeof(char *));
    name = (char **) malloc(sizeof(char *) * 2);
    name[0] = (char *) malloc(sizeof(NULL));
    name[0] = NULL;
    name[1] = (char *) malloc(sizeof(NULL));
    name[1] = NULL;
    greet(2, name, greeting);
    printf("%s\n", *greeting);

    greeting = (char **) malloc(sizeof(char *));
    name = (char **) malloc(sizeof(char *) * 1);
    name[0] = (char *) malloc(sizeof(char) * 5);
    name[0] = "LUKA";
    greet(1, name, greeting);
    printf("%s\n", *greeting);

    greeting = (char **) malloc(sizeof(char *));
    name = (char **) malloc(sizeof(char *) * 2);
    name[0] = (char *) malloc(sizeof(char) * 5);
    name[0] = "Luka";
    name[1] = (char *) malloc(sizeof(char) * 6);
    name[1] = "Luka2";
    greet(2, name, greeting);
    printf("%s\n", *greeting);

    greeting = (char **) malloc(sizeof(char *));
    name = (char **) malloc(sizeof(char *) * 3);
    name[0] = (char *) malloc(sizeof(char) * 5);
    name[0] = "Luka";
    name[1] = (char *) malloc(sizeof(char) * 6);
    name[1] = "Luka2";
    name[2] = (char *) malloc(sizeof(char) * 7);
    name[2] = "Luka3";
    greet(3, name, greeting);
    printf("%s\n", *greeting);

    greeting = (char **) malloc(sizeof(char *));
    name = (char **) malloc(sizeof(char *) * 3);
    name[0] = (char *) malloc(sizeof(char) * 5);
    name[0] = "LUKA";
    name[1] = (char *) malloc(sizeof(char) * 6);
    name[1] = "LUKAA";
    name[2] = (char *) malloc(sizeof(char) * 7);
    name[2] = "LUKAAA";
    greet(3, name, greeting);
    printf("%s\n", *greeting);

    greeting = (char **) malloc(sizeof(char *));
    name = (char **) malloc(sizeof(char *) * 5);
    name[0] = (char *) malloc(sizeof(char) * 5);
    name[0] = "LUKA";
    name[1] = (char *) malloc(sizeof(char) * 5);
    name[1] = "Luka";
    name[2] = (char *) malloc(sizeof(char) * 7);
    name[2] = "LUKAAA";
    name[3] = (char *) malloc(sizeof(char) * 6);
    name[3] = "LUKAA";
    name[4] = (char *) malloc(sizeof(char) * 6);
    name[4] = "Lukaa";
    greet(5, name, greeting);
    printf("%s\n", *greeting);

    return 0;
}
