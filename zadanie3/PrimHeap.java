package zadanie3;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 26.06.12
 * Time: 0:59
 */

public class PrimHeap {
    public static long mstPrim(int[][] d) {
        int n = d.length;
        int[] prev = new int[n];
        int[] dist = new int[n];
        //Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue priorityQueue = new PriorityQueue(n);


        dist[0] = 0;
        boolean[] used = new boolean[n];
        long res = 0;
        for (int steps = 0; steps < n; steps++) {
          int bdist = Integer.MAX_VALUE;
          int bi = -1;
          for (int i = 0; i < n; i++) {
            if (!used[i] && bdist > dist[i]) {
              bdist = dist[i];
              bi = i;
            }
          }
          res += bdist;
          used[bi] = true;
          for (int i = 0; i < n; i++) {
            if (!used[i] && dist[i] > d[bi][i]) {
              dist[i] = d[bi][i];
              prev[i] = bi;
            }
          }
        }
        return res;
      }
}
