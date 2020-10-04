
//package cf;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Z_algorithm {
    static int p=1000000007;
    public static void main(String[] args) throws Exception{
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FileDescriptor.out), "ASCII"), 512);
        FastReader sc=new FastReader();
        String tx=sc.nextLine();
        String a=sc.nextLine();
        tx=a+"*"+tx;
        int m=a.length();
        int n=tx.length();
        //char ar[]=a.toCharArray();
        char txt[]=tx.toCharArray();
        int z[]=new int[n];
    //    genrate_lps(ar,lps);
      //  System.out.println(Arrays.toString(lps));
       // System.out.println(Arrays.toString(ar));
       // int j=0;
        int i=0;
        int l=0,r=0;
        for( i=1;i<n;i++)
        {
            //System.out.println("Before"+Arrays.toString(z)+l+" "+r);
            if(i<=r)
                z[i]=Math.min(r-i+1,z[i-l]);
                // either z0 or lenght of the string


            while(i+z[i]<n&&txt[z[i]]==txt[i+z[i]])
            {
                z[i]++;
              //  System.out.println(Arrays.toString(z));
            }
            if(i+z[i]-1>r) {
              //new box
                l=i;
                r=i+z[i]-1;
            }

            //System.out.println("after" +Arrays.toString(z));
        }
        for(i=0;i<n;i++)
        {
            if(z[i]==m)
                System.out.println("FOUND at "+(i-m));
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
