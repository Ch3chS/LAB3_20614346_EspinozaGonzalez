package TDAs.Image;

import TDAs.Pixels.*;
import java.io.IOException;
import java.util.*;

public class Bitmap_20614346_EspinozaGonzalez extends Image_20614346_EspinozaGonzalez{
    //Atributos
    Pixbit_20614346_EspinozaGonzalez[][] pixels;

    //Constructor
    public Bitmap_20614346_EspinozaGonzalez(){}

    public void initImage(int width, int height) throws IOException {
        Scanner r = new Scanner(System.in);  // Lector
        int valor=0;
        this.setWidth(width);
        this.setHeight(height);
        this.pixels = new Pixbit_20614346_EspinozaGonzalez[width][height];

        for(int i=0; i<height; i++){
            for(int j=0; j<width;j++){
                System.out.println("#### Pixel ("+j+","+i+") #### ");
                getPixels()[j][i] = new Pixbit_20614346_EspinozaGonzalez();
                getPixels()[j][i].setX(j);
                getPixels()[j][i].setY(i);
                System.out.print("Ingrese el bit del pixel: ");
                valor = r.nextInt();
                getPixels()[j][i].setBit(valor);
                System.out.print("Ingrese la profundidad del pixel: ");
                valor = r.nextInt();
                this.pixels[j][i].setDepth(valor);
                System.out.print("\n");
            }
        }
    }

    //selector

    public Pixbit_20614346_EspinozaGonzalez[][] getPixels() {return pixels;}
}
