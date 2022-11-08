import java.util.*;
import TDAs.Image.*;

public class Main_20614346_EspinozaGonzalez {
    static LinkedList<Image_20614346_EspinozaGonzalez> images = new LinkedList<>();  //Este sera el almacen de imagenes
    static Scanner r = new Scanner(System.in);  // Escaner para las entradas
    public static void main(String[] args){



        // A continuación se encuentra el código para el menú
        String exit = "e";
        String opcion="i";
        imprimirMenu();
        while (!Objects.equals(opcion, exit)) {
            switch (opcion) {
                case "i": break;
                case "1":
                    int width=0, height=0,opcion2;

                    System.out.println("Que tipo de imagen desea crear, las opciones son:\n1. Crear Bitmap\n2. Crear Pixmap\n3. Crear Hexmap\n4. Volver\n");
                    System.out.print("Ingrese su eleccion: ");
                    opcion2 = r.nextInt();
                    r.nextLine();

                    if(opcion2 == 1 || opcion2 == 2 || opcion2 == 3) {
                        System.out.print("\nIngrese el ancho de la imagen: ");
                        width = r.nextInt();
                        System.out.print("Ingrese el alto de la imagen: ");
                        height = r.nextInt();
                        r.nextLine();
                        System.out.print("\n");
                    }

                    switch (opcion2) {
                        case 1:
                            Bitmap_20614346_EspinozaGonzalez i1 = new Bitmap_20614346_EspinozaGonzalez();
                            i1.initImage(width,height);
                            images.add(i1);
                            System.out.println("Imagen creada, Regresando...");
                            break;


                        case 2:
                            Pixmap_20614346_EspinozaGonzalez i2 = new Pixmap_20614346_EspinozaGonzalez();
                            i2.initImage(width,height);
                            images.add(i2);
                            System.out.println("Imagen creada, Regresando...");
                            break;


                        case 3:
                            Hexmap_20614346_EspinozaGonzalez i3 = new Hexmap_20614346_EspinozaGonzalez();
                            i3.initImage(width,height);
                            images.add(i3);
                            System.out.println("Imagen creada, Regresando...");
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

                    if(imageToModIndex != -1){    // Si se selecciono la imagen correctamente procederemos con la eleccion de modificación

                        if(images.get(imageToModIndex).isCompressed()){
                            System.out.println("Esta imagen se encuentra comprimida\nEscoja una opción:\n1. Descomprimir imagen\n2. Volver");
                            opcion2=r.nextInt();
                            r.nextLine();

                            switch (opcion2){
                                case 1:
                                    //images.get(imageToModIndex).decompress();
                                    System.out.println("\nImagen descomprimida, regresando...\n");
                                    break;
                                case 2: break;
                                default:
                                    System.out.println("\nLa opcion ingresada es incorrecta, por favor, intentelo nuevamente");
                                    break;
                            }

                        }
                        else {
                            modImage(imageToModIndex, menuMod());    //Si la imagen es correcta y esta descomprimida la modificamos
                            System.out.println("\nImagen modificada, regresando...\n");
                        }
                    }

                    imprimirMenu();
                    break;


                case "3": //Visualizar una imagen

                    int imageToPrintIndex = imageSelector();

                    //Obtenemos la imagen o volvemos al inicio en caso de requerirlo
                    if(imageToPrintIndex != -1){
                        Image_20614346_EspinozaGonzalez imageToPrint = images.get(imageToPrintIndex);
                        System.out.println(imageToPrint.imageToString());  //Imprimimos la imagen
                        System.out.println("\nImagen impresa, regresando...");
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
            opcion = r.nextLine();
            System.out.println("\n");
        }
        System.out.println("\nLa ejecucion del programa ha finalizado.\n");
    }


    public static void imprimirMenu(){
        System.out.println("\n### Menu principal ###\nEscoja su opcion:\n");
        System.out.println("1. Crear una imagen\n2. Modificar una imagen\n3. Visualizar imagen\ne. salir\n");
    }

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

        //Preguntamos al usuario sobre cual imagen desea operar
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

    public static int menuMod(){
        System.out.println("#### Modificadores de imagenes ####\nEscoja su opcion:\n");
        System.out.println("1. flipH (invertir horizontalmente)" + "\n" +
                        "2. flipV (invertir verticalmente)" + "\n" +
                        "10. Volver\n");

        System.out.print("Ingrese su opcion: ");
        int choice = r.nextInt();
        r.nextLine();
        System.out.println("\n");
        return choice;
    }

    public static void modImage(int index, int op){
        switch (op){
            case 1:
                images.set(index, images.get(index).flipH());
                break;

            case 2:
                //images.set(index, images.get(index).flipV());
                break;


            default:
                System.out.println("\nLa opcion ingresada es incorrecta, por favor, intentelo nuevamente");
                break;
        }
    }
}