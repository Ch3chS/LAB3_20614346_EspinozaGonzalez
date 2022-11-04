package TDAs;

public class Pixbit_20614346_EspinozaGonzalez extends Pixel_20614346_EspinozaGonzalez{

    //Atributos
    int color;

    //Constructor
    public Pixbit_20614346_EspinozaGonzalez(){}

    //Selector
    public int getbit(){return color;}

    //Modificador
    public void setbit(int newColor) {
        if(color==0 | color==1){
        this.color = newColor;
        }
    }

    public void invertColorBit(){
        setbit(1-getbit());
    }
}
