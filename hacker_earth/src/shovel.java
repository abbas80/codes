import java.math.BigInteger;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

import static java.util.Arrays.binarySearch;

public class shovel {
    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuffer sb = new StringBuffer();
        while (t-- > 0) {
            long n = sc.nextLong();
            long k=sc.nextLong();
            if(k>=n)
            {
                sb.append(1+"\n");
                continue;
            }
            if(isprime(n))
            {
                sb.append(n+"\n");
                continue;
            }
            PriorityQueue<Long> x=new PriorityQueue<>();

            ans(n,x);
            Long ar[]=new Long[x.size()];
            int i=0;
            while(!x.isEmpty())
            {
                if(x.peek()!=null)
                ar[i]=(Long) x.poll();
                i++;
            }
           // x.toArray(ar);
            int in=binarySearch(ar,k);
            in=in<0?in*-1-2:in;
            in =in<0?in+1:in;
           // System.out.println(Arrays.toString(ar)+"\n"+in);
           // System.out.println(x);
            //if(x==440404979)
              //  x=62914997;
            long an=n/ar[in];
           sb.append(an+"\n");
        }
        System.out.println(sb.toString());
    }
    public static boolean isprime(long n)
    {
        if(n<2)
            return false;
        if(n==2||n==3||n==5)
            return true;
        if(n%2==0||n%3==0)
            return false;
        long sq= (long) Math.sqrt(n);
        for(long i=5;i<=sq;i+=6)
        {
            if((n)%(i)==0||n%(i+2)==0)
            {
                return false;
            }
        }
        return true;
    }
    private static void ans(long n,PriorityQueue<Long> x) {
       long sq= (long) Math.sqrt(n);
        for(long i=1;i<=sq;i++)
        {
            if(n%(i)==0)
            {
                x.add(i);
                if(n/i!=i)
                    x.add(n/i);

            }
        }
    }

}

