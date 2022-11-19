package TDAs.Image.Histogram.HistogramLinks;

/**
 * Esta clase corresponde a un eslabón del histograma de una imagen tipo Bitmap
 * @author Sergio Espinoza
 * @version 1.0
 * Se recomienda ver su uso en
 * @see TDAs.Image.Histogram.BitHistogram_20614346_EspinozaGonzalez
 */

public class BitHistogramLink_20614346_EspinozaGonzalez implements HistogramLink_20614346_EspinozaGonzalez{

    /**
     * El bit corresponde a un valor que puede ser 0 o 1
     * La cantidad es un valor > 0
     */
    int cantidad, bit;

    /**
     * Método constructor de un eslabón
     */
    public BitHistogramLink_20614346_EspinozaGonzalez(){}

    //Selectores
    /**
     * Método que retorna el valor bit del eslabón bit
     * @return bit (Entero con valores 0 o 1)
     */
    public int getBit() {return bit;}

    /**
     * Método que retorna la cantidad de un eslabón de cualquier histograma
     * @see HistogramLink_20614346_EspinozaGonzalez
     * @return Entero > 0
     */
    public int getCantidad() {return cantidad;}

    /**
     * Método que permite modificar el bit de un eslabón de bitHistogram
     * @param bit (0 o 1)
     */
    public void setBit(int bit) {if(bit==0 || bit==1) this.bit = bit;}

    /**
     * Método que permite modificar la cantidad de un eslabón de cualquier histograma
     * @param cantidad (> 0)
     */
    public void setCantidad(int cantidad) {if(cantidad>0) this.cantidad = cantidad;}
}
