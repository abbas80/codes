
//package cf;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class candies {
    static int p=1000000007;
    static long dp[][]=new long[100][(int)1e6+10];
    public static void main(String[] args) throws Exception{
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FileDescriptor.out), "ASCII"), 512);
        FastReader sc=new FastReader();
        int n=sc.nextInt();
        int k=sc.nextInt();
        int ar[]=new int[n];

        long sum_left=0;
        for(int i=0;i<n;i++)
        {
            ar[i]=sc.nextInt();
            sum_left+=ar[i];
        }
        dp[0][0]=1l;
        for(int i=0;i<=ar[0];i++)
        {
            dp[0][i]=1l;
        }
        for(int i=1;i<n;i++)
        {
            long presum[]=new long[k+1];
            Arrays.fill(presum,0l);
            presum[0]=dp[i-1][0];
            for(int j=1;j<=k;j++)
            {
                presum[j]=(presum[j-1]+dp[i-1][j])%p;
            }
            for (int j=0;j<=k;j++)
            {
                if(j>ar[i])
                {
                    dp[i][j]=(presum[j]-presum[j-ar[i]-1]+p)%p;
                }
                else
                    dp[i][j]=presum[j];
            }
        }
        System.out.println(dp[n-1][k]);
        for(int i=0;i<200;i++)
        {
       //     Arrays.fill(dp[i],-1);
        }
        //System.out.println(Arrays.toString(ar)+" \n"+sum_left);
      //  System.out.println(ans(ar,0,k,sum_left));
        out.flush();
    }
    public static long ans(int ar[],int in,int k,long sum_left)
    {
        if(in==ar.length)
        {
            if(k==0)
            {
                dp[in][k]=1l;
                return 1;
            }
            return 0;
        }
       // if(dp[in][k]!=null)
         //   return dp[in][k];
        //   System.out.println(k);
     long limit=Math.min(k,ar[in]);
     long ans=0;
     for(int i=0;i<=limit;i++)
     {
         if(k-i<=sum_left-ar[in])
         {
             ans=(ans+ans(ar,in+1,k-i,sum_left-ar[in]))%p;
         }
     }
     //  System.out.println(ans);
        dp[in][k]=ans;
     return ans%p;
    }
    public static int toggle(int n,int k)
    {
        int t=((n>>k&1)<<k);
        System.out.println("t"+ t);
        if(t>0)
            n=n&~t;
        else
        {
            t=1<<k;
            n=n|t;
        }
        return n;
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
