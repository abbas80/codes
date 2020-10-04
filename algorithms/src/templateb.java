
//package cf;
import java.io.*;
import java.util.*;

public class templateb {
    static int p=1000000007;
    public static void main(String[] args) throws Exception{
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FileDescriptor.out), "ASCII"), 512);
        FastReader sc=new FastReader();
        String a=sc.nextLine();
        int n=sc.nextInt();
        int b[][]=new int[n][2];
        for(int i=0;i<n;i++)
        {
            b[i][0]=sc.nextInt();
            b[i][1]=sc.nextInt();

        }
        // long k = sc.nextLong();
      /*  int n=sc.nextInt();
        StringBuilder sb=new StringBuilder();

        int pos=-1;
        for(int i=31;i>=0;i--)
        {
            System.out.print(((n>>i)&1));
            if(((n>>i)&1)==1&&pos==-1)
            {

                pos=i+1;
             //   break;
            }

        }
        System.out.println();
        System.out.println(pos);
        if(pos%2==0)
        {
            n=toggle(n,pos/2);
            n=toggle(n,(pos/2)-1);
        }
        else
        {
            n=toggle(n,pos/2);
        }
        sb.append(n+"\n");*/

	//System.out.println(sb.toString());

       // StringBuilder sb=new StringBuilder();
       //   out.write(sb.toString());
        out.flush();
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
