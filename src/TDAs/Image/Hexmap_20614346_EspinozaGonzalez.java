package TDAs.Image;

import TDAs.Image.Histogram.HexHistogram_20614346_EspinozaGonzalez;
import TDAs.Pixels.Pixhex_20614346_EspinozaGonzalez;
import java.util.*;

/**
 * Esta subclase de Image define un Hexmap como una imagen hecha de pixeles tipo Pixhex
 * @author Sergio Espinoza
 * @version 1.0
 * @see TDAs.Image.Image_20614346_EspinozaGonzalez
 * @see TDAs.Image.Map_20614346_EspinozaGonzalez
 */

public class Hexmap_20614346_EspinozaGonzalez extends Image_20614346_EspinozaGonzalez implements Map_20614346_EspinozaGonzalez{

    /**
     * Este tipo de imagen usa una matriz para almacenar sus píxeles de tipo pixhex
     */
    Pixhex_20614346_EspinozaGonzalez[][] pixels;

    /**
     * Método constructor de una imagen de tipo pixhex
     */
    public Hexmap_20614346_EspinozaGonzalez(){}

    /**
     * Método para inicializar la imagen, notar que crea todos los objetos clase pixhex en su cuerpo
     * @param width Ancho de la imagen
     * @param height Alto de la imagen
     */
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

    /**
     * Método para obtener los píxeles tipo pixhex de la imagen
     * @return Pixeles tipo pixhex
     */
    public Pixhex_20614346_EspinozaGonzalez[][] getPixels() {return pixels;}

    /**
     * Método que voltea la imagen en el eje X
     * @return Imagen volteada
     */
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

    /**
     * Método que voltea la imagen en el eje Y
     * @return Imagen volteada
     */
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

    /**
     * Método que permite recortar una imagen, en este caso de tipo Hexmap
     * @param x1 X desde la que se desea recortar
     * @param y1 Y desde la que se desea recortar
     * @param x2 X hasta la cual se desea recortar (Debe ser >= x1)
     * @param y2 Y hasta la cual se desea recortar (Debe ser >= y1)
     * @return Imagen recortada
     */
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

    /**
     * Método que instancia e inicializa un HexHistogram
     * @return HexHistogram correspondiente al Hexmap que usa el método
     */
    public HexHistogram_20614346_EspinozaGonzalez histogram(){
        HexHistogram_20614346_EspinozaGonzalez histogram = new HexHistogram_20614346_EspinozaGonzalez();  //Se crea objeto histogram

        histogram = histogram.histogramInit(this);  //Se inicializa

        return histogram;  //Se retorna
    }

    /**
     * Método que rota la imagen que lo usa
     * @return Imagen rotada
     */
    @Override
    public Hexmap_20614346_EspinozaGonzalez rotate90(){
        Pixhex_20614346_EspinozaGonzalez[][] newPixels;
        Hexmap_20614346_EspinozaGonzalez img = new Hexmap_20614346_EspinozaGonzalez();
        this.flipV();  //Invertimos los píxeles en el eje Y de la imagen original

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

    /**
     * Método que comprime una imagen
     * @return imagen comprimida
     */
    @Override
    public Hexmap_20614346_EspinozaGonzalez compress(){
        if(!this.isCompressed()){    //Si no esta comprimida la comprimimos

            //Preparación precompresión
            HexHistogram_20614346_EspinozaGonzalez histogram = histogram();
            setMostUsed(histogram.MostUsed());  //Seteamos el color más usado para su posterior uso aquí y en decompress

            //Compresión
            for(int i=0; i<getHeight(); i++){
                for(int j=0; j<getWidth();j++){    // x = j,  y = i
                    if(getPixels()[j][i].getHex().equals(getMostUsed())){   //Si el bit del pixel es el más usado:
                        depths.add(getPixels()[j][i].getDepth());  //Almacenamos la profundidad del pixel para cuando se descomprima la imagen
                        getPixels()[j][i] = null;         //eliminamos el pixel de la imagen
                    }
                }
            }

            return this;  //Retornamos la imagen ya comprimida
        }
        return this;   //Si la imagen ya estaba comprimida no le hacemos nada y la retornamos
        //(no está la posibilidad en el menú de que no esté comprimida y acceda a esto pero para que este tratado el caso)
    }

    /**
     * Método que cambia el pixel de una imagen por el ingresado (La posición viene en el pixel de entrada)
     * @param pixel Pixel tipo Pixhex con su respectiva posición
     * @return Hexmap con el pixel cambiado
     */
    public Hexmap_20614346_EspinozaGonzalez changePixel(Pixhex_20614346_EspinozaGonzalez pixel){
        getPixels()[pixel.getX()][pixel.getY()] = pixel;
        return this;
    }

    /**
     * Método que convierte una imagen tipo Hexmap a un String que represente a la misma
     * @return String de la imagen (Solo con los colores en la posición correcta)
     */
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

    /**
     * Método que separa las capas de la imagen que lo usa en una lista enlazada de imágenes de igual ancho y alto
     * @return Lista enlazada con las distintas capas de la imagen inicial (imágenes también)
     */
    public LinkedList<Hexmap_20614346_EspinozaGonzalez> depthLayers(){
        LinkedList<Hexmap_20614346_EspinozaGonzalez> LayerList = new LinkedList<>();

        for(int k = 0; k <= maxDepth(); k++){                    //Haremos esto en cada capa de la imagen
            LayerList.add(new Hexmap_20614346_EspinozaGonzalez());  //Agregamos una nueva imagen a la lista
            LayerList.get(k).setWidth(getWidth());
            LayerList.get(k).setHeight(getHeight());  //Las imágenes de la lista poseen las mismas dimensiones que la original
            LayerList.get(k).pixels = new Pixhex_20614346_EspinozaGonzalez[getWidth()][getHeight()];   //Inicializamos los pixeles

            for(int i=0; i<getHeight(); i++){       //Ahora se le dará valores de color a los pixeles de la capa,
                for(int j=0; j<getWidth();j++) {    //Si no se encuentran en la capa se rellenara con color blanco
                    LayerList.get(k).getPixels()[j][i] = new Pixhex_20614346_EspinozaGonzalez();
                    if(getPixels()[j][i].getDepth() == k){            //Si son de la misma profundidad guardamos el bit
                        LayerList.get(k).getPixels()[j][i].setHex(getPixels()[j][i].getHex());
                    }
                    else{
                        LayerList.get(k).getPixels()[j][i].setHex("#FFFFFF"); //caso contrario se pondrá blanco (#FFFFFF)
                    }
                    LayerList.get(k).getPixels()[j][i].setDepth(k);   //Para cualquiera de ambos la profundidad es k
                }
            }
        }
        return LayerList;
    }

    /**
     * Método para descomprimir una imagen comprimida previamente (No se verifica que esté comprimida pues esto ya se hizo en el menú)
     * @return Imagen descomprimida
     */
    @Override
    public Hexmap_20614346_EspinozaGonzalez decompress(){
        int depthIndex = 0;

        for(int i=0; i<getHeight(); i++){
            for(int j=0; j<getWidth();j++){
                if(getPixels()[j][i] == null){   //Si el pixel no se encuentra (fue eliminado al comprimir)
                    getPixels()[j][i] = new Pixhex_20614346_EspinozaGonzalez();  //Creamos uno nuevo
                    getPixels()[j][i].setHex(getMostUsed());                     //Con el color más usada precompresión
                    getPixels()[j][i].setDepth(depths.get(depthIndex));          //Obtenemos la profundidad del mismo
                    depthIndex++;    //Aumentamos el index para la profundidad del siguiente pixel previamente eliminado
                }
            }
        }
        setMostUsed("");    //devolvemos el mostUsed al valor"" para que se sepa que está descomprimida
        return this;
    }
}