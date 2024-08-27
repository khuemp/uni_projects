#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "preprocess.h"

void get_node_list(char **heads, char **tails, int num_edges, char **nodes,
                   int *num_nodes_to_save) {

  int num_nodes = 0;

  for (int i = 0; i < num_edges; i++) {
    int head_existed = 0;
    for (int j = 0; j < num_nodes; j++) {
      if (strcmp(nodes[j], heads[i]) == 0) {
        head_existed = 1;
        break;
      }
    }
    if (head_existed == 0) {
      nodes[num_nodes] = heads[i];
      num_nodes += 1;
    }

    int tail_existed = 0;
    for (int j = 0; j < num_nodes; j++) {
      if (strcmp(nodes[j], tails[i]) == 0) {
        tail_existed = 1;
        break;
      }
    }
    if (tail_existed == 0) {
      nodes[num_nodes] = tails[i];
      num_nodes += 1;
    }
  }

  *num_nodes_to_save = num_nodes;
}

void compute_in_out_degrees(char **nodes, int num_nodes, char **heads,
                            char **tails, int num_edges, int *outdegrees,
                            int *indegrees) {
  for (int i = 0; i < num_nodes; i++) {
    int num_outdegrees = 0;
    for (int j = 0; j < num_edges; j++) {
      if (strcmp(nodes[i], heads[j]) == 0) {
        num_outdegrees += 1;
      }
    }
    outdegrees[i] = num_outdegrees;
  }

  for (int i = 0; i < num_nodes; i++) {
    int num_indegrees = 0;
    for (int j = 0; j < num_edges; j++) {
      if (strcmp(nodes[i], tails[j]) == 0) {
        num_indegrees += 1;
      }
    }
    indegrees[i] = num_indegrees;
  }
}

int get_max(int *arr, int len) {
  int max = arr[0];
  for (int i = 0; i < len; i++) {
    if (max < arr[i]) {
      max = arr[i];
    }
  }
  return max;
}

int get_min(int *arr, int len) {
  int min = arr[0];
  for (int i = 0; i < len; i++) {
    if (min > arr[i]) {
      min = arr[i];
    }
  }
  return min;
}

int **get_adjacency_matrix(char **heads, char **tails, char **nodes,
                           int num_nodes, int num_edges) {

  int head_ind[num_edges];
  int tail_ind[num_edges];

  // creat out(X,Y) matrix
  for (int i = 0; i < num_nodes; i++) {
    for (int j = 0; j < num_edges; j++) {
      if (strcmp(heads[j], nodes[i]) == 0) {
        head_ind[j] = i;
      }
      if (strcmp(tails[j], nodes[i]) == 0) {
        tail_ind[j] = i;
      }
    }
  }

  int **A = (int **)malloc(num_nodes * sizeof(int *));

  for (int i = 0; i < num_nodes; i++) {
    A[i] = (int *)malloc(num_nodes * sizeof(int));
    for (int j = 0; j < num_nodes; j++) {
      A[i][j] = 0;
    }
  }
  for (int i = 0; i < num_edges; i++) {
    A[head_ind[i]][tail_ind[i]] += 1;
  }

  return A;
}