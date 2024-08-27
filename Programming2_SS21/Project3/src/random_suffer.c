#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "random_suffer.h"
#include "utils.h"

int *perform_random_suffer(int num_nodes, int *outdegrees, int **out_X_to_Y,
                           int p_N, int r_N) {
  int *link_walk_array[num_nodes];
  for (int i = 0; i < num_nodes; i++) {
    link_walk_array[i] = (int *)malloc(outdegrees[i] * sizeof(int));
    int link_cnt = 0;
    for (int j = 0; j < num_nodes; j++) {
      int num_occurences = out_X_to_Y[i][j];
      for (int lc = 0; lc < num_occurences; lc++) {
        link_walk_array[i][link_cnt] = j;
        link_cnt += 1;
      }
    }
  }

  int cur_node = randu(num_nodes);

  int *cnt_node_in_sp = (int *)malloc(num_nodes * sizeof(int));
  for (int i = 0; i < num_nodes; i++) {
    cnt_node_in_sp[i] = 0;
  }

  for (int r = 0; r < r_N; r++) {
    // check if random walk will be used
    int use_random_walk = 1;
    if (outdegrees[cur_node] != 0) {
      if (randu(100) >= p_N) {
        use_random_walk = 0;
      }
    }

    int nex_node;
    if (use_random_walk) {
      nex_node = randu(num_nodes);
    } else {
      nex_node = link_walk_array[cur_node][randu(outdegrees[cur_node])];
    }
    cnt_node_in_sp[nex_node] += 1;
    cur_node = nex_node;
  }

  for (int i = 0; i < num_nodes; i++) {
    free(link_walk_array[i]);
  }

  return cnt_node_in_sp;
}