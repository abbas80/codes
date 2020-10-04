import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class heapsort {
    static int p=1000000007;
    public static void main(String[] args) throws Exception{
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FileDescriptor.out), "ASCII"), 512);
        FastReader sc=new FastReader();
        int n=sc.nextInt();
        int ar[]=new int[n+1];
        for(int i=0;i<n;i++)
        {
            ar[i]=sc.nextInt();
        }
        /*
        heapify
         */
        for (int i=(n-2)/2;i>=0;i--)
        {
            heapify(n,ar,i);
        }

        /*
        extract heapify
         */
        for(int i=n-1;i>=1;i--)
        {

            //System.out.println(Arrays.toString(ar));
            System.out.println(ar[0]);
            swap(ar,0,i);

            System.out.println(Arrays.toString(ar));
            heapify(i,ar,0);
        }
        System.out.println(Arrays.toString(ar));
        out.flush();
    }
    public static  void heapify(int n,int ar[],int i)
    {
        int largest=i;
        int l=i*2+1;
        int r=i*2+2;
        if(l<n&&ar[l]>ar[largest])
        {
            largest=l;
        }
        if(r<n&&ar[r]>ar[largest])
        {
            largest=r;
        }
        if(largest!=i)
        {
            swap(ar,largest,i);
            heapify(n,ar,largest);
        }

    }

    private static void swap(int[] ar, int largest, int i) {
        int t=ar[largest];
        ar[largest]=ar[i];
        ar[i]=t;
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
