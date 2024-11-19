#ifndef MARKOV_H
#define MARKOV_H

double **compute_transition_matrix(int num_nodes, int *outdegrees,
                                   int **out_X_to_Y, double P);

double *get_markov_pagerank_probs(double **M, int num_nodes, int m_N);

#endif