package TDAs.Pixels;

public class Pixbit_20614346_EspinozaGonzalez extends Pixel_20614346_EspinozaGonzalez{

    //Atributos
    int color;

    //Constructor
    public Pixbit_20614346_EspinozaGonzalez(){}

    //Selector
    public int getBit(){return color;}

    //Modificador
    public void setBit(int newColor) {
        if(color==0 | color==1){
        this.color = newColor;
        }
    }

    //Otras funciones
    public void invertColorBit(){
        setBit(1-getBit());
    }

    public String bitToString() {
        return getBit()+"";
    }
}
