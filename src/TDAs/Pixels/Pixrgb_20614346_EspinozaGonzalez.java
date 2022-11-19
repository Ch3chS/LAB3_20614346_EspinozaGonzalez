package TDAs.Pixels;

/**
 * Esta subclase define el pixrgb como un tipo de pixel con un color de rgb,
 * @author Sergio Espinoza
 * @version 1.0
 * @see TDAs.Pixels.Pixel_20614346_EspinozaGonzalez
 */

public class Pixrgb_20614346_EspinozaGonzalez extends Pixel_20614346_EspinozaGonzalez{

    /**
     * El color de tipo rgb a continuación se caracteriza por que cada uno de estos (r,g,b) toma valores entre 0 y 255.
     * siendo la R el rojo del color (Red), la G el verde del color (G) y B el azul del color (Blue)
     */
    int r,g,b;

    /**
     * Constructor de objetos tipo pixhex
     */
    public Pixrgb_20614346_EspinozaGonzalez(){}

    //Selectores

    /**
     * Método selector del Rojo del pixrgb (R)
     * @return Entero entre 0 y 255
     */
    public int getR() {return r;}

    /**
     * Método selector del Verde del pixrgb (G)
     * @return Entero entre 0 y 255
     */
    public int getG(){return g;}

    /**
     * Método selector del Azul del pixrgb (B)
     * @return Entero entre 0 y 255
     */
    public int getB() {return b;}

    //Modificadores
    /**
     * Método modificador del Rojo del color (R)
     * @param r Entero entre 0 y 255
     */
    public void setR(int r) {if(0<=r && r<=255) this.r = r;}

    /**
     * Método modificador del Verde del color (G)
     * @param g Entero entre 0 y 255
     */
    public void setG(int g) {if(0<=g && g<=255) this.g = g;}

    /**
     * Método modificador del Azul del color (B)
     * @param b Entero entre 0 y 255
     */
    public void setB(int b) {if(0<=b && b<=255) this.b = b;}

    //Otras Funciones

    /**
     * Método que modifica los diferente canales de color de un pixrgb al simétricamente opuesto
     */
    public void invertColorRGB(){
        setR(255-getR());
        setG(255-getG());
        setB(255-getB());
    }

    /**
     * Método que se encarga de transformar el color rgb de un pixrgb a una cadena de texto
     * @return String con el color actual del objeto formato "(R, G, B)"
     */
    public String rgbToString(){
        return "(" + getR() + ", " + getG() + ", " + getB() + ")";
    }
}
