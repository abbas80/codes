
//package cf;
import java.io.*;
import java.util.*;

class fs {
    static int p=1000000007;
    public static void main(String[] args) throws Exception {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FileDescriptor.out), "ASCII"), 512);
        FastReader sc = new FastReader();
        int n = sc.nextInt();

        int ar[] = new int[n];
        int br[] = new int[n];
        HashMap<Integer,Integer>  h1=new HashMap<>();
        HashMap<Integer,Integer>  h2=new HashMap<>();

        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
            h1.put(ar[i],i);
        }

        for (int i = 0; i < n; i++) {
            br[i] = sc.nextInt();
            h2.put(br[i],i);
        }
        HashMap<Integer,Integer> l=new HashMap<>();

        HashMap<Integer,Integer> r=new HashMap<>();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            int lv=h2.get(ar[i])-h1.get(ar[i]);
            lv=lv<0?lv+n:lv;
            int rv=h1.get(ar[i])-h2.get(ar[i]);
            rv=rv<0?rv+n:rv;
            if(l.containsKey(lv))
            {
                l.put(lv,l.get(lv)+1);
                max=Math.max(l.get(lv),max);
            }
            else
            {
                l.put(lv,1);
                max=Math.max(1,max);

            }

            if(r.containsKey(rv))
            {
                r.put(rv,r.get(rv)+1);
                max=Math.max(r.get(rv),max);
            }
            else
            {
                r.put(rv,1);
                max=Math.max(1,max);
            }

        }
 out.write( max+ "\n");


        out.flush();
    }
}


///////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////
 class FastReader {

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

