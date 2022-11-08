package TDAs.Image;

import TDAs.Pixels.Pixel_20614346_EspinozaGonzalez;

public class Image_20614346_EspinozaGonzalez {
    //Atributos
    boolean compressed=false;
    int width, height;

    //Constructor
    public Image_20614346_EspinozaGonzalez(){}

    //Selectores
    public int getWidth() {return width;}
    public int getHeight() {return height;}
    public boolean getCompressed() {return compressed;}


    //Modificadores
    public void setWidth(int width) {this.width = width;}
    public void setHeight(int height) {this.height = height;}
    public void setCompressed(boolean compressed) {this.compressed = compressed;}

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

    public boolean isCompressed(){return getCompressed();}

    public Image_20614346_EspinozaGonzalez flipH(){return this;}

    public Image_20614346_EspinozaGonzalez flipV(){return this;}

    public String imageToString(){
        return "";
    }

}
