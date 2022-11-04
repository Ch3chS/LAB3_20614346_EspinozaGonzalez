import TDAs.*;

import java.io.IOException;

public class Main_20614346_EspinozaGonzalez {
    public static void main(String[] args) throws IOException {


        char exit = 'e';
        char opcion = 'i';
        char buffer_clean;


    // A continuación se encuentra el código para el menú
        while(opcion != exit){
            System.out.println("\n### Manipulador de Imágenes ###\nEscoja su opción:");
            switch(opcion){
                case 'i':
                    System.out.println("1. Crear una imagen\n2. Modificar una imagen\n3. Visualizar imagen\ne. salir\n");
                    System.out.print("Ingrese su opción: ");
                    opcion = (char) System.in.read();
                    buffer_clean = (char) System.in.read();   // Obtiene el enter de la entrada anterior
                    System.out.println("\n");
                    break;

                case '1':
                    System.out.println("1. Crear bitmap\n2. Crear pixmap\n3. Crear hexmap\n4. Volver");
                    System.out.print("Ingrese su opción: ");
                    opcion = (char) System.in.read();
                    buffer_clean = (char) System.in.read();   // Obtiene el enter de la entrada anterior
                    System.out.println("\n");
                    switch (opcion){
                        case '1': break;
                        case '2': break;
                        case '3': break;
                        case '4':
                            opcion = 'i';
                            break;
                        default:
                            System.out.println("\nLa opción ingresada es incorrecta, por favor, intentelo nuevamente");
                            opcion='1';
                            break;
                    }
                    break;

                case '2':
                    System.out.println("1. fm1\n2. fm2\n3. fm3\n4. fm4");
                    System.out.print("Ingrese su opción: ");
                    opcion = (char) System.in.read();
                    buffer_clean = (char) System.in.read();   // Obtiene el enter de la entrada anterior
                    System.out.println("\n");
                    switch (opcion){
                        case '1': break;
                        case '2': break;
                        case '3': break;
                        case '4':
                            opcion = 'i';
                            break;
                        default:
                            System.out.println("\nLa opción ingresada es incorrecta, por favor, intentelo nuevamente");
                            opcion='2';
                            break;
                    }
                    break;

                case '3':
                    System.out.println("image");

                    opcion = 'i';
                    break;

                default:
                    System.out.println("\nLa opción ingresada es incorrecta, por favor, intentelo nuevamente\nSi desea volver a imprimir el menú ingrese la letra i");
                    System.out.print("Ingrese su opción: ");
                    opcion = (char) System.in.read();
                    buffer_clean = (char) System.in.read();   // Obtiene el enter de la entrada anterior
                    System.out.println("\n");
                    break;
            }
        }
        System.out.println("\nLa ejecución del programa ha finalizado.");
    }
}