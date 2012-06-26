package zadanie2;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 05.04.12
 * Time: 16:15
 */

public class PyramidSort {

    private int[] array = new int[20];
    //private int[] array = {81,6,23,38,95,71,72,39,34,53};

    public PyramidSort(){

        for( int i = 0; i < 20; i++ ){
            array[i] = (int)(Math.random() * 100);
        }

    }

    public void sortPyramidal(){

        for(int i = array.length; i > 1; i--){
            pyramid( array, i -1 );
        }

    }

    public void arrayToPyramid(){

        for(int index = array.length/2-1; index>=0; index--){
            pyramid( index );
        }

    }

    public void pyramid( int array[], int index ){

        int largeChild;
        int tmp;
        int root = (index - 1) / 2;

        for (int i = root; i >= 0; i--) {
            for (int j = root; j >= 0; j--) {

                int leftChild = (2 * i) + 1;
                int rightChild = (2 * i) + 2;

                if ((leftChild <= index) && (rightChild <= index)) {
                    if (array[rightChild] >= array[leftChild]) {
                        largeChild = rightChild;
                    } else {
                        largeChild = leftChild;
                    }
                } else {
                    if (rightChild > index) {
                        largeChild = leftChild;
                    } else {
                        largeChild = rightChild;
                    }
                }

                if (array[i] < array[largeChild]) {
                    tmp = array[i];
                    array[i] = array[largeChild];
                    array[largeChild] = tmp;
                }
            }
        }

        tmp = array[0];
        array[0] = array[index];
        array[index] = tmp;
    }

    private void pyramid(int index){

        int largeChild;
        int top = array[index];
        int currentSize = array.length;

        while( index < currentSize/2 ){

            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;

            if( (rightChild < currentSize) && (array[leftChild] <  array[rightChild]) ){
                largeChild = rightChild;
            }else{
                largeChild = leftChild;
            }

            if( top >= array[largeChild] ){
                break;
            }

            array[index] = array[largeChild];
            index = largeChild;

        }
        array[index] = top;

    }

    public void print(String str){

        System.out.print(str + ": ");

        for( Integer val : array ){
            System.out.print(val + " ");
        }

        System.out.print("\n");

    }

}



