import java.math.BigInteger;
import java.util.Scanner;

public class tprime {
static  int ar[]=new int[(int)10e6+1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int n = sc.nextInt();
        long ar1[]=new long[n];
        seive(ar,(int)10e6);

        for(int i=0;i<n;i++) {
            ar1[i] = sc.nextLong();
            sb.append(ans(ar1[i])+"\n");
        }
System.out.println(sb.toString());

    }
    public static void seive( int ar[],int n)
    {
        for(int i=2;i<=n;i++)
        {
            ar[i]=i;
        }

        for(int i=2;i*i<=n;i++)
        {
            if(ar[i]==i)
            {
                for(int j=i*i;j<=n;j+=i)
                {
                    if(ar[j]==j)
                    {
                        ar[j]=i;
                    }
                }
            }
        }
    }
    public static String ans(long n)
    {

       long sqrt =(long)Math.sqrt(n);
        BigInteger b=new BigInteger(""+n);
        BigInteger br[]=b.sqrtAndRemainder();
        if(Long.parseLong(br[1].toString())!=0)
        {
            return "NO";
        }
       int c=0;
       if(ar[Integer.parseInt(br[0].toString())]==Integer.parseInt(br[0].toString()))
       {
           return "YES";
       }
        return "NO";
    }
}
