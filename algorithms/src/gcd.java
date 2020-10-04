
//package cf;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class gcd {
    static int p=1000000007;
    public static void main(String[] args) throws Exception{
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FileDescriptor.out), "ASCII"), 512);
        FastReader sc=new FastReader();
        long t= sc.nextLong();
        StringBuilder sb=new StringBuilder();
        while(t-->0)
        {
            int n=sc.nextInt();
            int m=sc.nextInt();
            int ar[][]=new int[n][m];
            boolean f=true;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    int x=4;
                    int te=sc.nextInt();
                    if(i==0||i==n-1)
                        x--;
                    if(j==0||j==m-1)
                        x--;
                    if(te>x)
                    {
                        f=false;
                    }
                    ar[i][j]=x;
                }
            }
            if(f) {
                sb.append("YES\n");
                for (int i = 0; i < n && f; i++) {
                    for (int j = 0; j < m && f; j++) {
                        sb.append(ar[i][j]+" ");
                    }
                    sb.append("\n");
                    }
            }
            else
            {
                sb.append("NO\n");
            }

                    //System.out.println(t+" "+e);
            //System.out.println(t+" "+o);
        }
        out.write(sb.toString());
        out.flush();
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
