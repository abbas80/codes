import java.math.BigInteger;
import java.util.Scanner;

class tuple {
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

            rec(a,b,c,p,q,r,0);
            sb.append(co+"\n");
        }
        System.out.println(sb.toString());//+"  "+(-1%1)+"  "+(-3%2)+"  "+(-4%-4));

    }
    public static void rec(long a,long b,long c,long p,long q,long r,int x)
    {
        if(co==1)
            return;
        if(a==p&&b==q&&c==r)
        {
            co=Math.min(x,co);
            bol=true;
            return;
        }
        if(x>=3)
        {
            co=Math.min(co ,3);
            return;
        }
        long dif1=p-a;//1
        long dif2=q-b;//1
        long dif3=r-c;//5

        long fac1=0;
        boolean f1=true;
        if(a!=0)
        {
            //long be=p/a;
            //long af=be*a;
            if(p%a==0)
            {
                fac1=p/a;
                f1=true;
            }
        }

        long fac2=0;
        boolean f2=true;
        if(b!=0)
        {
            //long be=q/b;
            //long af=be*b;
            // System.out.println(af+"fac2 "+be*b);

            if(q%b==0)
            {
                //System.out.println("fac2 "+be);
                fac2=q/b;
                f2=true;

            }
        }

        long fac3=0;
        boolean f3=true;
        if(c!=0)
        {
            //long be=r/c;
            //long af=be*c;
            if(r%c==0)
            {
                fac3=r/c;
                f3=true;

            }
        }

        if(dif1!=0) {

            long repa = a + dif1;
            long repb = b + dif1;
            long repc = c + dif1;


            rec(repa, repb, repc, p, q, r, x + 1);

            if(co==1)
                return;
            rec(repa, repb, c, p, q, r, x + 1);

            if(co==1)
                return;
            rec(repa, b, repc, p, q, r, x + 1);

            if(co==1)
                return;
            rec(a, repb, repc, p, q, r, x + 1);

            if(co==1)
                return;
            rec(repa, b, c, p, q, r, x + 1);

            if (f1) {
                long faca = a * fac1;
                long facb = b * fac1;
                long facc = c * fac1;

                rec(faca, facb, facc, p, q, r, x + 1);

                if(co==1)
                    return;
                rec(faca, facb, c   , p, q, r, x + 1);

                if(co==1)
                    return;
                rec(faca, b   , facc, p, q, r, x + 1);

                if(co==1)
                    return;
                rec(a   , facb, facc, p, q, r, x + 1);

                if(co==1)
                    return;
                rec(faca, b   , c   , p, q, r, x + 1);
            }
        }
        if(dif2!=0) {
            long repa = a + dif2;
            long repb = b + dif2;
            long repc = c + dif2;

            rec(repa, repb   , repc, p, q, r, x + 1);

            if(co==1)
                return;
            rec(repa, repb   , c   , p, q, r, x + 1);

            if(co==1)
                return;
            rec(a   , repb   , repc, p, q, r, x + 1);

            if(co==1)
                return;
            rec(repa, b      , repc, p, q, r, x + 1);

            if(co==1)
                return;
            rec(a   , repb   , c   , p, q, r, x + 1);

            if (f2) {

                long faca = a * fac2;
                long facb = b * fac2;
                long facc = c * fac2;
                rec(faca, facb, facc, p, q, r, x + 1);

                if(co==1)
                    return;
                rec(faca, facb, c   , p, q, r, x + 1);

                if(co==1)
                    return;
                rec(a   , facb, facc, p, q, r, x + 1);

                if(co==1)
                    return;
                rec(faca, b   , facc, p, q, r, x + 1);

                if(co==1)
                    return;
                rec(a   , facb, c   , p, q, r, x + 1);
            }
        }
        if(dif3!=0) {

            long repa = a + dif3;
            long repb = b + dif3;
            long repc = c + dif3;
            rec(repa, repb  , repc, p, q, r, x + 1);

            if(co==1)
                return;
            rec(repa, b     , repc, p, q, r, x + 1);

            if(co==1)
                return;
            rec(a   , repb  , repc, p, q, r, x + 1);

            if(co==1)
                return;
            rec(repa, repb  , c   , p, q, r, x + 1);
            if(co==1)
                return;
            rec(a   , b     , repc, p, q, r, x + 1);

            if (f3) {
                long faca = a * fac3;
                long facb = b * fac3;
                long facc = c * fac3;

                rec(faca, facb, facc, p, q, r, x + 1);
                if(co==1)
                    return;
                rec(a   , facb, facc, p, q, r, x + 1);
                if(co==1)
                    return;
                rec(faca, b   , facc, p, q, r, x + 1);
                if(co==1)
                    return;
                rec(faca, facb, c   , p, q, r, x + 1);
                if(co==1)
                    return;

                rec(a   , b   , facc, p, q, r, x + 1);
            }
        }
    }
    public static boolean check(long s,long d,long c)
    {

        return true;
    }
}
/*
1 2 3
2 3 4
-1 -2 -3
0 0 0
0 0 0
0 0 0
-1 -2 -3
1 2 3

 */