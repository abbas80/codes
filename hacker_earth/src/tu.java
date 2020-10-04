import java.math.BigInteger;
import java.util.Scanner;

public class tu {
    public static int co=Integer.MAX_VALUE;
    public static boolean bol=false;
    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuffer sb = new StringBuffer();
        while (t-- > 0) {
            co=Integer.MAX_VALUE;
            bol=false;
            long a = sc.nextLong();
            long b=sc.nextLong();
            long c=sc.nextLong();

            long p = sc.nextLong();
            long q=sc.nextLong();
            long r=sc.nextLong();

            long dif1=p-a;//1
            long dif2=q-b;//1
            long dif3=r-c;//5
            /*if(a<0&&p<0)
            {
                a=-1*a;
                p=-1*p;
            }

            if(b<0&&q<0)
            {
                b=-1*b;
                q=-1*q;
            }
            if(c<0&&r<0)
            {
                c=-1*c;
                r=-1*r;
            }*/

            rec(a,b,c,p,q,r,0);
            sb.append(co+"\n");

        }
        System.out.println(sb.toString());

    }
    public static void rec(long a,long b,long c,long p,long q,long r,int x)
    {
        if(a==p&&b==q&&c==r)
        {
            co=Math.min(x,co);
            bol=true;
            return;
        }
        if(x>3)
        {
            co=Math.min(co ,3);
            return;
        }
        long dif1=p-a;//1
        long dif2=q-b;//1
        long dif3=r-c;//5

        long fac1=0;
        boolean f1=false;
        if(a!=0)
        {
            long be=p/a;
            long af=be*a;
            if(p==af)
            {
                fac1=be;
                f1=true;
                // System.out.println(fac1);
            }
        }

        long fac2=0;
        boolean f2=false;
        if(b!=0)
        {
            long be=q/b;
            long af=be*b;
            // System.out.println(af+"fac2 "+be*b);

            if(q==af)
            {
                //System.out.println("fac2 "+be);
                fac2=be;
                f2=true;

            }
        }

        long fac3=0;
        boolean f3=false;
        if(c!=0)
        {
            long be=r/c;
            long af=be*c;
            if(r==af)
            {
                fac3=be;
                f3=true;

            }
        }

        if(dif1!=0)
        {

            long repa=check(a,p,a+dif1)?a+dif1:a;
            long repb=check(b,q,b+dif1)?b+dif1:b;
            long repc=check(c,r,c+dif1)?c+dif1:c;
            rec( repa ,repb  ,   repc ,p,q,r,x+1);

            rec(repa  ,repb ,     c,p,q,r,x+1);
            rec(repa , b,        repc,p,q,r,x+1);
            rec(repa ,  b,          c,p,q,r,x+1);

            if(f1)
            {
                // System.out.println("fact");
                //long faca=p-a*fac1>=0&&p-a*fac1<=Math.abs(p-a)?a*fac1:a;
                //long facb=q-b*fac1>=0&&q-b*fac1<=Math.abs(q-b)?b*fac1:b;
                //long facc=r-c*fac1>=0&&r-c*fac1<=Math.abs(r-c)?c*fac1:c;
                long faca=check(a,p,a*fac1)?a*fac1:a;
                long facb=check(b,q,b*fac1)?b*fac1:b;
                long facc=check(c,r,c*fac1)?c*fac1:c;
                //System.out.println(faca+"fact"+a+"  "+fac1);

                rec( faca   , facb  , facc ,p,q,r,x+1);
                rec( faca   , facb  , c    ,p,q,r,x+1);
                rec( faca   , b     , facc ,p,q,r,x+1);
                rec( faca   , b     , c    ,p,q,r,x+1);
            }
        }
        if(dif2!=0)
        {
            //        long repa=(p-(a+dif2)>=0&&p-(a+dif2)<Math.abs(p-a))?a+dif2:a;
            //          long repb=((q-(b+dif2)>=0)&&q-(b+dif2)<Math.abs(q-b))?b+dif2:b;
//            long repc=(r-(c+dif2)>=0&&r-(c+dif2)<Math.abs(r-c))?c+dif2:c;

            long repa=check(a,p,a+dif2)?a+dif2:a;
            long repb=check(b,q,b+dif2)?b+dif2:b;
            long repc=check(c,r,c+dif2)?c+dif2:c;

            // System.out.println(repb+" "+b+"  "+dif2);
            rec(repa  , repb  , repc ,p,q,r,x+1);
            rec(repa  , repb  , c    ,p,q,r,x+1);
            rec( a    , repb  , repc ,p,q,r,x+1);
            rec( a    , repb  , c    ,p,q,r,x+1);

            if(f2)
            {
                // long faca=p-a*fac2>=0&&p-a*fac2<=Math.abs(p-a)?a*fac2:a;
                //   long facb=q-b*fac2>=0&&q-b*fac2<=Math.abs(q-b)?b*fac2:b;
                //     long facc=r-c*fac2>=0&&r-c*fac2<=Math.abs(r-c)?c*fac2:c;
                long faca=check(a,p,a*fac2)?a*fac2:a;
                long facb=check(b,q,b*fac2)?b*fac2:b;
                long facc=check(c,r,c*fac2)?c*fac2:c;

                // System.out.println("fact");

                rec( faca , facb , facc, p,q,r,x+1);
                rec( faca , facb , c   , p,q,r,x+1);
                rec( a    , facb , facc, p,q,r,x+1);
                rec( a    , facb , c   ,p, q,r,x+1);
            }
        }
        if(dif3!=0)
        {
            long repa=check(a,p,a+dif3)?a+dif3:a;
            long repb=check(b,q,b+dif3)?b+dif3:b;
            long repc=check(c,r,c+dif3)?c+dif3:c;
            rec( repa  ,repb ,repc,p,q,r,x+1);
            rec( repa  , b   ,repc,p,q,r,x+1);
            rec( a     ,repb ,repc,p,q,r,x+1);
            rec( a     , b   ,repc,p,q,r,x+1);

            if(f3)
            {
                long faca=check(a,p,a*fac3)?a*fac3:a;
                long facb=check(b,q,b*fac3)?b*fac3:b;
                long facc=check(c,r,c*fac3)?c*fac3:c;


                rec( faca , facb, facc ,p,q,r,x+1);
                rec( a    , facb, facc ,p,q,r,x+1);
                rec( faca , b   , facc ,p,q,r,x+1);
                rec( a    , b   , facc ,p,q,r,x+1);
            }
        }

    }
    public static boolean check(long s,long d,long c)
    {

        return true;
    }
}
/*
2
3 5 7
6 5 10
8 6 3
9 7 8
3 5 7
6 5 10
8 6 3
9 7 8

 */