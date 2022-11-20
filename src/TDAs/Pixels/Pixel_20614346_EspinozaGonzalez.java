package TDAs.Pixels;

/**
* Esta superclase define el pixel como una entidad con una posición (x, y) y con una profundidad (depth)
* @author Sergio Espinoza
* @version 1.0
 */

public class Pixel_20614346_EspinozaGonzalez implements Pixels_20614346_EspinozaGonzalez{

    /**
     * Los 3 atributos a continuación toman valores enteros positivos (incluyendo al 0)
     */
    int x,y,depth;

    /**
     * Constructor predeterminado de pixel para que las subclases puedan hacer uso del mismo
     */
    public Pixel_20614346_EspinozaGonzalez(){}

    //selectores
    /**
     * Método que retorna la posición X del pixel
     * @return Entero >= 0
     */
    public int getX(){
        return x;
    }

    /**
     * Método que retorna la posición Y del pixel
     * @return Entero >= 0
     */
    public int getY() {
        return y;
    }

    /**
     * Método que retorna la profundidad del pixel
     * @return Entero >= 0
     */
    public int getDepth() {
        return depth;
    }

    //Modificadores

    /**
     * Método que actualiza la posición X del pixel actual
     * @param x Entero >= 0
     */
    public void setX(int x){if(x>=0) this.x = x;}

    /**
     * Método que actualiza la posición Y del pixel actual
     * @param y Entero >= 0
     */
    public void setY(int y) {if(y>=0) this.y = y;}

    /**
     * Método que actualiza la profundidad del pixel actual
     * @param depth Entero >= 0
     */
    public void setDepth(int depth) {if(depth>=0) this.depth = depth;}
}

