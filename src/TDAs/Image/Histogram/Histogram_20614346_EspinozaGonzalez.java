package TDAs.Image.Histogram;

/**
 * TDA histograma, debido a la especifidad en el color de cada histograma, el de cada imagen es algo diferente
 * Lo que más nos interesa para el método compress de la imagen es que todos sean capaces de decir el color más usado.
 * @author Sergio Espinoza
 * @version 1.0
 */

public interface Histogram_20614346_EspinozaGonzalez {
    /**
     * Método que permite obtener el color con la cantidad más grande del histograma
     * @return string (el formato depende del tipo de histograma que use el método)
     */
    String MostUsed();
}
