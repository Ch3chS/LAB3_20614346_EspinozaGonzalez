package TDAs.Image.Histogram;

import TDAs.Image.Bitmap_20614346_EspinozaGonzalez;
import TDAs.Image.Histogram.HistogramLinks.BitHistogramLink_20614346_EspinozaGonzalez;

import java.util.LinkedList;

public class BitHistogram_20614346_EspinozaGonzalez{

    //Atributos
    LinkedList<BitHistogramLink_20614346_EspinozaGonzalez> histogram = new LinkedList<>();

    //Constructor
    public BitHistogram_20614346_EspinozaGonzalez(){}

    //Métodos

    public LinkedList<BitHistogramLink_20614346_EspinozaGonzalez> getHistogram() {return histogram;}

    public boolean isInHistogram(int bit){
        for(BitHistogramLink_20614346_EspinozaGonzalez link: getHistogram()){
            if(bit == link.getBit()) return true;
        }
        return false;
    }

    public int countRepeats(int bit, Bitmap_20614346_EspinozaGonzalez img){
        int count = 0;

        for(int i=0; i<img.getHeight(); i++){
            for(int j=0; j<img.getWidth();j++){
                if(bit == img.getPixels()[j][i].getBit()) count += 1;
            }
        }
        return count;
    }

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

    public String MostUsed(){
        String mostused="";
        int cant = 0;

        for(BitHistogramLink_20614346_EspinozaGonzalez link: histogram){
            if(cant < link.getCantidad()) {
                cant = link.getCantidad();
                mostused = link.getBit() + "";
            }
        }
        return mostused;
    }
}
