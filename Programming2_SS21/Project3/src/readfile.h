#ifndef READFILE_H
#define READFILE_H

int read_graph_file(char *filename, char *graph_name, char **heads, char **tails,
                    int *num_edges_to_save);

#endif