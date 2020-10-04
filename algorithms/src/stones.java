
//package cf;
import java.io.*;
import java.util.*;

public class stones {
    static int p=1000000007;
    public static void main(String[] args) throws Exception {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FileDescriptor.out), "ASCII"), 512);
        FastReader sc = new FastReader();
        // long k = sc.nextLong();
        int n = sc.nextInt();
        int k= sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int ar[]=new int[n];
        int s=0,tot=0;
        for(int i=0;i<n;i++)
        {
            ar[i]=sc.nextInt();
        }
        Arrays.sort(ar);
        int dp[] = new int[k+1];
       // Arrays.fill(dp,-1);
        //dp[0]=0;
        for(int i=1;i<=k;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i-ar[j]>=0&&dp[i-ar[j]]==0)
                {
                    dp[i]=1;
                    break;
                }
            }
        }
        System.out.println(dp[k]==1?"First":"Second");
//Arrays.fill(dp,-1);
        //System.out.println(dp(ar,n,k,dp));


    }
    public static int dp(int ar[],int n,int cur,int k,int dp[]) {
      //  System.out.println(k+" ");
        if(k<=0)
            return 0;
        if(dp[k]!=-1)
            return dp[k];

         for(int i=0;i<n;i++)
        {
            if(k-ar[i]<0)
                break;
            int ans=0;//dp(ar,n,k-ar[i],dp);
            if(ans==0)
            {
             // System.out.println(k+" "+ar[i]);
                dp[k]=1;
                return dp[k]=1;
            }
        }
        dp[k]=0;
        return dp[k];
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
