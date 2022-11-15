package TDAs.Image;

import TDAs.Image.Histogram.PixHistogram_20614346_EspinozaGonzalez;
import TDAs.Pixels.Pixbit_20614346_EspinozaGonzalez;
import TDAs.Pixels.Pixrgb_20614346_EspinozaGonzalez;

import java.util.LinkedList;
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
    public Pixmap_20614346_EspinozaGonzalez compress(){
        if(!this.isCompressed()){    //Si no esta comprimida la comprimimos

            //Preparación pre-compresión
            PixHistogram_20614346_EspinozaGonzalez histogram = histogram();
            setMostUsed(histogram.MostUsed());  //Seteamos el color más usado para su posterior uso aquí y en decompress
            String temp;

            //Compresión
            for(int i=0; i<getHeight(); i++){
                for(int j=0; j<getWidth();j++){    // x = j,  y = i
                    temp = getPixels()[j][i].getR() + " " + getPixels()[j][i].getG() + " " + getPixels()[j][i].getB();
                    if(temp.equals(getMostUsed())){   //Si el bit del pixel es el más usado:
                        depths.add(getPixels()[j][i].getDepth());  //Almacenamos la profundidad del pixel para cuando se descomprima la imagen
                        getPixels()[j][i] = null;         //eliminamos el pixel de la imagen
                    }
                }
            }

            return this;  //Retornamos la imagen ya comprimida
        }
        return this;   //Si la imagen ya estaba comprimida no le hacemos nada y la retornamos
        //(no esta la posibilidad en el menú de que no este comprimida y acceda a esto pero para que este tratado el caso)
    }

    public Pixmap_20614346_EspinozaGonzalez changePixel(Pixrgb_20614346_EspinozaGonzalez pixel){
        getPixels()[pixel.getX()][pixel.getY()] = pixel;
        return this;
    }

    public Pixmap_20614346_EspinozaGonzalez invertColorRGB(){
        for(int i=0; i<getHeight(); i++){
            for(int j=0; j<getWidth();j++) {
                getPixels()[j][i].invertColorRGB(); //Simplemente aplicamos el método de la clase Pixrgb a cada pixel
            }
        }
        return this;
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

    public LinkedList<Pixmap_20614346_EspinozaGonzalez> depthLayers(){
        LinkedList<Pixmap_20614346_EspinozaGonzalez> LayerList = new LinkedList<>();

        for(int k = 0; k <= maxDepth(); k++){                    //Haremos esto en cada capa de la imagen
            LayerList.add(new Pixmap_20614346_EspinozaGonzalez());  //Agregamos una nueva imagen a la lista
            LayerList.get(k).setWidth(getWidth());
            LayerList.get(k).setHeight(getHeight());  //Las imagenes de la lista poseen las mismas dimensiones que la original
            LayerList.get(k).pixels = new Pixrgb_20614346_EspinozaGonzalez[getWidth()][getHeight()];   //Inicializamos los pixeles

            for(int i=0; i<getHeight(); i++){       //Ahora se le dará valores de color a los pixeles de la capa,
                for(int j=0; j<getWidth();j++) {    //Si no se encuentran en la capa se rellenara con color blanco
                    LayerList.get(k).getPixels()[j][i] = new Pixrgb_20614346_EspinozaGonzalez();
                    if(getPixels()[j][i].getDepth() == k){            //Si son de la misma profundidad guardamos el color rgb
                        LayerList.get(k).getPixels()[j][i].setR(getPixels()[j][i].getR());
                        LayerList.get(k).getPixels()[j][i].setG(getPixels()[j][i].getG());
                        LayerList.get(k).getPixels()[j][i].setB(getPixels()[j][i].getB());
                    }
                    else{
                        LayerList.get(k).getPixels()[j][i].setR(255); //caso contrario el color será blanco rgb
                        LayerList.get(k).getPixels()[j][i].setG(255);
                        LayerList.get(k).getPixels()[j][i].setB(255);
                    }
                    LayerList.get(k).getPixels()[j][i].setDepth(k);   //Para cualquiera de ambos la profundidad es k
                }
            }
        }
        return LayerList;
    }

    @Override
    public Pixmap_20614346_EspinozaGonzalez decompress(){
        String[] mostused = getMostUsed().split(" ");
        int R = Integer.parseInt(mostused[0]);
        int G = Integer.parseInt(mostused[1]);
        int B = Integer.parseInt(mostused[2]);
        int depthIndex = 0;

        for(int i=0; i<getHeight(); i++){
            for(int j=0; j<getWidth();j++){
                if(getPixels()[j][i] == null){   //Si el pixel no se encuentra (fue eliminado al comprimir)
                    getPixels()[j][i] = new Pixrgb_20614346_EspinozaGonzalez();  //Creamos uno nuevo
                    getPixels()[j][i].setR(R);                                   //Con el color más usado pre compresión
                    getPixels()[j][i].setG(G);
                    getPixels()[j][i].setB(B);
                    getPixels()[j][i].setDepth(depths.get(depthIndex));          //Obtenemos la profundidad del mismo
                    depthIndex++;    //Aumentamos el index para la profundidad del siguiente pixel previamente eliminado
                }
            }
        }
        setMostUsed("");    //devolvemos el mostUsed al valor "" para que se sepa que esta descomprimida
        return this;
    }
}
