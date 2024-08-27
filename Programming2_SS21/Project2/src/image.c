#include "image.h"

#include <assert.h>
#include <math.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void apply_threshold(float *img, int w, int h, int T) {
    (void)img;
    (void)w;
    (void)h;
    (void)T;

    // DONE: Implement me!
    int length = w*h;
    for (int i = 0; i < length; i++){
        if (img[i]>T) {
            img[i]=255;
        } else {
            img[i]=0;
        }
    }
}

void scale_image(float *result, const float *img, int w, int h) {
    (void)result;
    (void)img;
    (void)w;
    (void)h;

    // DONE: Implement me!
    int length = w*h;
    int max = img[0];
    int min = img[0];
    for (int i = 1; i < length; i++) {
        if (max<img[i]) {
            max = img[i];
        }
        if (min>img[i]) {
            min = img[i];
        }
    }
    for (int i = 0; i < length; i++) {
        if (max==min) {
            result[i] = 0;
        } else {
            result[i] = (img[i] - min)/(max - min)*255;
        }
    }
}

float get_pixel_value(const float *img, int w, int h, int x, int y) {
    (void)img;
    (void)w;
    (void)h;
    (void)x;
    (void)y;

    // DONE: Implement me!
    int x1 = x;
    int y1 = y;
    
    if (x<0) {
        x1 = -(x+1);
    }
    else if (x>=w) {
        x1 = w-(x-w+1);
    }

    if (y<0) {
        y1 = -(y+1);
    }
    else if (y>=h) {
        y1 = h-(y-h+1);
    }

    return img[x1+w*y1];
}

float *array_init(int size) {
    (void)size;

    // DONE: Implement me!
    float *arr = (float*)malloc(size*sizeof(float));
    return arr;
}

void array_destroy(float *m) {
    (void)m;

    // DONE: Implement me!
    free(m);
}

float *read_image_from_file(const char *filename, int *w, int *h) {
    (void)filename;
    (void)w;
    (void)h;

    // DONE: Implement me!

    FILE* file = fopen(filename, "r");

    if (file==NULL) {
        return NULL;
    }
    
    char P2[100];
    fscanf(file, "%s", P2);
    if (strcmp(P2, "P2") != 0) {
        return NULL;
    }

    fscanf(file,"%d %d", w, h);
    if ((*w)<=0) {
        return NULL;
    }
    if ((*h)<=0){
        return NULL;
    }

    float temp;
    fscanf(file, "%f", &temp);

    int length = (*w)*(*h);
    float* img = array_init(length);
    for (int i=0; i<length; i++) {
        int res = fscanf(file, "%f", img + i);
        if (img[i]< 0) {
            array_destroy(img);
            return NULL;
        }
        if (img[i]>255) {
            array_destroy(img);
            return NULL;
        }
        if (res != 1) {
            array_destroy(img);
            return NULL;
        }
    }
    if (fscanf(file, "%f", &temp) == 1) {
        array_destroy(img);
        return NULL;
    }

    fclose(file);

    return img;
}

void write_image_to_file(const float *img, int w, int h, const char *filename) {
    (void)img;
    (void)w;
    (void)h;
    (void)filename;

    // DONE: Implement me!
    FILE* f = fopen(filename, "w");

    int length = w*h;
    // int temp_array[length];

    fprintf(f, "P2\n%d %d\n255\n", w, h);

    for (int i = 0; i<length; i++) {
        // temp_array[i] = (int)img[i];
        // fprintf(f, "%d ", temp_array[i]);
        fprintf(f, "%d ", (int) img[i]);
        if ((i+1)%w == 0) {
            fprintf(f, "\n");
        }
    }

    fclose(f);
}
