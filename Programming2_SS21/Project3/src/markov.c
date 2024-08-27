#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "markov.h"

double **compute_transition_matrix(int num_nodes, int *outdegrees,
                                   int **out_X_to_Y, double P) {
  double **M = malloc(num_nodes * sizeof(double *));

  for (int i = 0; i < num_nodes; i++) {
    M[i] = (double *)malloc(num_nodes * sizeof(double));
    for (int j = 0; j < num_nodes; j++) {
      if (outdegrees[i] == 0) {
        M[i][j] = 1.0 / num_nodes;
      } else {
        M[i][j] = P / num_nodes + (1.0 - P) * out_X_to_Y[i][j] / outdegrees[i];
      }
    }
  }

  return M;
}

double *get_markov_pagerank_probs(double **M, int num_nodes, int m_N) {
  // calculate v0 after N steps
  double *v_res = malloc(num_nodes * sizeof(double));
  double v_save[num_nodes];

  for (int i = 0; i < num_nodes; i++) {
    v_res[i] = 1.0 / num_nodes;
  }
  for (int x = 0; x < m_N; x++) {
    for (int j = 0; j < num_nodes; j++) {
      double sum = 0.0;
      for (int i = 0; i < num_nodes; i++) {
        sum += v_res[i] * M[i][j];
      }
      v_save[j] = sum;
    }
    for (int y = 0; y < num_nodes; y++) {
      v_res[y] = v_save[y];
    }
  }

  return v_res;
}
