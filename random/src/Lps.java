
//package cf;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Lps {
    static int p=1000000007;
    public static void main(String[] args) throws Exception{
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FileDescriptor.out), "ASCII"), 512);
        FastReader sc=new FastReader();
        String tx=sc.nextLine();
        String a=sc.nextLine();
        int m=tx.length();
        int n=a.length();
        char ar[]=a.toCharArray();
        char txt[]=tx.toCharArray();
        int lps[]=new int[n];
        genrate_lps(ar,lps);
        System.out.println(Arrays.toString(lps));
        System.out.println(Arrays.toString(ar));
        int j=0;
        int i=0;

        while(i<m)
        {

            if(txt[i]==ar[j])
            {

                j++;
                i++;
            }
            else if(j!=0)
            {
                j=lps[j-1];
            }
            else
            {
                j=0;
                i++;
            }
            if(j==n)
            {
                System.out.println("FOUND AT " +(i-j));
                j=lps[j-1];
            }
        }
          out.flush();
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
