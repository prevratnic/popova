package zadanie3;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 05.04.12
 * Time: 16:10
 */

public class Main {

    public static void main(String[] args) {

        PyramidSort pyramidSort = new PyramidSort();
        pyramidSort.print("Случайно составленная последовательность");

        pyramidSort.arrayToPyramid();
        pyramidSort.print("Пирамида");

        pyramidSort.sortPyramidal();
        pyramidSort.print("Сортировка пирамиды");

    }
}
