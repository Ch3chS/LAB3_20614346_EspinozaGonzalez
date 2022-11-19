package TDAs.Image.Histogram.HistogramLinks;

/**
 * Esta clase corresponde a un eslabón del histograma de una imagen tipo Pixmap
 * @author Sergio Espinoza
 * @version 1.0
 * Se recomienda ver su uso en
 * @see TDAs.Image.Histogram.PixHistogram_20614346_EspinozaGonzalez
 */

public class PixHistogramLink_20614346_EspinozaGonzalez implements HistogramLink_20614346_EspinozaGonzalez{

    /**
     * Los valores r,g y b son enteros entre 0 y 255
     * La cantidad es un valor > 0
     */
    int cantidad, r, g, b;

    /**
     * Método constructor de un eslabón
     */
    public PixHistogramLink_20614346_EspinozaGonzalez(){}

    //Selectores
    /**
     * Método que permite obtener el valor R del color de un eslabón del histograma de una imagen de tipo Pixmap
     * @return R (Valor entre 0 y 255)
     */
    public int getR() {return r;}

    /**
     * Método que permite obtener el valor G del color de un eslabón del histograma de una imagen de tipo Pixmap
     * @return G (Valor entre 0 y 255)
     */
    public int getG() {return g;}

    /**
     * Método que permite obtener el valor B del color de un eslabón del histograma de una imagen de tipo Pixmap
     * @return B (Valor entre 0 y 255)
     */
    public int getB() {return b;}

    /**
     * Método que retorna la cantidad de un eslabón de cualquier histograma
     * @see HistogramLink_20614346_EspinozaGonzalez
     * @return Entero > 0
     */
    public int getCantidad() {return cantidad;}

    /**
     * Método que permite Modificar el valor R del color de un eslabón del histograma de una imagen de tipo Pixmap
     * @param r (Valor entre 0 y 255)
     */
    public void setR(int r) {if(0<=r && r<=255) this.r = r;}

    /**
     * Método que permite Modificar el valor R del color de un eslabón del histograma de una imagen de tipo Pixmap
     * @param g (Valor entre 0 y 255)
     */
    public void setG(int g) {if(0<=g && g<=255) this.g = g;}

    /**
     * Método que permite Modificar el valor R del color de un eslabón del histograma de una imagen de tipo Pixmap
     * @param b (Valor entre 0 y 255)
     */
    public void setB(int b) {if(0<=b && b<=255) this.b = b;}

    /**
     * Método que permite modificar la cantidad de un eslabón de cualquier histograma
     * @param cantidad (> 0)
     */
    public void setCantidad(int cantidad) {if(cantidad>0) this.cantidad = cantidad;}
}
