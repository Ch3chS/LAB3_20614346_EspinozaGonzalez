package TDAs.Image;

import TDAs.Pixels.Pixbit_20614346_EspinozaGonzalez;
import TDAs.Pixels.Pixel_20614346_EspinozaGonzalez;
import TDAs.Pixels.Pixrgb_20614346_EspinozaGonzalez;

public interface Map_20614346_EspinozaGonzalez {
    void initImage(int width, int height);
    Pixel_20614346_EspinozaGonzalez[][] getPixels();

    Image_20614346_EspinozaGonzalez flipH();

    Image_20614346_EspinozaGonzalez flipV();

    Image_20614346_EspinozaGonzalez crop(int x1, int y1, int x2, int y2);

    Image_20614346_EspinozaGonzalez rotate90();

    //Image_20614346_EspinozaGonzalez changePixel(Pixel_20614346_EspinozaGonzalez pixel);

    //Image_20614346_EspinozaGonzalez depthLayers();



    String imageToString();

    int getWidth();

    int getHeight();

    default int maxDepth(){   //Todos los tipo map usan este método para depthLayers
        int max = 0;

        for(int i=0; i<getHeight(); i++){
            for(int j=0; j<getWidth();j++) {
                if(max < getPixels()[j][i].getDepth()) max = getPixels()[j][i].getDepth();
            }
        }

        return max;
    }
}
