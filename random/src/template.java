import java.util.Arrays;

public class template {
    static  long x,y,d;
    public static void main(String[] args) {
        System.out.println(gcd(-15,0));
        int ar[]=new int[10];
        int c=0;
        for(int i=1;i<20;i+=2)
        {
            ar[c++]=i;
        }
        System.out.println(Arrays.toString(ar));
        System.out.println(Arrays.binarySearch(ar,3));
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
    public static long gcd(long a,long b)
    {
        if(b>a)
        {
            a=a^b;
            b=a^b;
            a=a^b;
        }
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
    public static void extgcd(long a,long b)
    {
        if(a==0)
        {
            x=0;
            y=1;
            d=b;
            // return ;
        }
        else
        {

            extgcd(b%a,a);

            long t=y;
            y=x;
            x=t-(b/a)*x;
        }
    }
}
