package TDAs.Image;

import TDAs.Pixels.Pixrgb_20614346_EspinozaGonzalez;
import java.util.Scanner;

public class Pixmap_20614346_EspinozaGonzalez extends Image_20614346_EspinozaGonzalez{

    //Atributos
    Pixrgb_20614346_EspinozaGonzalez[][] pixels;

    //Constructor
    public Pixmap_20614346_EspinozaGonzalez(){}

    public void initImage(int width, int height){
        Scanner r = new Scanner(System.in);  // Lector
        int valor;
        setWidth(width);
        setHeight(height);
        this.pixels = new Pixrgb_20614346_EspinozaGonzalez[width][height];

        for(int i=0; i<height; i++){
            for(int j=0; j<width;j++){
                System.out.println("#### Pixel ("+j+","+i+") #### ");
                getPixels()[j][i] = new Pixrgb_20614346_EspinozaGonzalez();
                getPixels()[j][i].setX(j);
                getPixels()[j][i].setY(i);
                System.out.print("Ingrese la cantidad de rojo del pixel (0 <= r <= 255): ");
                valor = r.nextInt();
                getPixels()[j][i].setR(valor);
                System.out.print("Ingrese la cantidad de verde del pixel (0 <= g <= 255): ");
                valor = r.nextInt();
                getPixels()[j][i].setG(valor);
                System.out.print("Ingrese la cantidad de azul del pixel (0 <= b <= 255): ");
                valor = r.nextInt();
                getPixels()[j][i].setB(valor);
                System.out.print("Ingrese la profundidad del pixel: ");
                valor = r.nextInt();
                getPixels()[j][i].setDepth(valor);
                System.out.print("\n");
            }
        }
    }

    //selector
    public Pixrgb_20614346_EspinozaGonzalez[][] getPixels() {return pixels;}

    @Override
    public String imageToString(){
        if (compressed) return "La imagen se encuentra comprimida, por favor descomprimirla para poder visualizarla";
        StringBuilder string= new StringBuilder();
        for(int i=0; i<height; i++){
            for(int j=0; j<width;j++) {
                string.append(getPixels()[j][i].rgbToString()).append("\t");
            }
            string.append("\n");
        }

        return string.toString();
    }
}
