package TDAs.Pixels;

public class Pixel_20614346_EspinozaGonzalez{

    //Atributos
    int x,y,depth;

    //Constructor
    public Pixel_20614346_EspinozaGonzalez(){}

    public Pixel_20614346_EspinozaGonzalez(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }

    // Metodos
    //selectores
    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDepth() {
        return depth;
    }

    //Modificadores

    public void setX(int x){if(x>=0) this.x = x;}

    public void setY(int y) {if(y>=0) this.y = y;}

    public void setDepth(int depth) {if(depth>=0) this.depth = depth;}
}

