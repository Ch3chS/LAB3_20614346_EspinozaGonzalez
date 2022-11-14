package TDAs.Image.Histogram;

import TDAs.Image.Histogram.HistogramLinks.PixHistogramLink_20614346_EspinozaGonzalez;
import TDAs.Image.Pixmap_20614346_EspinozaGonzalez;

import java.util.LinkedList;

public class PixHistogram_20614346_EspinozaGonzalez{

    //Atributos
    LinkedList<PixHistogramLink_20614346_EspinozaGonzalez> histogram = new LinkedList<>();

    //Constructor
    public PixHistogram_20614346_EspinozaGonzalez(){}

    //Métodos
    public LinkedList<PixHistogramLink_20614346_EspinozaGonzalez> getHistogram() {return histogram;}

    public boolean isInHistogram(int r, int g, int b){
        for(PixHistogramLink_20614346_EspinozaGonzalez link: getHistogram()){
            if(r == link.getR() && g == link.getG() && b == link.getB()) return true;
        }
        return false;
    }

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

    public String MostUsed(){
        String mostused="";
        int cant = 0;

        for(PixHistogramLink_20614346_EspinozaGonzalez link: histogram){
            if(cant < link.getCantidad()) {
                cant = link.getCantidad();
                mostused = "(" + link.getR() + ", " + link.getG() + ", " + link.getB() + ")";
            }
        }
        return mostused;
    }
}
