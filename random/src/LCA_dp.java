
//package cf;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class LCA_dp {
    /*
    8
1 2
1 3
2 4
2 5
2 6
3 7
3 8
Enter 2 child
4 8
lca =1
4

                        1
                    2       3
            /     /  \     |  \
           4     5    6     7   8
     */
    //static int p=1000000007;
    static int p[]=new int[(int)1e5];
    static int dp[][]=new int[(int)1e5][100];
    static int level[]=new int[(int)1e5];
    static int maxn=0;
    public static void main(String[] args) throws Exception{
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FileDescriptor.out), "ASCII"), 512);
        FastReader sc=new FastReader();
        int n=sc.nextInt();
        List<Integer> adj[]=new ArrayList[n+1];

        for(int i=0;i<=n;i++) {
        adj[i]=new ArrayList<>();
        }

        for(int i=0;i<n-1;i++)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
                dp[i][j]=-1;
        }
        dfs(adj,1,-1,1);
         maxn=(int)(Math.log10(n)/Math.log10(2));

        for(int i=1;i<=maxn;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(dp[j][i-1]!=-1)
                {
                    int par=dp[j][i-1];
                    dp[i][j]=dp[par][i-1];
                }
            }
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=i+1;j<=n;j++)
            {
                int lca=lca(i,j);
            }
        }
        System.out.println("Enter 2 child");
        int a=sc.nextInt();
        int b=sc.nextInt();
        int lca=lca(a,b);
        System.out.println("lca ="+lca);
        int dis=level[b]+level[b]-2*level[lca];
        System.out.println(dis);

        out.flush();
    }
    public static int lca(int a,int b)
    {
        if(level[a]>level[b])
        {
            a=a^b;
            b=a^b;
            a=a^b;
        }
        int d=level[b]-level[a];
        while(d>0)
        {
            int dg=(int)(Math.log10(d)/Math.log10(2));
            b=dp[b][dg];
            d-=1<<dg;
        }
        if(a==b)
            return a;
        for(int i=maxn;i>=0;i--)
        {
            if(dp[a][i]!=-1&&(dp[a][i]!=dp[b][i]))
            {
                a=dp[a][i];
                b=dp[b][i];
            }
        }
        return dp[a][0];
    }
    public static void dfs(List<Integer> adj[],int u,int pr,int le)
    {
        level[u]=le;
        dp[u][0]=pr;
        for(int i:adj[u])
        {
            if(i!=pr)
            {
                dfs(adj,i,u,le+1);
            }
        }
    }
    public static int genrate_lps(char ar[],int lps[])
    {
        int i=0;
        int j=1;
        int n=ar.length;
        while(j<n)
        {
            if(ar[i]==ar[j])
            {
                lps[j]=i+1;
                i++;
                j++;
            }
            else if(i!=0)
            {
                i--;
            }
            else
            {
                lps[j]=0;
                j++;
                i=0;
            }
        }
        return 1;
    }






    ///////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////
    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }


}
