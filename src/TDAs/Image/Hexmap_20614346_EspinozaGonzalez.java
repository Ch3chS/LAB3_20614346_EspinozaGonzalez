package TDAs.Image;

import TDAs.Pixels.Pixhex_20614346_EspinozaGonzalez;

import java.util.Scanner;

public class Hexmap_20614346_EspinozaGonzalez extends Image_20614346_EspinozaGonzalez implements Map_20614346_EspinozaGonzalez{

    //Atributos
    Pixhex_20614346_EspinozaGonzalez[][] pixels;

    //Constructor
    public Hexmap_20614346_EspinozaGonzalez(){}

    public void initImage(int width, int height){
        Scanner r = new Scanner(System.in);  // Lector
        int valor;
        String hex;
        setWidth(width);
        setHeight(height);
        this.pixels = new Pixhex_20614346_EspinozaGonzalez[width][height];

        for(int i=0; i<height; i++){
            for(int j=0; j<width;j++){
                System.out.println("#### Pixel ("+j+","+i+") #### ");
                getPixels()[j][i] = new Pixhex_20614346_EspinozaGonzalez();
                getPixels()[j][i].setX(j);
                getPixels()[j][i].setY(i);
                System.out.print("Ingrese el color del pixel(formato: #RRGGBB): ");
                hex = r.nextLine();
                getPixels()[j][i].setHex(hex);
                System.out.print("Ingrese la profundidad del pixel: ");
                valor = r.nextInt();
                r.nextLine();
                getPixels()[j][i].setDepth(valor);
                System.out.print("\n");
            }
        }
    }

    //Selector
    public Pixhex_20614346_EspinozaGonzalez[][] getPixels() {return pixels;}

    //Otras funciones


    @Override
    public Image_20614346_EspinozaGonzalez flipH() {
        Pixhex_20614346_EspinozaGonzalez[] temp;
        for(int i=0; i < getWidth()/2;i++){
            temp = getPixels()[i];
            getPixels()[i] = getPixels()[getWidth()-1-i];
            getPixels()[getWidth()-1-i] = temp;
        }
        return this;
    }

    @Override
    public Image_20614346_EspinozaGonzalez flipV(){
        Pixhex_20614346_EspinozaGonzalez temp;

        for(int i=0; i<getHeight()/2; i++){
            for(int j=0; j<getWidth();j++) {
                temp = getPixels()[j][i];
                getPixels()[j][i] = getPixels()[j][getHeight()-1-i];
                getPixels()[j][getHeight()-1-i] = temp;

            }
        }

        return this;
    }

    @Override
    public Hexmap_20614346_EspinozaGonzalez crop(int x1, int y1, int x2, int y2){
        Pixhex_20614346_EspinozaGonzalez[][] newPixels;
        setWidth(x2 - x1 + 1);
        setHeight(y2 - y1 + 1);
        newPixels = new Pixhex_20614346_EspinozaGonzalez[getWidth()][getHeight()];

        for(int i=0; i<getHeight(); i++){
            for(int j=0; j<getWidth();j++){    // x = j,  y = i
                newPixels[j][i] = getPixels()[j+x1][i+y1];
            }
        }
        this.pixels = newPixels;
        return this;
    }

    @Override
    public Hexmap_20614346_EspinozaGonzalez rotate90(){
        Pixhex_20614346_EspinozaGonzalez[][] newPixels;
        Hexmap_20614346_EspinozaGonzalez img = new Hexmap_20614346_EspinozaGonzalez();
        this.flipV();  //Invertimos los pixeles en el eje Y de la imagen original

        newPixels = new Pixhex_20614346_EspinozaGonzalez[getHeight()][getWidth()];  //Nuevos pixeles con width y height intercambiados
        img.setWidth(getHeight());    //Invertimos width y height para la imagen rotada
        img.setHeight(getWidth());

        for(int i=0; i<img.getHeight(); i++){
            for(int j=0; j<img.getWidth();j++){    // x = j,  y = i
                newPixels[j][i] = new Pixhex_20614346_EspinozaGonzalez();  //Inicializamos el pixel con coords (y, x)
                newPixels[j][i] = this.getPixels()[i][j];                   //pixel nuevo (y,x) = pixel viejo (x,y) (intercambiamos x e y)
            }
        }
        img.pixels = newPixels;
        return img;
    }

    @Override
    public String imageToString(){
        if (isCompressed()) return "La imagen se encuentra comprimida, por favor descomprimirla para poder visualizarla";
        StringBuilder string= new StringBuilder();

        for(int i=0; i<height; i++){
            for(int j=0; j<width;j++) {
                string.append(getPixels()[j][i].getHex()).append("\t");
            }
            string.append("\n");
        }

        return string.toString();
    }
}