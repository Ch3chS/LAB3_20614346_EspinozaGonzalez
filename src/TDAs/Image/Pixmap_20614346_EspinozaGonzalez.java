package TDAs.Image;

import TDAs.Image.Histogram.PixHistogram_20614346_EspinozaGonzalez;
import TDAs.Pixels.Pixrgb_20614346_EspinozaGonzalez;
import java.util.Scanner;

public class Pixmap_20614346_EspinozaGonzalez extends Image_20614346_EspinozaGonzalez implements Map_20614346_EspinozaGonzalez{

    //Atributos
    Pixrgb_20614346_EspinozaGonzalez[][] pixels;

    //Constructor
    public Pixmap_20614346_EspinozaGonzalez(){}

    public void initImage(int width, int height){
        Scanner r = new Scanner(System.in);  // Lector
        int valor;
        setWidth(width);
        setHeight(height);
        this.pixels = new Pixrgb_20614346_EspinozaGonzalez[width][height];

        for(int i=0; i<height; i++){
            for(int j=0; j<width;j++){
                System.out.println("#### Pixel ("+j+","+i+") #### ");
                getPixels()[j][i] = new Pixrgb_20614346_EspinozaGonzalez();
                getPixels()[j][i].setX(j);
                getPixels()[j][i].setY(i);
                System.out.print("Ingrese la cantidad de rojo del pixel (0 <= r <= 255): ");
                valor = r.nextInt();
                getPixels()[j][i].setR(valor);
                System.out.print("Ingrese la cantidad de verde del pixel (0 <= g <= 255): ");
                valor = r.nextInt();
                getPixels()[j][i].setG(valor);
                System.out.print("Ingrese la cantidad de azul del pixel (0 <= b <= 255): ");
                valor = r.nextInt();
                getPixels()[j][i].setB(valor);
                System.out.print("Ingrese la profundidad del pixel: ");
                valor = r.nextInt();
                getPixels()[j][i].setDepth(valor);
                System.out.print("\n");
            }
        }
    }

    //Selector
    public Pixrgb_20614346_EspinozaGonzalez[][] getPixels() {return pixels;}


    //Otras funciones
    @Override
    public Image_20614346_EspinozaGonzalez flipH() {
        Pixrgb_20614346_EspinozaGonzalez[] temp;
        for(int i=0; i < getWidth()/2;i++){
            temp = getPixels()[i];
            getPixels()[i] = getPixels()[getWidth()-1-i];
            getPixels()[getWidth()-1-i] = temp;
        }
        return this;
    }

    @Override
    public Image_20614346_EspinozaGonzalez flipV(){
        Pixrgb_20614346_EspinozaGonzalez temp;

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
    public Pixmap_20614346_EspinozaGonzalez crop(int x1, int y1, int x2, int y2){
        Pixrgb_20614346_EspinozaGonzalez[][] newPixels;
        setWidth(x2 - x1 + 1);
        setHeight(y2 - y1 + 1);
        newPixels = new Pixrgb_20614346_EspinozaGonzalez[getWidth()][getHeight()];

        for(int i=0; i<getHeight(); i++){
            for(int j=0; j<getWidth();j++){    // x = j,  y = i
                newPixels[j][i] = getPixels()[j+x1][i+y1];
            }
        }
        this.pixels = newPixels;
        return this;
    }

    public PixHistogram_20614346_EspinozaGonzalez histogram(){
        PixHistogram_20614346_EspinozaGonzalez histogram = new PixHistogram_20614346_EspinozaGonzalez();  //Se crea objeto histogram

        histogram = histogram.histogramInit(this);  //Se inicializa

        return histogram;  //Se retorna
    }

    @Override
    public Pixmap_20614346_EspinozaGonzalez rotate90(){
        Pixrgb_20614346_EspinozaGonzalez[][] newPixels;
        Pixmap_20614346_EspinozaGonzalez img = new Pixmap_20614346_EspinozaGonzalez();
        this.flipV();  //Invertimos los pixeles en el eje Y de la imagen original

        newPixels = new Pixrgb_20614346_EspinozaGonzalez[getHeight()][getWidth()];  //Nuevos pixeles con width y height intercambiados
        img.setWidth(getHeight());    //Invertimos width y height para la imagen rotada
        img.setHeight(getWidth());

        for(int i=0; i<img.getHeight(); i++){
            for(int j=0; j<img.getWidth();j++){    // x = j,  y = i
                newPixels[j][i] = new Pixrgb_20614346_EspinozaGonzalez();  //Inicializamos el pixel con coords (y, x)
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
                string.append(getPixels()[j][i].rgbToString()).append("\t");
            }
            string.append("\n");
        }

        return string.toString();
    }
}
