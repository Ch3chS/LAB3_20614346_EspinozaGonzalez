import java.util.*;
import TDAs.Image.*;
import TDAs.Pixels.*;

import java.io.IOException;

public class Main_20614346_EspinozaGonzalez {
    public static void main(String[] args) throws IOException {
        Scanner r = new Scanner(System.in);  // Escaner para las entradas
        String exit = "e";
        String opcion="i";


        // A continuación se encuentra el código para el menú
        while (!Objects.equals(opcion, exit)) {
            System.out.println("\n### Manipulador de Imágenes ###\nEscoja su opción:");
            switch (opcion) {
                case "i":
                    System.out.println("1. Crear una imagen\n2. Modificar una imagen\n3. Visualizar imagen\ne. salir\n");
                    break;

                case "1":
                    int goBack = image();
                    if(goBack==1) System.out.println("\n### Manipulador de Imágenes ###\nEscoja su opción:\n1. Crear una imagen\n2. Modificar una imagen\n3. Visualizar imagen\ne. salir\n");
                    else if(goBack==0){
                        System.out.println("La imágen ha sido creada con exito\nRegresando al inicio...\n\nSi desea volver a imprimir el menú ingrese la letra i");
                    }
                    else {
                        System.out.println("La operacion ha fracasado\nRegresando al inicio...\n\nSi desea volver a imprimir el menú ingrese la letra i");
                    }
                    break;

                case "2":

                    break;

                case "3":

                    break;

                default:
                    System.out.println("\nLa opción ingresada es incorrecta, por favor, intentelo nuevamente\nSi desea volver a imprimir el menú ingrese la letra i");
                    System.out.print("Ingrese su opción: ");
                    opcion = r.nextLine();
                    System.out.println("\n");
                    break;
            }
            System.out.print("Ingrese su opción: ");
            opcion = r.nextLine();
            System.out.println("\n");
        }
        System.out.println("\nLa ejecución del programa ha finalizado.");
    }


    public static int image() throws IOException {
        Scanner r = new Scanner(System.in);  // Escaner para las entradas
        int width=0, height=0,opcion;

        System.out.println("Que tipo de imagen desea crear, las opciones son:\n1. Crear Bitmap\n2. Crear Pixmap\n3. Crear Hexmap\n4. Volver\n");
        System.out.print("Ingrese su eleccion: ");
        opcion = r.nextInt();

        if(opcion == 1 || opcion == 2 || opcion == 3) {
            System.out.print("\nIngrese el ancho de la imagen: ");
            width = r.nextInt();
            System.out.print("Ingrese el alto de la imagen: ");
            height = r.nextInt();
            r.nextLine();
            System.out.print("\n");
        }

        switch (opcion) {
            case 1:
                Bitmap_20614346_EspinozaGonzalez i1 = new Bitmap_20614346_EspinozaGonzalez();
                i1.initImage(width,height);
                break;
            case 2:
                Pixmap_20614346_EspinozaGonzalez i2 = new Pixmap_20614346_EspinozaGonzalez();
                i2.initImage(width,height);
                break;
            case 3:
                Hexmap_20614346_EspinozaGonzalez i3 = new Hexmap_20614346_EspinozaGonzalez();
                i3.initImage(width,height);
                break;
            case 4:
                return 1;
            default:
                System.out.println("El valor ingresado es incorrecto");
                break;
        }
        return 0;
    }
}

