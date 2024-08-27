#ifndef PREPROCESS_H
#define PREPROCESS_H

void get_node_list(char **heads, char **tails, int num_edges, char **nodes,
                   int *num_nodes_to_save);

void compute_in_out_degrees(char **nodes, int num_nodes, char **heads,
                            char **tails, int num_edges, int *outdegrees,
                            int *indegrees);

int** get_adjacency_matrix(char **heads, char **tails, char **nodes,
                          int num_nodes, int num_edges);

int get_max(int *arr, int len);
int get_min(int *arr, int len);

#endif