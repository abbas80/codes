import java.math.BigInteger;
import java.util.*;
//import java.util.PriorityQueue;

class prims {
   public static void main (String[]args){
       Scanner sc = new Scanner(System.in);
       int V=9;
       int s=0;
       List<List<pairr>> adj=new ArrayList<>();
       for(int i=0;i<V;i++)
       {
           List<pairr> tpl=new ArrayList<>();
           adj.add(tpl);
       }
       //g.addEdge(0, 1, 4);
       adj.get(0).add(new pairr(1,4));
       adj.get(1).add(new pairr(0,4));

       //g.addEdge(0, 7, 8);
       adj.get(0).add(new pairr(7,8));
       adj.get(7).add(new pairr(0,8));

       //g.addEdge(1, 2, 8);
       adj.get(1).add(new pairr(2,8));
       adj.get(2).add(new pairr(1,8));

       //g.addEdge(1, 7, 11);
       adj.get(1).add(new pairr(7,11));
       adj.get(7).add(new pairr(1,11));

       // g.addEdge(2, 3, 7);
       adj.get(2).add(new pairr(3,7));
       adj.get(3).add(new pairr(2,7));

       //g.addEdge(2, 8, 2);
       adj.get(2).add(new pairr(8,2));
       adj.get(8).add(new pairr(2,2));

       //g.addEdge(2, 5, 4);
       adj.get(2).add(new pairr(5,4));
       adj.get(5).add(new pairr(2,4));


       //g.addEdge(3, 4, 9);
       adj.get(3).add(new pairr(4,9));
       adj.get(4).add(new pairr(3,9));

       //g.addEdge(3, 5, 14);
       adj.get(3).add(new pairr(5,14));
       adj.get(5).add(new pairr(3,14));

       //g.addEdge(4, 5, 10);
       adj.get(4).add(new pairr(5,10));
       adj.get(5).add(new pairr(4,10));

       //g.addEdge(5, 6, 2);
       adj.get(5).add(new pairr(6,2));
       adj.get(6).add(new pairr(5,2));

       //g.addEdge(6, 7, 1);
       adj.get(6).add(new pairr(7,1));
       adj.get(7).add(new pairr(6,1));


       //g.addEdge(6, 8, 6);
       adj.get(6).add(new pairr(8,6));
       adj.get(8).add(new pairr(6,6));

       //g.addEdge(7, 8, 7);
       adj.get(7).add(new pairr(8,7));
       adj.get(8).add(new pairr(7,7));

       //boolean mst[]=new boolean[V];
       int dis[]=new int[V];
       Arrays.fill(dis,Integer.MAX_VALUE);

       Set<Integer> mst=new HashSet<>();

       int pr[]=new int[V];
       PriorityQueue<pairr> pq=new PriorityQueue<>(new Comparator<pairr>() {
           @Override
           public int compare(pairr o1, pairr o2) {
               return o1.d-o2.d;
           }
       });
       pq.add(new pairr(s,0));
       pr[0]=-1;
           //System.out.println(tr);
      while(!pq.isEmpty())
      {
          pairr t=pq.poll();
           int u=t.e;
           mst.add(u);
               System.out.print(u+"-->");
               List<pairr> l1=adj.get(u);
               for(pairr i:l1)
               {
                   int v=i.e;
                   int disv=i.d;
                   if(!mst.contains(v))
                   {
                       if(disv<dis[v]) {
                           dis[v] = disv;
                           pr[v] = u;
                           pq.add(new pairr(v,dis[v]));

                       }
                       //pq.add(new pairr(v,dis[v]));
                   }
               }
       }
       System.out.println();
       for(int i=1;i<V;i++)
       {
           System.out.println(pr[i]+"-to- "+i+" is "+dis[i]);
       }
   }
}

