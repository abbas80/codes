import java.util.*;
import java.util.Scanner;

public class bellmen_ford {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int V = 5;
        int E = 8;
        List<edge> l1 = new ArrayList<>();
        int dis[] = new int[V];

        /////
        l1.add(new edge(0, 1, -1));
        // add edge 0-2 (or A-C in above figure)

        l1.add(new edge(0, 2, 4));
        // add edge 1-2 (or B-C in above figure)

        l1.add(new edge(1, 2, 3));
        // add edge 1-3 (or B-D in above figure)

        l1.add(new edge(1, 3, 2));
        // add edge 1-4 (or A-E in above figure)

        l1.add(new edge(1, 4, 2));
        // add edge 3-2 (or D-C in above figure)

        l1.add(new edge(3, 2, 5));
        // add edge 3-1 (or D-B in above figure)

        l1.add(new edge(3, 1, 1));
        // add edge 4-3 (or E-D in above figure)

        l1.add(new edge(4, 3, -3));


        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < E; j++) {
                edge cur_edge = l1.get(j);
                int u = cur_edge.src;
                int v = cur_edge.dst;
                if (dis[u] != Integer.MAX_VALUE && dis[u] + cur_edge.wt < dis[v]) {
                    dis[v] = dis[u] + cur_edge.wt;
                }
            }
        }
        for (int j = 0; j < E; j++) {
            edge cur_edge = l1.get(j);
            int u = cur_edge.src;
            int v = cur_edge.dst;
            if (dis[u] != Integer.MAX_VALUE && dis[u] + cur_edge.wt < dis[v]) {
                System.out.println("Negative Edge cycle");
            }
        }

        System.out.println("Vertex distance from source");
        for (int j = 0; j < V; j++) {
            System.out.println(j + "\t\t" + dis[j]);
        }

    }


   static class edge {
        int src, dst, wt;

        public edge(int src, int dst, int wt) {
            this.src = src;
            this.dst = dst;
            this.wt = wt;
        }
    }
}