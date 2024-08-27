/*
 * main.c
 *
 * Programmierung 2 - Projekt 3 (PageRank)
 */

#include <getopt.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "markov.h"
#include "preprocess.h"
#include "random_suffer.h"
#include "readfile.h"
#include "utils.h"

int main(int argc, char *const *argv) {
  // initialize the random number generator
  rand_init();

  // DONE: Implement commands!
  int m_N = 0;
  int r_N = 0;
  int p_N = 10;

  char c;

  int mflag = 0;
  int rflag = 0;
  int sflag = 0;

  while ((c = getopt(argc, argv, "hm:p:r:s")) != -1) {

    switch (c) {
    case 'h':
      printf("Following parameter are allowed:\n\
    -h: A short help on the existing command line parameters is displayed.\n\
    -m <int N>: The caculation is carried out based on the Markov chain with N steps, and the result issed. N is an integer greater than 0.\n\
    -p <int N>: The parameter P for the calculation of the PageRank is set to N/100. N is an interger between 1 and 100. If this parameter is not specified, P=10/100.\n\
    -r <int N>: A simulation of the random walk with N steps is carried out and the result is output, N is an integer greater than 0.\n\
    -s: Statistics of the graph are output.\n\
    At least one of the parameters -h, -m, -r or -s must be specified!\n");
      exit(0);

    case 'm':
      mflag = 1;
      m_N = atoi(optarg);
      if (m_N <= 0) {
        printf("N must be an integer greater than 0!\n");
        exit(1);
      }
      break;

    case 'p':
      p_N = atoi(optarg);
      if (p_N < 1 || p_N > 100) {
        printf("N must be an integer between 1 and 100!\n");
        exit(1);
      }
      break;

    case 'r':
      rflag = 1;
      r_N = atoi(optarg);
      if (r_N <= 0) {
        printf("N must be an integer greater than 0!\n");
        exit(1);
      }
      break;

    case 's':
      sflag = 1;
      break;

    case '?':
      if (optopt == 'm' || optopt == 'p' || optopt == 'r') {
        printf("Parameter -%c requires exactly one argument!\
                  See -h for more help.\n",
               optopt);
      } else {
        printf("Error: Parameter -%c not known", optopt);
      }
      exit(1);

    default:
      printf("Error: optind %i, argc %i\n", optind, argc);
      exit(1);
    }
  }
  if (mflag == 0 && rflag == 0 && sflag == 0) {
    printf("At least one of the parameters -h, -m, -r or -s must be specified!\
            See -h for more help.\n");
    exit(1);
  }

  if (optind != argc - 1) {
    printf("The input file does not exist.\n");
    exit(1);
  }
  // DONE: -s
  // open file, check for file error and invalid format
  char graph_name[10000];
  char *heads[10000];
  char *tails[10000];
  int num_edges = 0;

  int read =
      read_graph_file(argv[optind], graph_name, heads, tails, &num_edges);
  if (read != 0) {
    exit(1);
  }

  if (num_edges == 0) {
    if (sflag == 1) {
      printf("%s:\n\
- num nodes: 0\n\
- num edges: 0\n\
- indegree: 0-0\n\
- outdegree: 0-0\n",
             graph_name);
    }
    exit(0);
  }

  // count nodes
  int num_nodes = 0;
  char *nodes[20000];
  get_node_list(heads, tails, num_edges, nodes, &num_nodes);

  // count indegrees and outdegress
  int indegrees[num_nodes];
  int outdegrees[num_nodes];

  compute_in_out_degrees(nodes, num_nodes, heads, tails, num_edges, outdegrees,
                         indegrees);

  // print statistic
  if (sflag == 1) {
    // find min/max of in/outdegreees
    int max_indegree = get_max(indegrees, num_nodes);
    int min_indegree = get_min(indegrees, num_nodes);
    int max_outdegree = get_max(outdegrees, num_nodes);
    int min_outdegree = get_min(outdegrees, num_nodes);

    printf("%s:\n\
- num nodes: %d\n\
- num edges: %d\n\
- indegree: %d-%d\n\
- outdegree: %d-%d\n",
           graph_name, num_nodes, num_edges, min_indegree, max_indegree,
           min_outdegree, max_outdegree);

    exit(0);
  }

  // DONE: -p
  double P = p_N / 100.0;

  // DONE: -m

  int **out_X_to_Y =
      get_adjacency_matrix(heads, tails, nodes, num_nodes, num_edges);

  // print PageRank in m
  if (mflag == 1) {
    // calculate M matrix
    double **M =
        compute_transition_matrix(num_nodes, outdegrees, out_X_to_Y, P);

    // calculate v0 after N steps
    double *probs = get_markov_pagerank_probs(M, num_nodes, m_N);

    for (int i = 0; i < num_nodes; i++) {
      printf("%s\t%.10f\n", nodes[i], probs[i]);
    }

    // free M and probs
    for (int i = 0; i < num_nodes; i++) {
      free(M[i]);
    }
    free(M);
    free(probs);

  } else if (rflag == 1) { // DONE: -r

    int *node_counts =
        perform_random_suffer(num_nodes, outdegrees, out_X_to_Y, p_N, r_N);

    for (int i = 0; i < num_nodes; i++) {
      double res = (double)node_counts[i] / r_N;
      printf("%s\t%.10f\n", nodes[i], res);
    }

    // free node_counts
    free(node_counts);
  }

  // free out_X_to_Y
  for (int i = 0; i < num_nodes; i++) {
    free(out_X_to_Y[i]);
  }
  free(out_X_to_Y);

  exit(0);
}
