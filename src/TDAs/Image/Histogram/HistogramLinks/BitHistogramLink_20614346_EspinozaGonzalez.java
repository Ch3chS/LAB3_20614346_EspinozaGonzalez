package TDAs.Image.Histogram.HistogramLinks;

public class BitHistogramLink_20614346_EspinozaGonzalez {

    //Atributos
    int cantidad, bit;

    //Metodos
    public BitHistogramLink_20614346_EspinozaGonzalez(){}

    public int getBit() {return bit;}

    public int getCantidad() {return cantidad;}

    public void setBit(int bit) {if(bit==0 || bit==1) this.bit = bit;}

    public void setCantidad(int cantidad) {if(cantidad>0) this.cantidad = cantidad;}
}
