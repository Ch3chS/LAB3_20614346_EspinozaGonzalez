package TDAs.Image.Histogram;

import TDAs.Image.Hexmap_20614346_EspinozaGonzalez;
import TDAs.Image.Histogram.HistogramLinks.HexHistogramLink_20614346_EspinozaGonzalez;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Esta clase corresponde al histograma de una imagen de tipo Hexmap
 * @author Sergio Espinoza
 * @version 1.0
 * @see TDAs.Image.Histogram.Histogram_20614346_EspinozaGonzalez
 */

public class HexHistogram_20614346_EspinozaGonzalez implements Histogram_20614346_EspinozaGonzalez{

    /**
     * El único atributo es una lista enlazada de eslabones tipo HexHistogramLink
     * @see HexHistogramLink_20614346_EspinozaGonzalez
     */
    LinkedList<HexHistogramLink_20614346_EspinozaGonzalez> histogram = new LinkedList<>();

    /**
     * Constructor de objeto tipo HexHistogram
     */
    public HexHistogram_20614346_EspinozaGonzalez(){}

    /**
     * Método que permite obtener la lista enlazada con los eslabones
     * @return histograma como tal
     */
    public LinkedList<HexHistogramLink_20614346_EspinozaGonzalez> getHistogram() {return histogram;}

    /**
     * Método que permite revisar si un color hexadecimal en específico ya se encuentra contado en el histograma
     * @param hex Color hexadecimal a revisar
     * @return Booleano (True si ya se encuentra, False si no se encuentra)
     */
    public boolean isInHistogram(String hex){
        for(HexHistogramLink_20614346_EspinozaGonzalez link: getHistogram()){
            if(Objects.equals(hex, link.getHex())) return true;
        }
        return false;
    }

    /**
     * Método que permite contar la cantidad de veces que se repite un color hexadecimal en una imagen
     * @param hex Hex a contar
     * @param img Imagen en la que se desea saber la cantidad
     * @return Número de veces que se repite
     */
    public int countRepeats(String hex, Hexmap_20614346_EspinozaGonzalez img){
        int count = 0;

        for(int i=0; i<img.getHeight(); i++){
            for(int j=0; j<img.getWidth();j++){
                if(Objects.equals(hex, img.getPixels()[j][i].getHex())) count += 1;
            }
        }
        return count;
    }

    /**
     * Método inicializador del histograma una vez fue creado
     * @param img Hexmap desde el que se inicializó
     * @return HexHistogram inicializado
     */
    public HexHistogram_20614346_EspinozaGonzalez histogramInit(Hexmap_20614346_EspinozaGonzalez img) {
        HexHistogram_20614346_EspinozaGonzalez histogram = new HexHistogram_20614346_EspinozaGonzalez();

        for(int i=0; i<img.getHeight(); i++){
            for(int j=0; j<img.getWidth();j++){
                if(!histogram.isInHistogram(img.getPixels()[j][i].getHex())){  //Si el color aun no se agrega
                    HexHistogramLink_20614346_EspinozaGonzalez temp = new HexHistogramLink_20614346_EspinozaGonzalez();
                    temp.setHex(img.getPixels()[j][i].getHex());
                    temp.setCantidad(countRepeats(temp.getHex(), img));

                    histogram.histogram.add(temp);
                }
            }
        }

        return histogram;
    }

    /**
     * Implementación del método de la interfaz para el histogram de una imagen tipo Hexmap
     * @see Histogram_20614346_EspinozaGonzalez
     * @return Color hexadecimal más usado
     */
    @Override
    public String MostUsed(){
        String mostused="";
        int cant = 0;

        for(HexHistogramLink_20614346_EspinozaGonzalez link: histogram){
            if(cant < link.getCantidad()) {
                cant = link.getCantidad();
                mostused = link.getHex();
            }
        }
        return mostused;
    }
}
