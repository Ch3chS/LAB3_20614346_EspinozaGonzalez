import java.util.*;
import TDAs.Image.*;
import TDAs.Pixels.Pixbit_20614346_EspinozaGonzalez;
import TDAs.Pixels.Pixrgb_20614346_EspinozaGonzalez;
import TDAs.Pixels.Pixhex_20614346_EspinozaGonzalez;
import TDAs.Image.Histogram.*;
import TDAs.Image.Histogram.HistogramLinks.*;

/**
 * Archivo main donde se inicializa el programa;
 * Este solo corresponde al menú y sus opciones, pues el programa como tal hace uso de clases para operar;
 * de este modo, en este archivo solo encontrará opciones instancias de clases y llamados a métodos de las mismas.
 */

public class Main_20614346_EspinozaGonzalez {

    /**
     * Notar que las imagenes se almacenarán en una lista enlazada por lo que se podrá acceder a todas las creadas
     * hasta que se finalice el programa (IMPORTANTE: en caso de reiniciar el programa se perderán)
     */
    static LinkedList<Image_20614346_EspinozaGonzalez> images = new LinkedList<>();  //Este será el almacén de imágenes
    static Scanner r = new Scanner(System.in);  // Scanner para las entradas
    public static void main(String[] args){

        // A continuación se encuentra el código para el menú
        String exit = "e";
        String option="i";
        imprimirMenu();

        while (!Objects.equals(option, exit)) {
            switch (option) {
                case "i": break;
                case "1":
                    int width=0, height=0,option2;

                    System.out.println("Que tipo de imagen desea crear, las opciones son:\n1. Crear Bitmap\n2. Crear Pixmap\n3. Crear Hexmap\n4. Volver\n");
                    System.out.print("Ingrese su eleccion: ");
                    option2 = r.nextInt();
                    r.nextLine();

                    if(option2 == 1 || option2 == 2 || option2 == 3) {
                        System.out.print("\nIngrese el ancho de la imagen: ");
                        width = r.nextInt();
                        System.out.print("Ingrese el alto de la imagen: ");
                        height = r.nextInt();
                        r.nextLine();
                        System.out.print("\n");
                    }

                    switch (option2) {
                        case 1:
                            Bitmap_20614346_EspinozaGonzalez i1 = new Bitmap_20614346_EspinozaGonzalez();
                            i1.initImage(width,height);
                            images.add(i1);
                            System.out.println("Bitmap creado");
                            System.out.println("Ancho: "+ i1.getWidth() + ", Alto: " + i1.getHeight() + "\n");
                            System.out.println(i1.imageToString());
                            System.out.println("Regresando...\n");
                            break;


                        case 2:
                            Pixmap_20614346_EspinozaGonzalez i2 = new Pixmap_20614346_EspinozaGonzalez();
                            i2.initImage(width,height);
                            images.add(i2);
                            System.out.println("Pixmap creado");
                            System.out.println("Ancho: "+ i2.getWidth() + ", Alto: " + i2.getHeight() + "\n");
                            System.out.println(i2.imageToString());
                            System.out.println("Regresando...\n");
                            break;


                        case 3:
                            Hexmap_20614346_EspinozaGonzalez i3 = new Hexmap_20614346_EspinozaGonzalez();
                            i3.initImage(width,height);
                            images.add(i3);
                            System.out.println("Hexmap creado");
                            System.out.println("Ancho: "+ i3.getWidth() + ", Alto: " + i3.getHeight() + "\n");
                            System.out.println(i3.imageToString());
                            System.out.println("Regresando...");
                            break;


                        case 4:
                            break;


                        default:
                            System.out.println("El valor ingresado es incorrecto, regresando...\n");
                            break;
                    }
                    //Volvemos al menu principal
                    imprimirMenu();
                    break;


                case "2":

                    int imageToModIndex = imageSelector();

                    if(imageToModIndex != -1){    // Si se seleccionó la imagen correctamente procederemos con la eleccion de modificación

                        if(images.get(imageToModIndex).isCompressed()){   //Si la imagen se encuentra comprimida solo se ofrecen 2 opciones
                            System.out.println("Esta imagen se encuentra comprimida\nEscoja una opcion:\n1. Descomprimir imagen\n2. Volver\n");
                            System.out.print("Ingrese su eleccion: ");
                            option2=r.nextInt();
                            r.nextLine();

                            switch (option2){
                                case 1:
                                    images.set(imageToModIndex, images.get(imageToModIndex).decompress());
                                    System.out.println("\nImagen descomprimida, regresando...\n");
                                    break;
                                case 2: break;
                                default:
                                    System.out.println("\nLa opcion ingresada es incorrecta, por favor, intentelo nuevamente");
                                    break;
                            }

                        }
                        else {
                            modImage(imageToModIndex);    //Si la imagen es correcta y está descomprimida la modificamos

                        }
                    }

                    imprimirMenu();
                    break;


                case "3": //Visualizar una imagen

                    int imageToPrintIndex = imageSelector();      // Se selecciona la imagen

                    if(imageToPrintIndex != -1){//Obtenemos la imagen o volvemos al inicio en caso de requerirlo
                        if(images.get(imageToPrintIndex).isCompressed()){
                            System.out.println("La imagen seleccionada se encuentra comprimida, por favor descomprimirla antes de poder visualizarla\n");
                            imprimirMenu();
                            break;
                        }


                        System.out.println("\nQue tipo de impresion desea realizar: \n\n1. Imprimir imagen\n2. Imprimir capas (depthLayers)\n3. Imprimir histograma de colores\n4. Volver\n");
                        System.out.print("\nEscoja una opcion: ");
                        int opcion3 = r.nextInt();
                        r.nextLine();
                        System.out.print("\n");
                        switch (opcion3){
                            case 1:   //Imprimir imagen como tal
                                Image_20614346_EspinozaGonzalez imageToPrint = images.get(imageToPrintIndex);
                                System.out.println(imageToPrint.imageToString());  //Imprimimos la imagen
                                System.out.println("\nImagen impresa, regresando...");
                                break;
                                
                            case 2:   //Imprimir capas (DepthLayers)
                                int capa = 0;
                                if(images.get(imageToPrintIndex).isBitmap()) {
                                    LinkedList<Bitmap_20614346_EspinozaGonzalez> Layers;
                                    Bitmap_20614346_EspinozaGonzalez  BM = (Bitmap_20614346_EspinozaGonzalez) images.get(imageToPrintIndex);
                                    Layers = BM.depthLayers();
                                    for (Bitmap_20614346_EspinozaGonzalez image : Layers) {
                                        System.out.println("\nCapa " + capa + ": \n");
                                        System.out.println(image.imageToString());
                                        capa++;
                                    }
                                }
                                if(images.get(imageToPrintIndex).isPixmap()) {
                                    LinkedList<Pixmap_20614346_EspinozaGonzalez> Layers;
                                    Pixmap_20614346_EspinozaGonzalez  PM = (Pixmap_20614346_EspinozaGonzalez) images.get(imageToPrintIndex);
                                    Layers = PM.depthLayers();

                                    for (Pixmap_20614346_EspinozaGonzalez image : Layers) {
                                        System.out.println("\nCapa " + capa + ": \n");
                                        System.out.println(image.imageToString());
                                        capa++;
                                    }
                                }
                                if(images.get(imageToPrintIndex).isHexmap()) {
                                    LinkedList<Hexmap_20614346_EspinozaGonzalez> Layers;
                                    Hexmap_20614346_EspinozaGonzalez  HM = (Hexmap_20614346_EspinozaGonzalez) images.get(imageToPrintIndex);
                                    Layers = HM.depthLayers();
                                    for (Hexmap_20614346_EspinozaGonzalez image : Layers) {
                                        System.out.println("\nCapa " + capa + ": \n");
                                        System.out.println(image.imageToString());
                                        capa++;
                                    }
                                }
                                break;
                                
                            case 3:   //Imprimir histograma (histogram)
                                if(images.get(imageToPrintIndex).isBitmap()) {
                                    BitHistogram_20614346_EspinozaGonzalez histogram;
                                    Bitmap_20614346_EspinozaGonzalez  BM = (Bitmap_20614346_EspinozaGonzalez) images.get(imageToPrintIndex);
                                    histogram = BM.histogram();
                                    for (BitHistogramLink_20614346_EspinozaGonzalez link : histogram.getHistogram())
                                        System.out.println("Color: " + link.getBit() + ", Se repite: " + link.getCantidad() + " veces");
                                }
                                if(images.get(imageToPrintIndex).isPixmap()) {
                                    PixHistogram_20614346_EspinozaGonzalez histogram;
                                    Pixmap_20614346_EspinozaGonzalez  PM = (Pixmap_20614346_EspinozaGonzalez) images.get(imageToPrintIndex);
                                    histogram = PM.histogram();
                                    for (PixHistogramLink_20614346_EspinozaGonzalez link : histogram.getHistogram())
                                        System.out.println("Color: " + "(" +link.getR() + ", " + link.getG() + ", " + link.getB() + "), Se repite: " + link.getCantidad() + " veces");
                                }
                                if(images.get(imageToPrintIndex).isHexmap()) {
                                    HexHistogram_20614346_EspinozaGonzalez histogram;
                                    Hexmap_20614346_EspinozaGonzalez  HM = (Hexmap_20614346_EspinozaGonzalez) images.get(imageToPrintIndex);
                                    histogram = HM.histogram();
                                    for (HexHistogramLink_20614346_EspinozaGonzalez link : histogram.getHistogram())
                                        System.out.println("Color: " + link.getHex() + ", Se repite: " + link.getCantidad() + " veces");
                                }
                                break;

                            case 4:
                                break;
                                
                            default:
                                System.out.println("\nLa opcion ingresada es incorrecta, por favor, intentelo nuevamente");
                                imprimirMenu();
                                break;
                        }
                        
                    }

                    //Volvemos al menu principal
                    imprimirMenu();
                    break;


                default:
                    System.out.println("\nLa opcion ingresada es incorrecta, por favor, intentelo nuevamente");
                    imprimirMenu();
                    break;
            }
            System.out.print("Ingrese su opcion: ");
            option = r.nextLine();
            System.out.println("\n");
        }
        System.out.println("\nLa ejecucion del programa ha finalizado.\n");
    }


    /**
     * Lo único que hace esto es imprimir el menú principal
     * se hizo de esta forma para no repetir el mismo código tantas veces.
     */
    public static void imprimirMenu(){
        System.out.println("\n### Menu principal ###\nEscoja su opcion:\n");
        System.out.println("1. Crear una imagen\n2. Modificar una imagen\n3. Visualizar imagen\ne. salir\n");
    }


    /**
     * Para las opciones 2 y 3 del menú (Modificar o Imprimir imagen)
     * Primero que nada se debe seleccionar la imagen sobre la que se realizará la opción;
     * debido a esto aquí hay un selector que muestra las opciones y recibe la elegida
     * @return indice de la imagen a operar
     */
    public static int imageSelector(){
        System.out.println("\n#### Selector de Imagenes ####\nEscoja su opcion:\n");

        //Primero mostramos las opciones al usuario
        int i = 1;
        for(Image_20614346_EspinozaGonzalez image: images){
            if(image.isBitmap()) {
                System.out.println(i + ". Bitmap -> "  + "(Ancho: " + image.getWidth() + " Alto: " + image.getHeight() + ")");
            }
            else if (image.isPixmap()){
                System.out.println(i + ". Pixmap -> "  + "(Ancho: " + image.getWidth() + " Alto: " + image.getHeight() + ")");
            }
            else if(image.isHexmap()){
                System.out.println(i + ". Hexmap -> "  + "(Ancho: " + image.getWidth() + " Alto: " + image.getHeight() + ")");
            }
            i++;
        }
        System.out.println(i+". volver");

        //Preguntamos al usuario sobre cuál imagen desea operar
        int index;
        System.out.print("\nIngrese su opcion: ");
        index = r.nextInt();
        r.nextLine();
        System.out.println("\n");

        // Ya con el valor ingresado tenemos 3 opciones:
        if(0 < index && index < i){
            index--;
            return index;   // Si selecciono correctamente una imagen la retornamos
        }
        else if(index == i){
            return -1;                // Si decidió volver, retornamos sin hacer nada
        }
        else{
            System.out.println("\nLa opcion ingresada es incorrecta, por favor, intentelo nuevamente");
            return -1;               // Si ingreso un valor no correspondiente, se le avisa y se retorna
        }

    }


    /**
     * En caso de querer modificar la imagen elegida se muestra un menú cuyas opciones dependerán del tipo de imagen
     * seguido de esto se recibirá lo elegido por el usuario y se procederá con lo mismo.
     * @param index indice de la imagen a modificar
     */
    public static void modImage(int index){
        // Primero imprimimos el menu general para todas las imágenes
        System.out.println("#### Modificadores de imagenes ####\nEscoja su opcion:\n");
        System.out.println(""+
                "1. compress (comprimir imagen)" + "\n" +
                "2. flipH (invertir horizontalmente)" + "\n" +
                "3. flipV (invertir verticalmente)" + "\n" +
                "4. crop (recortar)" + "\n" +
                "5. rotate90 (rotar a la derecha)" + "\n" +
                "6. changePixel (cambiar pixel en especifico)");

        //Luego los casos particulares + el volver
        if(images.get(index).isBitmap()){
            System.out.println("" +
                    "7. invertColorBit  (invertir color)" + "\n" +
                    "8. volver" + "\n");
        }
        if(images.get(index).isPixmap()){
            System.out.println("" +
                    "7. invertColorRGB  (invertir color)" + "\n" +
                    "8. imageRGBToHex  (convertir a hexmap)" + "\n" +
                    "9. volver" + "\n");
        }
        if(images.get(index).isHexmap()){
            System.out.println("" +
                    "7. volver" + "\n");
        }

        //Ya habiendo mostrado las opciones, damos a elegir una
        System.out.print("Ingrese su opcion: ");
        int choice = r.nextInt();
        r.nextLine();
        System.out.println("\n");

        //Opcion elegida
        switch (choice){
            case 1:
                images.set(index, images.get(index).compress());
                System.out.println("\nImagen modificada, regresando...\n");
                break;

            case 2:
                images.set(index, images.get(index).flipH());
                System.out.println("\nImagen modificada, regresando...\n");
                break;

            case 3:
                images.set(index, images.get(index).flipV());
                System.out.println("\nImagen modificada, regresando...\n");
                break;

            case 4:
                System.out.println("\nIngrese las coordenadas para el recorte: ");
                System.out.print("\nCoordenada X1: ");
                int x1 = r.nextInt();
                System.out.print("\nCoordenada Y1: ");
                int y1 = r.nextInt();
                System.out.print("\nCoordenada X2: ");
                int x2 = r.nextInt();
                System.out.print("\nCoordenada Y2: ");
                int y2 = r.nextInt();
                r.nextLine();
                images.set(index, images.get(index).crop(x1, y1, x2, y2));
                System.out.println("\nImagen modificada, regresando...\n");
                break;


            case 5:
                images.set(index, images.get(index).rotate90());
                System.out.println("\nImagen modificada, regresando...\n");
                break;

            case 6:  //En el caso de changePixel primero debemos crear un pixel del respectivo tipo, luego llamar al método
                System.out.print("\nIngrese la coordenada X del pixel a cambiar: ");
                int x = r.nextInt();
                System.out.print("Ingrese la coordenada Y del pixel a cambiar: ");
                int y = r.nextInt();
                r.nextLine();

                if(images.get(index).isBitmap()){
                    Bitmap_20614346_EspinozaGonzalez i = (Bitmap_20614346_EspinozaGonzalez) images.get(index);
                    Pixbit_20614346_EspinozaGonzalez pixel = new Pixbit_20614346_EspinozaGonzalez();
                    pixel.setX(x);
                    pixel.setY(y);
                    System.out.print("Ingrese el bit: ");
                    pixel.setBit(r.nextInt());
                    System.out.print("Ingrese la profundidad: ");
                    pixel.setDepth(r.nextInt());
                    r.nextLine();
                    //depth
                    images.set(index, i.changePixel(pixel));
                }
                if(images.get(index).isPixmap()){
                    Pixmap_20614346_EspinozaGonzalez i = (Pixmap_20614346_EspinozaGonzalez) images.get(index);
                    Pixrgb_20614346_EspinozaGonzalez pixel = new Pixrgb_20614346_EspinozaGonzalez();
                    pixel.setX(x);
                    pixel.setY(y);
                    System.out.print("Ingrese el valor de r: ");
                    pixel.setR(r.nextInt());
                    System.out.print("Ingrese el valor de g: ");
                    pixel.setG(r.nextInt());
                    System.out.print("Ingrese el valor de b: ");
                    pixel.setB(r.nextInt());
                    System.out.print("Ingrese la profundidad: ");
                    pixel.setDepth(r.nextInt());
                    r.nextLine();
                    //depth
                    images.set(index, i.changePixel(pixel));
                }
                if(images.get(index).isHexmap()){
                    Hexmap_20614346_EspinozaGonzalez i = (Hexmap_20614346_EspinozaGonzalez) images.get(index);
                    Pixhex_20614346_EspinozaGonzalez pixel = new Pixhex_20614346_EspinozaGonzalez();
                    pixel.setX(x);
                    pixel.setY(y);
                    System.out.print("Ingrese el color hexadecimal: ");
                    pixel.setHex(r.nextLine());
                    System.out.print("Ingrese la profundidad: ");
                    pixel.setDepth(r.nextInt());
                    r.nextLine();
                    //depth
                    images.set(index, i.changePixel(pixel));
                }
                System.out.println("\nImagen modificada, regresando...\n");
                break;

            case 7:
                if(images.get(index).isBitmap()){     //invertColorBit
                    Bitmap_20614346_EspinozaGonzalez b = (Bitmap_20614346_EspinozaGonzalez) images.get(index);
                    images.set(index, b.invertColorBit());
                    System.out.println("\nImagen modificada, regresando...\n");
                }
                if(images.get(index).isPixmap()){     //invertColorRGB
                    Pixmap_20614346_EspinozaGonzalez p = (Pixmap_20614346_EspinozaGonzalez) images.get(index);
                    images.set(index, p.invertColorRGB());
                    System.out.println("\nImagen modificada, regresando...\n");
                }
                break;  //Si es hexmap solo vuelve, caso contrario se opera y después se vuelve

            case 8:
                if(images.get(index).isPixmap()){     //imageRGBToHex
                    images.set(index, images.get(index).imgRGBToHex());
                    System.out.println("\nImagen modificada, regresando...\n");
                }
                if(images.get(index).isHexmap()){     //Si la imagen es un Hexmap entonces la opcion es incorrecta
                    System.out.println("\nLa opcion ingresada es incorrecta, por favor, intentelo nuevamente");
                }
                break;   // Si es bitmap solo volvemos

            case 9:
                if(!images.get(index).isPixmap()){      //Si la imagen no es un Pixmap entonces la opcion es incorrecta
                    System.out.println("\nLa opcion ingresada es incorrecta, por favor, intentelo nuevamente");
                }
                break;    //Si la imagen es un pixmap volvemos

            default:
                System.out.println("\nLa opcion ingresada es incorrecta, por favor, intentelo nuevamente");
                break;
        }
        System.out.println("\nEstado actual de imagen: \n");
        System.out.println(images.get(index).imageToString());
        System.out.println("\n");
    }
}