#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "readfile.h"

int MAX_ID_LEN = 256;

/*
Return 1 if valid, else return 0.
*/
int check_identifier_letters(char *str) {
  // must start with a letter
  char start = str[0];
  if (!((start >= 'a' && start <= 'z') || (start >= 'A' && start <= 'Z'))) {
    printf("Identifier must start with a letter: %s\n", str);
    return 0;
  }

  for (int i = 0; i < strlen(str); i++) {
    char c = str[i];
    if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') ||
          (c >= '0' && c <= '9'))) {
      printf("Identifier must contain only letters or numbers: %s\n", str);
      return 0;
    }
  }

  return 1;
}

int read_graph_file(char *filename, char *graph_name, char **heads,
                    char **tails, int *num_edges_to_save) {
  FILE *file = fopen(filename, "r");

  if (file == NULL) {
    printf("Cannot open file.\n");
    return 1;
  }

  char digraph[100];
  char open_parenthesis[100];

  fscanf(file, "%s %s %s", digraph, graph_name, open_parenthesis);

  if (strcmp(digraph, "digraph") != 0) {
    printf("False digraph!\n");
    return 1;
  }
  if (strcmp(open_parenthesis, "{") != 0) {
    printf("False open parenthesis!\n");
    return 1;
  }

  // read head/tail and count egdes
  char head_string[1000];
  char tail_string[1000];
  char arrow[100];
  char semicolon[100];
  int num_edges = 0;
  int read;

  while ((read = fscanf(file, "%s %s %s", head_string, arrow, tail_string)) ==
         3) {

    // check semicolon and arrow
    if (tail_string[strlen(tail_string) - 1] != ';') {
      fscanf(file, "%s", semicolon);
      if (strcmp(semicolon, ";") != 0) {
        printf("False semicolon!\n");
        return 1;
      }
    } else {
      tail_string[strlen(tail_string) - 1] = '\0';
    }
    if (strcmp(arrow, "->") != 0) {
      printf("False arrow!\n");
      return 1;
    }

    // check empty identifier
    if (strlen(head_string) == 0 || strlen(tail_string) == 0) {
      printf("Empty identifier(s)!\n");
      return 1;
    }

    // check too long identifier
    if (strlen(head_string) > MAX_ID_LEN || strlen(tail_string) > MAX_ID_LEN) {
      printf("Too long identifier(s)!\n");
      return 1;
    }

    // check identifier letters
    if (check_identifier_letters(head_string) == 0 ||
        check_identifier_letters(tail_string) == 0) {
      printf("Invalid identifier(s)!\n");
      return 1;
    }

    heads[num_edges] = (char *)malloc((MAX_ID_LEN + 1) * sizeof(char));
    tails[num_edges] = (char *)malloc((MAX_ID_LEN + 1) * sizeof(char));
    strcpy(heads[num_edges], head_string);
    strcpy(tails[num_edges], tail_string);
    num_edges += 1;
  }

  if (read == 1) {
    if (strcmp(head_string, "}") != 0) {
      printf("False close parenthesis!\n");
      return 1;
    }
  }
  if (read != 1) {
    printf("False format!\n");
    return 1;
  }

  fclose(file);

  *num_edges_to_save = num_edges;

  return 0;
}
