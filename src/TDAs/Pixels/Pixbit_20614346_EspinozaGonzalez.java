package TDAs.Pixels;

/**
 * Esta subclase define el pixbit como un tipo de pixel con un color de tipo bit,
 * @author Sergio Espinoza
 * @version 1.0
 * @see TDAs.Pixels.Pixel_20614346_EspinozaGonzalez
 */

public class Pixbit_20614346_EspinozaGonzalez extends Pixel_20614346_EspinozaGonzalez{

    /**
     * El color de tipo bit a continuación se caracteriza por tomar solo los valores de 0 o 1.
     */
    int color;

    /**
     * Constructor de objetos tipo pixbit
     */
    public Pixbit_20614346_EspinozaGonzalez(){}

    /**
     * Método selector que permite obtener el color (bit) del objeto tipo pixbit que hace uso del mismo
     * @return Bit (entero con valor 0 o 1)
     */
    public int getBit(){return color;}

    /**
     * Método que modifica el bit de un objeto tipo pixbit
     * @param newColor (Debe ser un bit (0 o 1))
     */
    public void setBit(int newColor) {
        if(color==0 | color==1){
        this.color = newColor;
        }
    }

    // Otras funciones
    /**
     * Método que modifica el bit del objeto al opuesto (0 -> 1  o  1 -> 0)
     */
    public void invertColorBit(){
        setBit(1-getBit());
    }

    /**
     * Método que se encarga de transformar el bit de un pixbit a una cadena de texto
     * @return String con el bit actual del objeto
     */
    public String bitToString() {
        return getBit()+"";
    }
}
