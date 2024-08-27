#include "convolution.h"

#include <stdio.h>
#include <stdlib.h>

#include "image.h"

void convolve(float *result, const float *img, int w, int h,
              const float *matrix, int w_m, int h_m) {
    (void)result;
    (void)img;
    (void)w;
    (void)h;
    (void)matrix;
    (void)w_m;
    (void)h_m;

    // DONE: Implement me!
    int a = w_m/2;
    int b = h_m/2;
    for (int x = 0; x < w; x++) {
        for (int y = 0; y < h; y++) {
            float sum = 0;
            for (int i = 0; i < w_m; i++) {
                for (int j = 0; j < h_m; j++) {
                    sum = sum + matrix[i+w_m*j]*get_pixel_value(img,w,h,x+i-a,y+j-b);
                }
            }
            result[x+w*y] = sum;
        }
    }
}
