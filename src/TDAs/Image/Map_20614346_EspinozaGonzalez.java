package TDAs.Image;

import TDAs.Pixels.Pixel_20614346_EspinozaGonzalez;

public interface Map_20614346_EspinozaGonzalez {
    void initImage(int width, int height);
    Pixel_20614346_EspinozaGonzalez[][] getPixels();

    Image_20614346_EspinozaGonzalez flipH();

    Image_20614346_EspinozaGonzalez flipV();

    //Image_20614346_EspinozaGonzalez changePixel(Pixel_20614346_EspinozaGonzalez pixel);

    //Image_20614346_EspinozaGonzalez depthLayers();

    String imageToString();
}
