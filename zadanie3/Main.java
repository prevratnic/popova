package zadanie3;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 05.04.12
 * Time: 16:10
 */

public class Main {

    public static void main(String[] args) {
/*
        PriorityQueue priorityQueue = new PriorityQueue(5);
        priorityQueue.insert(30);
        priorityQueue.insert(50);
        priorityQueue.insert(10);
        priorityQueue.insert(40);
        priorityQueue.insert(20);

        System.out.print( priorityQueue );
*/
        int[][] cost = { { 0, 1, 2 }, { 1, 0, 3 }, { 2, 3, 0 } };
        
        //for(int i =0; i < cost.length; i++){
          //  for(int j = 0; j < i; j++){
                System.out.print( PrimHeap.mstPrim(cost) );
            //}
        //}

    }
}
