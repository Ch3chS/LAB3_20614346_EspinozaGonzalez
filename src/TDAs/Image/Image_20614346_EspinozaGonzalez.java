package TDAs.Image;

import TDAs.Pixels.Pixhex_20614346_EspinozaGonzalez;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Esta superclase define la imagen como algo con ancho y alto, además de tener un color más usado y una lista de
 * profundidades en caso de comprimirse, para, de esta forma, no perder dichos datos.
 * @author Sergio Espinoza
 * @version 1.0
 */

public class Image_20614346_EspinozaGonzalez{

    /**
     * Todas las imágenes tienen como atributos principales el ancho y el alto, los cuales se usarán siempre.
     * Los atributos mostUsed y depths son usados solamente a la hora de comprimir y descomprimir imágenes
     * para no perder información
     */
    int width, height;
    String mostUsed = ""; //El mostUsed es un valor que se setea al comprimir la imagen y se devuelve a "" al descomprimirla
    List<Integer> depths = new ArrayList<>();  //Esto solo se usara si se comprime una imagen, para guardar las profundidades de los pixeles eliminados


    /**
     * Constructor genérico de imagen, ya que solo se inicializa desde sus subclases
     */
    public Image_20614346_EspinozaGonzalez(){}

    //Selectores
    /**
     * Método para obtener el ancho de una imagen de cualquier tipo
     * @return Ancho (Entero)
     */
    public int getWidth() {return width;}

    /**
     * Método para obtener el alto de una imagen de cualquier tipo
     * @return Alto (Entero)
     */
    public int getHeight() {return height;}

    /**
     * Método para obtener el color más usado de una imagen de cualquier tipo
     * @return mostUsed (String)
     */
    public String getMostUsed() {return mostUsed;}

    //Modificadores
    /**
     * Método que permite modificar el ancho de cualquier tipo de imagen
     * @param width Entero > 0
     */
    public void setWidth(int width) {if(width>0) this.width = width;}

    /**
     * Método que permite modificar el alto de cualquier tipo de imagen
     * @param height Entero > 0
     */
    public void setHeight(int height) {if(height>0) this.height = height;}

    /**
     * Método que permite modificar el atributo de color más usado de cualquier tipo de imagen
     * @param mostUsed String
     */
    public void setMostUsed(String mostUsed){this.mostUsed = mostUsed;}

    /**
     * Método que permite saber si la imagen es un Bitmap
     * @return Booleano (True si lo es, False si no)
     */
    public boolean isBitmap(){
        return this.getClass() == Bitmap_20614346_EspinozaGonzalez.class;
    }

    /**
     * Método que permite saber si la imagen es un Hexmap
     * @return Booleano (True si lo es, False si no)
     */
    public boolean isHexmap(){
        return this.getClass() == Hexmap_20614346_EspinozaGonzalez.class;
    }

    /**
     * Método que permite saber si la imagen es un Pixmap
     * @return Booleano (True si lo es, False si no)
     */
    public boolean isPixmap(){
        return this.getClass() == Pixmap_20614346_EspinozaGonzalez.class;
    }

    /**
     * Método que permite saber si la imagen está comprimida
     * @return Booleano (True si lo está, False si no)
     */
    public boolean isCompressed(){
        return !Objects.equals(getMostUsed(), "");
    }

    /**
     * Versión genérica para ser sobreescrita por las subclases
     * @return Imagen
     */
    public Image_20614346_EspinozaGonzalez flipH(){return this;}

    /**
     * Versión genérica para ser sobreescrita por las subclases
     * @return Imagen
     */
    public Image_20614346_EspinozaGonzalez flipV(){return this;}

    /**
     * Versión genérica para ser sobreescrita por las subclases
     * @param x1 X desde la que se desea recortar
     * @param y1 Y desde la que se desea recortar
     * @param x2 X hasta la cual se desea recortar (Debe ser >= x1)
     * @param y2 Y hasta la cual se desea recortar (Debe ser >= y1)
     * @return Imagen recortada
     */
    public Image_20614346_EspinozaGonzalez crop(int x1, int y1, int x2, int y2){return this;}

    /**
     * Convierte una imagen de tipo Pixmap a una de tipo Hexmap
     * @return Hexmap
     */
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

    /**
     * Versión genérica para ser sobreescrita por las subclases
     * @return Imagen
     */
    public Image_20614346_EspinozaGonzalez rotate90(){return this;}

    /**
     * Versión genérica para ser sobreescrita por las subclases
     * @return Imagen
     */
    public Image_20614346_EspinozaGonzalez compress(){return this;}

    /**
     * Versión genérica para ser sobreescrita por las subclases
     * @return Imagen
     */
    public String imageToString(){return "";}

    /**
     * Versión genérica para ser sobreescrita por las subclases
     * @return Imagen
     */
    public Image_20614346_EspinozaGonzalez decompress(){return this;}
}
