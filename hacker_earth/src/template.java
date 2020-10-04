public class template {
    static  long x,y,d;
    public static void main(String[] args) {
        System.out.println(gcd(15,1));
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
        if(a==1||b==1)
            return 1l;
        while(b!=0)
        {
            long t=b;
            b=a%b;
            a=t;
        }
           return a;
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
