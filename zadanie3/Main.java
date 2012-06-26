package zadanie3;

import java.util.*;
/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 05.04.12
 * Time: 16:10
 */

public class Main {

    public static void main(String[] args) {

        int[][] matrix = {{0, 1, 2}, {1, 0, 3}, {2, 3, 0}};

        int n = matrix.length;

        List<Edge>[] edges = new List[n];

        for (int i = 0; i < n; i++) {

            edges[i] = new ArrayList<Edge>();

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    edges[i].add(new Edge(j, matrix[i][j]));
                }
            }
        }

        int[] pred = new int[n];

        System.out.println(PrimHeap.mst(edges, pred));

    }
}
