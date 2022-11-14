package TDAs.Image.Histogram.HistogramLinks;

public class PixHistogramLink_20614346_EspinozaGonzalez{

    //Atributos
    int cantidad, r, g, b;

    //Metodos
    public PixHistogramLink_20614346_EspinozaGonzalez(){}

    public int getR() {return r;}

    public int getG() {return g;}

    public int getB() {return b;}

    public int getCantidad() {return cantidad;}

    public void setR(int r) {if(0<=r && r<=255) this.r = r;}

    public void setG(int g) {if(0<=g && g<=255) this.g = g;}

    public void setB(int b) {if(0<=b && b<=255) this.b = b;}

    public void setCantidad(int cantidad) {if(cantidad>0) this.cantidad = cantidad;}
}
