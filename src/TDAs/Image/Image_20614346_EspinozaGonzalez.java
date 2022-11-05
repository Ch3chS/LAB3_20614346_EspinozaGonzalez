package TDAs.Image;

public class Image_20614346_EspinozaGonzalez {
    //Atributos
    int width, height;

    //Constructor
    public Image_20614346_EspinozaGonzalez(){}

    //Selectores
    public int getWidth() {return width;}
    public int getHeight() {return height;}

    //Modificadores
    public void setWidth(int width) {this.width = width;}
    public void setHeight(int height) {this.height = height;}

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
}
