package TDAs.Image.Histogram;

import TDAs.Image.Hexmap_20614346_EspinozaGonzalez;
import TDAs.Image.Histogram.HistogramLinks.HexHistogramLink_20614346_EspinozaGonzalez;

import java.util.LinkedList;
import java.util.Objects;

public class HexHistogram_20614346_EspinozaGonzalez{
    //Atributos
    LinkedList<HexHistogramLink_20614346_EspinozaGonzalez> histogram = new LinkedList<>();

    //Constructor
    public HexHistogram_20614346_EspinozaGonzalez(){}

    //Métodos

    public LinkedList<HexHistogramLink_20614346_EspinozaGonzalez> getHistogram() {return histogram;}

    public boolean isInHistogram(String hex){
        for(HexHistogramLink_20614346_EspinozaGonzalez link: getHistogram()){
            if(Objects.equals(hex, link.getHex())) return true;
        }
        return false;
    }

    public int countRepeats(String hex, Hexmap_20614346_EspinozaGonzalez img){
        int count = 0;

        for(int i=0; i<img.getHeight(); i++){
            for(int j=0; j<img.getWidth();j++){
                if(Objects.equals(hex, img.getPixels()[j][i].getHex())) count += 1;
            }
        }
        return count;
    }

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
