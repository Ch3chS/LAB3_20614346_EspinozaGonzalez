package TDAs.Image.Histogram;

import TDAs.Image.Bitmap_20614346_EspinozaGonzalez;
import TDAs.Image.Histogram.HistogramLinks.BitHistogramLink_20614346_EspinozaGonzalez;
import java.util.LinkedList;

/**
 * Esta clase corresponde al histograma de una imagen de tipo Bitmap
 * @author Sergio Espinoza
 * @version 1.0
 * @see TDAs.Image.Histogram.Histogram_20614346_EspinozaGonzalez
 */

public class BitHistogram_20614346_EspinozaGonzalez implements Histogram_20614346_EspinozaGonzalez{

    /**
     * El único atributo es una lista enlazada de eslabones tipo BitHistogramLink
     * @see BitHistogramLink_20614346_EspinozaGonzalez
     */
    LinkedList<BitHistogramLink_20614346_EspinozaGonzalez> histogram = new LinkedList<>();

    /**
     * Constructor de objeto tipo BitHistogram
     */
    public BitHistogram_20614346_EspinozaGonzalez(){}

    /**
     * Método que permite obtener la lista enlazada con los eslabones
     * @return histograma como tal
     */
    public LinkedList<BitHistogramLink_20614346_EspinozaGonzalez> getHistogram() {return histogram;}

    /**
     * Método que permite revisar si un bit en específico ya se encuentra contado en el histograma
     * @param bit Bit a revisar
     * @return Booleano (True si ya se encuentra, False si no se encuentra)
     */
    public boolean isInHistogram(int bit){
        for(BitHistogramLink_20614346_EspinozaGonzalez link: getHistogram()){
            if(bit == link.getBit()) return true;
        }
        return false;
    }

    /**
     * Método que permite contar la cantidad de veces que se repite un bit en una imagen
     * @param bit Bit a contar
     * @param img Imagen en la que se desea saber la cantidad
     * @return Número de veces que se repite
     */
    public int countRepeats(int bit, Bitmap_20614346_EspinozaGonzalez img){
        int count = 0;

        for(int i=0; i<img.getHeight(); i++){
            for(int j=0; j<img.getWidth();j++){
                if(bit == img.getPixels()[j][i].getBit()) count += 1;
            }
        }
        return count;
    }

    /**
     * Método inicializador del histograma una vez fue creado
     * @param img Bitmap desde el que se inicializó
     * @return BitHistogram inicializado
     */
    public BitHistogram_20614346_EspinozaGonzalez histogramInit(Bitmap_20614346_EspinozaGonzalez img) {
        BitHistogram_20614346_EspinozaGonzalez histogram = new BitHistogram_20614346_EspinozaGonzalez();

        for(int i=0; i<img.getHeight(); i++){
            for(int j=0; j<img.getWidth();j++){
                if(!histogram.isInHistogram(img.getPixels()[j][i].getBit())){  //Si el color aun no se agrega
                    BitHistogramLink_20614346_EspinozaGonzalez temp = new BitHistogramLink_20614346_EspinozaGonzalez();
                    temp.setBit(img.getPixels()[j][i].getBit());
                    temp.setCantidad(countRepeats(temp.getBit(), img));

                    histogram.histogram.add(temp);
                }
            }
        }

        return histogram;
    }

    /**
     * Implementación del método de la interfaz para el histogram de una imagen tipo Bitmap
     * @see Histogram_20614346_EspinozaGonzalez
     * @return String con el bit más usado convertido
     */
    @Override
    public String MostUsed(){
        String mostUsed="";
        int cant = 0;

        for(BitHistogramLink_20614346_EspinozaGonzalez link: histogram){
            if(cant < link.getCantidad()) {
                cant = link.getCantidad();
                mostUsed = link.getBit() + "";
            }
        }
        return mostUsed;
    }
}
