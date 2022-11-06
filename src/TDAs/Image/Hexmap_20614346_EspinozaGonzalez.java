package TDAs.Image;

import TDAs.Pixels.Pixhex_20614346_EspinozaGonzalez;

import java.io.IOException;
import java.util.Scanner;

public class Hexmap_20614346_EspinozaGonzalez extends Image_20614346_EspinozaGonzalez{

    //Atributos
    Pixhex_20614346_EspinozaGonzalez[][] pixels;

    //Constructor
    public Hexmap_20614346_EspinozaGonzalez(){}

    public void initImage(int width, int height) throws IOException {
        Scanner r = new Scanner(System.in);  // Lector
        int valor=0;
        String hex;
        setWidth(width);
        setHeight(height);
        this.pixels = new Pixhex_20614346_EspinozaGonzalez[width][height];

        for(int i=0; i<height; i++){
            for(int j=0; j<width;j++){
                System.out.println("#### Pixel ("+j+","+i+") #### ");
                getPixels()[j][i] = new Pixhex_20614346_EspinozaGonzalez();
                getPixels()[j][i].setX(j);
                getPixels()[j][i].setY(i);
                System.out.print("Ingrese el color del pixel(formato: #RRGGBB): ");
                hex = r.nextLine();
                getPixels()[j][i].setHex(hex);
                System.out.print("Ingrese la profundidad del pixel: ");
                valor = r.nextInt();
                r.nextLine();
                getPixels()[j][i].setDepth(valor);
                System.out.print("\n");
            }
        }
    }

    //Selector
    public Pixhex_20614346_EspinozaGonzalez[][] getPixels() {return pixels;}
}