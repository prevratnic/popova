package zadanie3;

import java.util.*;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 26.06.12
 * Time: 0:59
 */

public class PrimHeap {

    public static long mst(List<Edge>[] edges, int[] pred) {
        int n = edges.length;
        Arrays.fill(pred, -1);
        boolean[] used = new boolean[n];
        int[] prio = new int[n];
        Arrays.fill(prio, Integer.MAX_VALUE);
        prio[0] = 0;

        java.util.PriorityQueue<Long> q = new java.util.PriorityQueue<Long>();
        q.add(0L);

        long res = 0;

        while (!q.isEmpty()) {
            long cur = q.poll();
            int u = (int) cur;
            if (used[u])
                continue;
            used[u] = true;
            res += cur >>> 32;
            for (Edge e : edges[u]) {
                int v = e.t;
                if (!used[v] && prio[v] > e.cost) {
                    prio[v] = e.cost;
                    pred[v] = u;
                    q.add(((long) prio[v] << 32) + v);
                }
            }
        }
        return res;
    }

}
