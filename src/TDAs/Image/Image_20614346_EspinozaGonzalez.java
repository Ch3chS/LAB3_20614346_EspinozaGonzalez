package TDAs.Image;

import TDAs.Pixels.Pixbit_20614346_EspinozaGonzalez;
import TDAs.Pixels.Pixel_20614346_EspinozaGonzalez;
import TDAs.Pixels.Pixhex_20614346_EspinozaGonzalez;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Image_20614346_EspinozaGonzalez{
    //Atributos
    String mostUsed = ""; //El mostUsed es un valor que se setea al comprimir la imagen y se devuelve a "" al descomprimirla
    List<Integer> depths = new ArrayList<>();  //Esto solo se usara si se comprime una imagen, para guardar las profundidades de los pixeles eliminados

    int width, height;

    //Constructor
    public Image_20614346_EspinozaGonzalez(){}

    //Selectores
    public int getWidth() {return width;}
    public int getHeight() {return height;}
    public String getMostUsed() {return mostUsed;}


    //Modificadores
    public void setWidth(int width) {this.width = width;}
    public void setHeight(int height) {this.height = height;}
    public void setMostUsed(String mostUsed){this.mostUsed = mostUsed;}

    //Otras funciones
    public boolean isBitmap(){
        return this.getClass() == Bitmap_20614346_EspinozaGonzalez.class;
    }

    public boolean isHexmap(){
        return this.getClass() == Hexmap_20614346_EspinozaGonzalez.class;
    }

    public boolean isPixmap(){
        return this.getClass() == Pixmap_20614346_EspinozaGonzalez.class;
    }

    public boolean isCompressed(){
        return !Objects.equals(getMostUsed(), "");
    }

    public Image_20614346_EspinozaGonzalez flipH(){return this;}

    public Image_20614346_EspinozaGonzalez flipV(){return this;}

    public Image_20614346_EspinozaGonzalez crop(int x1, int y1, int x2, int y2){return this;}

    public Hexmap_20614346_EspinozaGonzalez imgRGBToHex(){
        if(this.isPixmap()) {
            Pixmap_20614346_EspinozaGonzalez imgRGB = (Pixmap_20614346_EspinozaGonzalez) this;
            Hexmap_20614346_EspinozaGonzalez imgHex = new Hexmap_20614346_EspinozaGonzalez();
            imgHex.setWidth(imgRGB.getWidth());
            imgHex.setHeight(imgRGB.getHeight());
            imgHex.pixels = new Pixhex_20614346_EspinozaGonzalez[width][height];

            int r, g, b;
            String hex;

            for (int i = 0; i < height; i++) {                //Recorremos la matriz de pixeles
                for (int j = 0; j < width; j++) {                    //Para cada pixel:
                    r = imgRGB.getPixels()[j][i].getR();           //Tomamos los valores r, g , b del pixel
                    g = imgRGB.getPixels()[j][i].getG();
                    b = imgRGB.getPixels()[j][i].getB();
                    hex = String.format("#%02x%02x%02x", r, g, b); //Transformamos a string hexadecimal formato #RRGGBB

                    imgHex.getPixels()[j][i] = new Pixhex_20614346_EspinozaGonzalez();  // inicializamos el pixhex
                    imgHex.getPixels()[j][i].setHex(hex);          //Almacenamos el color en los pixeles de igual posición
                    imgHex.getPixels()[j][i].setDepth(imgRGB.getPixels()[j][i].getDepth());  // Lo mismo con la profundidad
                }
            }
            return imgHex;
        }
        return (Hexmap_20614346_EspinozaGonzalez) this;
    }


    public Image_20614346_EspinozaGonzalez rotate90(){return this;}

    public Image_20614346_EspinozaGonzalez compress(){return this;}

    public String imageToString(){return "";}

    public Image_20614346_EspinozaGonzalez decompress(){return this;}
}
