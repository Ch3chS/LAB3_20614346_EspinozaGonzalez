package TDAs.Image;

import TDAs.Pixels.Pixel_20614346_EspinozaGonzalez;

/**
 * Interfaz para los diferentes tipos de imagenes
 * Hay algunos métodos que dicen nunca usarse, sin embargo, se puede ver su uso en las respectivas implementaciones
 * @author Sergio Espinoza
 * @version 1.0
 */

public interface Map_20614346_EspinozaGonzalez{

    /**
     * Método que se encarga de inicializar una imagen de los diferentes tipos
     * @param width Ancho de la imagen
     * @param height Alto de la imagen
     */
    void initImage(int width, int height);

    /**
     * Obtener matriz de pixeles
     * @return Pixeles de algun tipo
     */
    Pixel_20614346_EspinozaGonzalez[][] getPixels();

    /**
     * Voltear eje X de una imagen
     * @return imagen volteada
     */
    Image_20614346_EspinozaGonzalez flipH();

    /**
     * Voltear eje Y de una imagen
     * @return imagen volteada
     */
    Image_20614346_EspinozaGonzalez flipV();

    /**
     * Recortar una imagen
     * @param x1 X desde la que se desea recortar
     * @param y1 Y desde la que se desea recortar
     * @param x2 X hasta la cual se desea recortar (Debe ser >= x1)
     * @param y2 Y hasta la cual se desea recortar (Debe ser >= y1)
     * @return imagen recortada
     */
    Image_20614346_EspinozaGonzalez crop(int x1, int y1, int x2, int y2);

    /**
     * Método para rotar una imagen 90 grados a la derecha
     * @return imagen rotada
     */
    Image_20614346_EspinozaGonzalez rotate90();

    /**
     * Convertir imagen a cadena de texto
     * @return String con la imagen
     */
    String imageToString();

    /**
     * Selector para obtener el ancho de la imagen
     * @return ancho de la imagen
     */
    int getWidth();

    /**
     * Selector para obtener el alto de la imagen
     * @return alto de la imagen
     */
    int getHeight();

    /**
     * Método que permite obtener la máxima profundidad entre los píxeles de una imagen
     * Todos los maps usan este método como pie para el depthLayers por lo que decidí implementarlo aquí
     * @return Profundidad máxima entre los pixeles de la imagen
     */
    default int maxDepth(){   //Todos los tipos map usan este método para depthLayers
        int max = 0;
        for(int i=0; i<getHeight(); i++){
            for(int j=0; j<getWidth();j++) {
                if(max < getPixels()[j][i].getDepth()) max = getPixels()[j][i].getDepth();
            }
        }

        return max;
    }
}
