package TDAs.Pixels;

public class Pixrgb_20614346_EspinozaGonzalez extends Pixel_20614346_EspinozaGonzalez{
    //Atributos
    int r,g,b;

    //Constructor
    public Pixrgb_20614346_EspinozaGonzalez(){}

    //Selectores
    public int getR() {return r;}
    public int getG(){return g;}
    public int getB() {return b;}

    //Modificadores
    public void setR(int r) {if(0<=r && r<=255) this.r = r;}
    public void setG(int g) {if(0<=g && g<=255) this.g = g;}
    public void setB(int b) {if(0<=b && b<=255) this.b = b;}

    //Otras Funciones

    public void invertColorRGB(){
        setR(255-getR());
        setG(255-getG());
        setB(255-getB());
    }


    public String rgbToString(){
        return "(" + getR() + ", " + getG() + ", " + getB() + ")";
    }
}
