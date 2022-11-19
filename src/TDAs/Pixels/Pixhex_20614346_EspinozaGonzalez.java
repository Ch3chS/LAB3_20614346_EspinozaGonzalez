package TDAs.Pixels;

/**
 * Esta subclase define el pixhex como un tipo de pixel con un color de tipo hexadecimal,
 * @author Sergio Espinoza
 * @version 1.0
 * @see TDAs.Pixels.Pixel_20614346_EspinozaGonzalez
 */

public class Pixhex_20614346_EspinozaGonzalez extends Pixel_20614346_EspinozaGonzalez {

    /**
     * El color de tipo hexadecimal a continuación se caracteriza como un string con formato #RRGGBB.
     * Donde R representa el rojo (Red), G el verde (Green) y B el azul (Blue)
     */
    String color;

    /**
     * Constructor de objetos tipo pixhex
     */
    public Pixhex_20614346_EspinozaGonzalez(){}

    /**
     * Método selector que permite obtener el color (hex) del objeto tipo pixhex que hace uso del mismo
     * @return String, de preferencia con el formato establecido para colores hexadecimales
     */
    public String getHex() {return color;}

    /**
     * Método que modifica el hex de un objeto tipo pixhex
     * @param color String, de preferencia con el formato establecido para colores hexadecimales
     */
    public void setHex(String color) {this.color = color;}
}
