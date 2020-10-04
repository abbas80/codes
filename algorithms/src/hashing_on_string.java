import java.io.*;
import java.util.*;

public class hashing_on_string {

    static int p=1000000007;
    public static void main(String[] args) throws Exception{
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FileDescriptor.out), "ASCII"), 512);
        FastReader sc=new FastReader();
        String str=sc.nextLine();
        char s[]=str.toCharArray();
        int n=s.length;
        int p=31;
        long mod=(long)1e9+9;

        long hash[]=new long[s.length+1];

        long pow[]=new long[s.length+1];
        pow[0]=1;
        pow[1]=p;
        for(int i=0;i<n;i++)
        {
            hash[i+1]=(hash[i]+(s[i]-'a'+1)*pow[i])%mod;
            pow[i+1]=(pow[i]*p)%mod;
        }
        HashMap<Integer,Long> h1=new HashMap<>();
        Set<Integer> set=new HashSet<>();
        List<Integer> l1=new ArrayList<>();
        for(int i=1;i<=n;i++)
        {
            long cur=(hash[i])%mod;
            cur=(cur*pow[n-i])%mod;
            long cur2=(hash[n]-hash[n-i]+mod)%mod;
            if(cur2==cur)
            {
             ///   System.out.println(n-i);
                h1.put(i,cur);
                set.add(i);
                l1.add(i);
            }
            //System.out.println(cur);
        }
        int ans=Integer.MIN_VALUE;
        int l=0,r=0;
        int c=0,d=l1.size()-1;
        while(c<=d)
        {
            int mid=(c+d)>>1;
            int j=l1.get((int)mid);
            boolean f=false;
            for(int i=1;i+j<=n-1;i++)
            {
                long cur=(hash[i+j]-hash[i]+mod)%mod;
                cur=(cur*pow[n-j-i])%mod;
                //  System.out.println(cur+" "+i+" "+(i+j));
                if(cur==h1.get(j)) {
                    //  System.out.println("  fix "+cur);
                    f=true;
                    if(j>ans)
                    {
                     //   ans=j;
                       // l=i;
                        //r=i+j;
                    }
                    //  System.out.println();
                }
            }
            if(f)
            {
                ans=l1.get(mid);
                c=mid+1;
            }
            else
            {
                d=mid-1;
            }


        }
/*        for(int j:set)
        {
            if(j==n)
                continue;
          //  System.out.println(j);
            for(int i=1;i+j<=n-1;i++)
            {
                long cur=(hash[i+j]-hash[i]+mod)%mod;
                cur=(cur*pow[n-j-i])%mod;
              //  System.out.println(cur+" "+i+" "+(i+j));
                if(cur==h1.get(j)) {
                  //  System.out.println("  fix "+cur);
                    if(j>ans)
                    {
                        ans=j;
                        l=i;
                        r=i+j;
                    }
                  //  System.out.println();
                }
            }

        }*/
       // System.out.println(h1);
        if(ans==Integer.MIN_VALUE)
            System.out.println("Just a legend");
        else
        System.out.println(str.substring(0,ans));
        //System.out.println(Arrays.toString(hash));
        //System.out.println(Arrays.toString(pow));
       // int l=3;
       /* for(int i=0;i<=n-l;i++)
        {
            long cur=(hash[i+l]-hash[i]+mod)%mod;
            cur=(cur*pow[n-1-i])%mod;
           if(i==0)
           // System.out.println(cur);
        }*/
      //  System.out.println(hash[n-1]);



        out.write("");//sb.toString());
        out.flush();
    }
    public static long powin(int pow,int m)
    {
        return pow(pow,m-2,m);
    }
    public static long pow(long a,long b,long m)
    {
        long r=1;
        while(b!=1)
        {
            if(b%2!=0)
                r=(r*a)%m;
            b=b>>1;
            a=(a*a)%m;
        }
        return (r*a)%m;
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

