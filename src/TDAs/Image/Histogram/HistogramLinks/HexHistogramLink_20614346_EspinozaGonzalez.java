package TDAs.Image.Histogram.HistogramLinks;

/**
 * Esta clase corresponde a un eslabón del histograma de una imagen tipo Hex
 * @author Sergio Espinoza
 * @version 1.0
 * Se recomienda ver su uso en
 * @see TDAs.Image.Histogram.HexHistogram_20614346_EspinozaGonzalez
 */

public class HexHistogramLink_20614346_EspinozaGonzalez implements HistogramLink_20614346_EspinozaGonzalez{

    /**
     * El String hex corresponde a un color hexadecimal de formato #RRGGBB
     * La cantidad es un valor > 0
     */
    int cantidad;
    String hex;

    /**
     * Método constructor de un eslabón
     */
    public HexHistogramLink_20614346_EspinozaGonzalez(){}

    //Selectores
    /**
     * Método que permite obtener el color de un eslabón de histograma de una imagen tipo Hexmap
     * @return Color hexadecimal formato #RRGGBB
     */
    public String getHex() {return hex;}

    /**
     * Método que retorna la cantidad de un eslabón de cualquier histograma
     * @see HistogramLink_20614346_EspinozaGonzalez
     * @return Entero > 0
     */
    public int getCantidad() {return cantidad;}

    //Modificadores
    /**
     * Método que permite modificar el color de un eslabón de histograma de una imagen tipo hexmap
     * @param hex color hexadecimal formato #RRGGBB
     */
    public void setHex(String hex) {this.hex = hex;}

    /**
     * Método que permite modificar la cantidad de un eslabón de cualquier histograma
     * @param cantidad (> 0)
     */
    public void setCantidad(int cantidad) {if(cantidad>0) this.cantidad = cantidad;}
}
