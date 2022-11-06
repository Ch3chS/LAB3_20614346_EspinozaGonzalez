import java.util.*;
import TDAs.Image.*;

import java.io.IOException;

public class Main_20614346_EspinozaGonzalez {
    public static void main(String[] args) throws IOException {
        Scanner r = new Scanner(System.in);  // Escaner para las entradas
        LinkedList<Image_20614346_EspinozaGonzalez> images = new LinkedList<>();  //Este sera el almacen de imagenes

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
                    imprimirMenu();
                    break;


                case "3": //Visualizar una imagen

                    //Primero mostramos las opciones al usuario
                    int i = 1;
                    for(Image_20614346_EspinozaGonzalez image: images){
                        if(image.isBitmap()) {
                            System.out.println(i + ". Bitmap -> "  + "(Ancho: " + image.getWidth() + " Alto: " + image.getHeight() + ")");
                        } else if (image.isPixmap()){
                            System.out.println(i + ". Pixmap -> "  + "(Ancho: " + image.getWidth() + " Alto: " + image.getHeight() + ")");
                        }
                        else     System.out.println(i + ". Hexmap -> "  + "(Ancho: " + image.getWidth() + " Alto: " + image.getHeight() + ")");
                        i++;
                    }
                    System.out.println(i+". volver");

                    //Preguntamos al usuario que imagen desea imprimir
                    int toPrint;
                    System.out.print("\nIngrese su opcion: ");
                    toPrint = r.nextInt();
                    r.nextLine();

                    //Obtenemos la imagen o volvemos al inicio en caso de requerirlo
                    if(toPrint < i){
                        toPrint--;
                        //System.out.println(images.get(toPrint).imageToString());  //Imprimimos la imagen
                    }
                    else if(toPrint == i){
                        imprimirMenu();
                        break;
                    }
                    else{
                        System.out.println("\nLa opcion ingresada es incorrecta, por favor, intentelo nuevamente");
                        imprimirMenu();
                        break;
                    }

                    //Volvemos al menu principal
                    imprimirMenu();
                    break;


                default:
                    System.out.println("\nLa opcion ingresada es incorrecta, por favor, intentelo nuevamente");
                    break;
            }
            System.out.print("Ingrese su opcion: ");
            opcion = r.nextLine();
            System.out.println("\n");
        }
        System.out.println("\nLa ejecucion del programa ha finalizado.\n");
    }


    public static void imprimirMenu(){
        System.out.println("\n### Manipulador de Imagenes ###\nEscoja su opcion:\n");
        System.out.println("1. Crear una imagen\n2. Modificar una imagen\n3. Visualizar imagen\ne. salir\n");
    }
}