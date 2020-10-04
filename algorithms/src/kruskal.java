
import java.util.*;

public class kruskal {
    class Edge
    {
        int src,des,wt;

        public Edge(int src, int des, int wt) {
            this.src = src;
            this.des = des;
            this.wt = wt;
        }
    }

    static long kruskalDSU(ArrayList<Edge> adj, int n, int m)
    {
        // add your code here
        int p[]=new int[n+1];
        int r[]=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            p[i]=i;
            r[i]=1;
        }
            PriorityQueue<Edge> po=new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.wt-o2.wt;
            }
        });
        for(Edge i:adj)
        {
            po.add(i);
        }
        int ret=0;
        int e=0;
        while(e<n-1)
        {
            Edge i=po.poll();
            int wt=i.wt;

            int u=i.src;
            int v=i.des;//Integer.parseInt(i[0]);
            if(!union(u,v,p,r))
            {
                ret+=wt;
                e++;
            }
        }
        return ret;
    }

    public static boolean union(int a, int b, int p[], int r[]){
        // add your code here
        int pa=find(a,p,r);
        int pb=find(b,p,r);
        if(pa==pb)
            return true;
        if(pa!=pb)
        {
            if(r[pa]<r[pb])
            {
                p[pa]=pb;
            }
            else if(r[pa]>r[pb])
            {
                p[pb]=pa;
            }
            else
            {
                p[pa]=pb;
                r[pb]++;
            }
        }
        return false;
    }
    public static int find(int x,int p[],int r[])
    {
        if(p[x]==x)
            return x;
        p[x]=find(p[x],p,r);
        return p[x];
    }

}