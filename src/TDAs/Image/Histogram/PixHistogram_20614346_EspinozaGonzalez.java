package TDAs.Image.Histogram;

import TDAs.Image.Histogram.HistogramLinks.PixHistogramLink_20614346_EspinozaGonzalez;
import TDAs.Image.Pixmap_20614346_EspinozaGonzalez;
import java.util.LinkedList;

/**
 * Esta clase corresponde al histograma de una imagen de tipo Pixmap
 * @author Sergio Espinoza
 * @version 1.0
 * @see TDAs.Image.Histogram.Histogram_20614346_EspinozaGonzalez
 */

public class PixHistogram_20614346_EspinozaGonzalez implements Histogram_20614346_EspinozaGonzalez{

    /**
     * El único atributo es una lista enlazada de eslabones tipo PixHistogramLink
     * @see PixHistogramLink_20614346_EspinozaGonzalez
     */
    LinkedList<PixHistogramLink_20614346_EspinozaGonzalez> histogram = new LinkedList<>();

    /**
     * Constructor de objeto tipo PixHistogram
     */
    public PixHistogram_20614346_EspinozaGonzalez(){}

    /**
     * Método que permite obtener la lista enlazada con los eslabones
     * @return histograma como tal
     */
    public LinkedList<PixHistogramLink_20614346_EspinozaGonzalez> getHistogram() {return histogram;}

    /**
     * Método que permite revisar si un color rgb en específico ya se encuentra contado en el histograma
     * @param r R a revisar en conjunto
     * @param g G a revisar en conjunto
     * @param b B a revisar en conjunto
     * @return Booleano (True si ya se encuentra, False si no se encuentra)
     */
    public boolean isInHistogram(int r, int g, int b){
        for(PixHistogramLink_20614346_EspinozaGonzalez link: getHistogram()){
            if(r == link.getR() && g == link.getG() && b == link.getB()) return true;
        }
        return false;
    }

    /**
     * Método que permite contar la cantidad de veces que se repite un color rgb en una imagen
     * @param r R a contar en conjunto
     * @param g G a contar en conjunto
     * @param b B a contar en conjunto
     * @param img Imagen en la que se desea saber la cantidad
     * @return Número de veces que se repite
     */
    public int countRepeats(int r, int g, int b, Pixmap_20614346_EspinozaGonzalez img){
        int count = 0;

        for(int i=0; i<img.getHeight(); i++){
            for(int j=0; j<img.getWidth();j++){
                if(r == img.getPixels()[j][i].getR() && g == img.getPixels()[j][i].getG() && b == img.getPixels()[j][i].getB())
                    count += 1;
            }
        }
        return count;
    }

    /**
     * Método inicializador del histograma una vez fue creado
     * @param img Pixmap desde el que se inicializó
     * @return PixHistogram inicializado
     */
    public PixHistogram_20614346_EspinozaGonzalez histogramInit(Pixmap_20614346_EspinozaGonzalez img) {
        PixHistogram_20614346_EspinozaGonzalez histogram = new PixHistogram_20614346_EspinozaGonzalez();

        for(int i=0; i<img.getHeight(); i++){
            for(int j=0; j<img.getWidth();j++){
                if(!histogram.isInHistogram(img.getPixels()[j][i].getR(),img.getPixels()[j][i].getG(),img.getPixels()[j][i].getB())){  //Si el color aun no se agrega
                    PixHistogramLink_20614346_EspinozaGonzalez temp = new PixHistogramLink_20614346_EspinozaGonzalez();
                    temp.setR(img.getPixels()[j][i].getR());
                    temp.setG(img.getPixels()[j][i].getG());
                    temp.setB(img.getPixels()[j][i].getB());
                    temp.setCantidad(countRepeats(temp.getR(), temp.getG(), temp.getB(), img));

                    histogram.histogram.add(temp);
                }
            }
        }

        return histogram;
    }

    /**
     * Implementación del método de la interfaz para el histogram de una imagen tipo Pixmap
     * @see Histogram_20614346_EspinozaGonzalez
     * @return String con el color rgb más usado convertido a un formato "R G B"
     */
    @Override
    public String MostUsed(){
        String mostused="";
        int cant = 0;

        for(PixHistogramLink_20614346_EspinozaGonzalez link: histogram){
            if(cant < link.getCantidad()) {
                cant = link.getCantidad();
                mostused = link.getR() + " " + link.getG() + " " + link.getB();
            }
        }
        return mostused;
    }
}
