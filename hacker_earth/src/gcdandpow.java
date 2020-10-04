import java.math.BigInteger;
import java.util.Scanner;

public class gcdandpow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long    ar[]=new long[n];

        for(int i=0;i<n;i++)
        {
          ar[i]=sc.nextLong();
        }
        long res=ar[0];
        for(int i=1;i<n;i++)
        {
            res=gcd(res,ar[i]);
            if(res==1)
            {
                break;
            }
        }
        long mod=(long)10e9+7;

        long fx=1;
        for(long i:ar)
        {
            fx=(fx%mod*i%mod)%mod;
        }
        long ans=pow(fx,res,mod)%mod;
        System.out.println(res+ "  "+ans);

    }
    public static long gcd(long a,long b)
    {
        while(b!=0)
        {
            long t=b;
            b=a%b;
            a=t;
        }
        return a;
    }
    public static long pow(long a,long b,long m)
    {
        if(b==0)
            return 1;
        long r=1;
        while(b!=1)
        {
            if(b%2!=0)
                r=(r%m*a%m)%m;
            b=b>>1;
            a=(a%m*a%m)%m;
        }
        return (r%m*a%m)%m;
    }
}
