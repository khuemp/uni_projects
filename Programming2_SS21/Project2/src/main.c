#include <stdio.h>
#include <stdlib.h>

#include "argparser.h"
#include "convolution.h"
#include "derivation.h"
#include "gaussian_kernel.h"
#include "image.h"

int main(int const argc, char **const argv) {
    /**
    * Parse arguments. The parsed image file name and threshold are available
    * in the image_file_name and threshold global variables (see argparser.h).
    */
    parse_arguments(argc, argv);
    printf("Computing edges for image file %s with threshold %i\n",
            image_file_name, threshold);

    /**
    * Read Image from given file.
    *
    * If the input file is broken terminate with return value 1.
    *
    * Hint: The width and height of the image have to be accessible in the
    * scope of this function.
    */
    // DONE: Implement me!
    int w;
    int h;
    float *img = read_image_from_file(image_file_name, &w, &h);
    if (img == NULL) {
        return 1;
    }

    /**
    * Blur the image by using convolve with the given Gaussian kernel matrix
    * gaussian_k (defined in gaussian_kernel.h). The width of the matrix is
    * gaussian_w, the height is gaussian_h.
    *
    * Afterwards, rescale the resulting blurred image and write the rescaled
    * result to the file out_blur.pgm.
    */
    // DONE: Implement me!
    float* blur_result = array_init(w*h);
    convolve(blur_result, img, w, h, gaussian_k, gaussian_w, gaussian_h);
    write_image_to_file(blur_result, w, h, "out_blur.pgm");

    /**
    * Compute the derivation of the (unscaled!) blurred image computed above
    * in both x and y direction.
    *
    * Afterwards, rescale both results and write them to the files out_d_x.pgm
    * and out_d_y.pgm respectively.
    */
    // DONE: Implement me!
    float* x_direction = array_init(w*h);
    float* y_direction = array_init(w*h);
    derivation_x_direction(x_direction, blur_result, w, h);
    derivation_y_direction(y_direction, blur_result, w, h);

    float* x_direction_scale = array_init(w*h);
    float* y_direction_scale = array_init(w*h);
    scale_image(x_direction_scale, x_direction, w, h);
    scale_image(y_direction_scale, y_direction, w, h);
    write_image_to_file(x_direction_scale, w, h, "out_d_x.pgm");
    write_image_to_file(y_direction_scale, w, h, "out_d_y.pgm");

    /**
    * Compute the gradient magnitude of the blurred image by using the
    * (unscaled!) derivations in x- and y-direction computed earlier.
    *
    * Afterwards, rescale the result and write it to out_gm.pgm.
    */
    // DONE: Implement me!
    float* gradient = array_init(w*h);
    gradient_magnitude(gradient, x_direction, y_direction, w, h);

    float* gradient_scale = array_init(w*h);
    scale_image(gradient_scale, gradient, w, h);
    write_image_to_file(gradient_scale, w, h, "out_gm.pgm");
    /**
    * Apply the threshold to the gradient magnitude.
    * Then write the result to the file out_edges.pgm.
    */
    // DONE: Implement me!
    apply_threshold(gradient, w, h, threshold);
    write_image_to_file(gradient, w, h, "out_edges.pgm");
    /**
    * Remember to free dynamically allocated memory when it is no longer used!
    */

    array_destroy(img);
    array_destroy(blur_result);
    array_destroy(x_direction);
    array_destroy(y_direction);
    array_destroy(x_direction_scale);
    array_destroy(y_direction_scale);
    array_destroy(gradient);
    array_destroy(gradient_scale);

    return 0;
}
