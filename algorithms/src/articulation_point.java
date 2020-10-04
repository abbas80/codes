import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class articulation_point {
    static int timer=0;
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=7;
    boolean vis[]=new boolean[n];
    boolean art[]=new boolean[n];
    int low[]=new int[n];
    int dis[] =new int[n];

    List<List<Integer>> adj=new ArrayList<>();
    for(int i=0;i<n;i++)
    {
        List<Integer> l1=new ArrayList<>();
        adj.add(l1);
    }
    /*
    g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        g2.AP();
        System.out.println();

        System.out.println("Articulation points in Third graph ");
        Graph g3 = new Graph(7);
        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        g3.addEdge(2, 0);
        g3.addEdge(1, 3);
        g3.addEdge(1, 4);
        g3.addEdge(1, 6);
        g3.addEdge(3, 5);
        g3.addEdge(4, 5);
        g3.AP();
     */
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(1).add(3);
        adj.get(1).add(4);
        adj.get(1).add(6);
        adj.get(3).add(5);
        adj.get(4).add(5);
        //adj.get(1).add(4);
        adj.get(1).add(0);
        adj.get(2).add(1);
        adj.get(0).add(2);
        adj.get(3).add(1);
        adj.get(4).add(1);
        adj.get(6).add(1);
        adj.get(5).add(3);
        adj.get(5).add(4);


        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            {
                dfs(i,adj,vis,low,dis,-1,art);
            }
        }
        for(int i=0;i<n;i++)
        {
            if(art[i])
                System.out.print(i+" ");
        }
    }
    public static void dfs(int v, List<List<Integer>> adj,boolean vis[],int low[],int dis[],int p,boolean art[])
    {
        vis[v]=true;
        dis[v]=low[v]=timer++;
        int childern=0;
        List<Integer> l1=adj.get(v);
        for(int i:l1)
        {
            if(i==p)
                continue;
            else if(!vis[i])
            {
                childern++;
                dfs(i,adj,vis,low,dis,v,art);
                low[v]=Math.min(low[v],low[i]);
                if(p==-1&&childern>1)
                 art[v]=true;
                if(p!=-1&&low[i]>dis[v])
                {
                    art[v]=true;
                }

            }
            else
            {
                low[v]=Math.min(low[v],dis[i]);
            }
        }
    }
}
