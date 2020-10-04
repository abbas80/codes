import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class tuple1 {
    public static int co=3;
    public static boolean bol=false;
    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuffer sb = new StringBuffer();
        while (t-- > 0) {
            co=3;
            bol=false;
            Set<Long> l1=new HashSet<>();
            while(l1.size()!=6)
            {
                long rn=rand(-10,10);
                    l1.add(rn);
            }
            Long in[]=new Long[6];
            l1.toArray(in);
            long a = sc.nextLong();
            long b=sc.nextLong();
            long c=sc.nextLong();
           // System.out.println(a+" "+b+" "+c);
            long p =sc.nextLong();
            long q=sc.nextLong();
            long r=sc.nextLong();

         //   System.out.println(p+" "+q+" "+r);
        //    System.out.println();

            rec(a,b,c,p,q,r,0);
           rec(0,0,0,p,q,r,1);

            rec(a,b,0,p,q,r,1);
            rec(0,b,c,p,q,r,1);
            rec(a,0,c,p,q,r,1);
            rec(a,0,0,p,q,r,1);
            rec(0,b,0,p,q,r,1);
            rec(0,0,c,p,q,r,1);


            rec(-1*a,-1*b,-1*c,p,q,r,1);
            rec(-1*a,-1*b,c,p,q,r,1);
            rec(a,-1*b,-1*c,p,q,r,1);
            rec(-1*a,b,-1*c,p,q,r,1);
            rec(-1*a,b,c,p,q,r,1);
            rec(a,-1*b,c,p,q,r,1);
            rec(a,b,-1*c,p,q,r,1);

            sb.append(co +"\n");
        }
        System.out.println(sb.toString());//+"  "+(1%1)+"  "+(-3%2)+"  "+(-4%-4));

    }
    public static long rand(long a,long b)
    {
        return a+(long)(Math.random()*(b-a+1));
    }
   /* public static int ans(long a,long b,long c,long p,long q,long r)
    {
        int o=0;
        for(int i=-10;i<=10;i++) {
        {
        long ad=a*i;
        long bd=b*i;
        long cd=c*i;
        for(int i=-10;i<=10;i++) {
        ad=ad+i;
        bd=bd+i;
        cd=cd+i;
        if(ad==p&&bd==q&&cd==r)
        {
        co
        }
        }
        }
            if (a == p && b == q && c == r) {
                break;
            }
            if (a != p && b != q && c != r&&a + i == p && b + i == q && c + i == r)//||a*i==p&&b*i==q&&c*i==r)
            {
                a += i;
                b += i;
                c += i;
                o = 1;
                break;
            }
            else if (a != p && b != q && c != r&&a * i == p && b * i == q && c * i == r) {
                a *= i;
                b *= i;
                c *= i;
                o = 1;
                break;
            }
        }
        for(int i=-10;i<=10;i++) {
            if (a == p && b == q && c == r) {
                break;
            }
            if (a!=p&&b!=q&&a + i == p && b + i == q) {
                o++;
                a += i;
                b += i;
                break;

            } else if (a!=p&&c!=r&&a + i == p && c + i == r) {

                o ++;
                a += i;
                c += i;
                break;
              //  System.out.println(i + "  ");
            } else if (b!=q&&c!=r&&b + i == q && c + i == r) {

                o++;
                c += i;
                b += i;
                break;
            } else if (a!=p&&b!=q&&a * i == p && b * i == q) {
                o ++;
                a *= i;
                b *= i;
                break;
            } else if (a!=p&&c!=r&&a * i == p && c * i == r) {

                o ++;
                a *= i;
                c *= i;
                break;
            } else if (b!=q&&c!=r&&b * i == q && c * i == r) {

                o ++;
                c *= i;
                b *= i;
                break;
            }
        }
        for(int i=-10;i<=10;i++) {
            if (a == p && b == q && c == r) {
                break;
            }

            if (a!=p&&a + i == p) {
                o ++;
                a += i;

            } else if (b!=q&&b + i == q) {

                o++;
                b += i;
            } else if (c!=r&&c + i == r) {

                o++;
                c += i;
            } else if (a!=p&&a * i == p) {
                o++;
                a *= i;

            } else if (b!=q&&b * i == q) {

                o++;
                b *= i;
            } else if (c!=r&&c * i == r) {

                o++;
                c *= i;
            }
        }

        return o;
    }*/
    public static void rec2(long a,long b,long c,long p,long q,long r)
    {
       /* if(p!=0&&q!=0&&r!=0) {
            long gcd = gcd(gcd(p, q), r);
            long ad = p / gcd;
            long bd = q / gcd;
            long cd = r / gcd;
       //     rec(ad,bd,cd,p,q,r,1);
            long dif1 = a - ad;
            long dif2 = b - bd;
            long dif3 = c - cd;
            if (dif1 == dif2 && dif1 == dif3) {
                co = Math.max(co, 2);
            }
        }
        if(p!=0&&q!=0) {
            long gcd = gcd(p, q);
            long ad = p / gcd;
            long bd = q / gcd;
            //long cd = r / gcd;
            long dif1 = a - ad;
            long dif2 = b - bd;
            long dif3 = c - r;
            if (dif1 == dif2 && dif1 == dif3) {
                co = Math.max(co, 2);
            }
        }
        if(p!=0&&r!=0) {
            long gcd = gcd(p, r);
            long ad = p / gcd;
            //long bd = q / gcd;
            long cd = r / gcd;
            long dif1 = a - ad;
            long dif2 = b - q;
            long dif3 = c - cd;
            if (dif1 == dif2 && dif1 == dif3) {
                co = Math.max(co, 2);
            }
        }
        if(q!=0&&r!=0) {
            long gcd = gcd(r, q);
            //long ad = p / gcd;
            long bd = q / gcd;
            long cd = r / gcd;
            long dif1 = a - p;
            long dif2 = b - bd;
            long dif3 = c - cd;
            if (dif1 == dif2 && dif1 == dif3) {
                co = Math.max(co, 2);
            }
        }*/

        if(a!=0&&b!=0&&c!=0) {
            long rem1 = p % a;
            long rem2 = q % b;
            long rem3 = r % c;

            long pn = p - rem1;
            pn /= a;
            long qn = q - rem2;
            qn /= b;
            long rn = r - rem3;
            rn /= c;
            if (rn == pn && pn == qn && rem1 == rem2 && rem1 == rem3) {
                co = Math.max(co, 2);
            }
        }
        if(a!=0&&b!=0) {
            long rem1 = p % a;
            long rem2 = q % b;
            //long rem3 = r % c;

            long pn = p - rem1;
            pn /= a;
            long qn = q - rem2;
            qn /= b;
            //long rn = r - rem3;
            //rn /= c;
            if (pn == qn && rem1 == rem2) {
                co = Math.max(co, 2);
            }
        }
        if(a!=0&&c!=0) {
            long rem1 = p % a;
            //long rem2 = q % b;
            long rem3 = r % c;

            long pn = p - rem1;
            pn /= a;
            //long qn = q - rem2;
            //qn /= b;
            long rn = r - rem3;
            rn /= c;
            if (pn == rn && rem1 == rem3) {
                co = Math.max(co, 2);
            }
        }
        if(b!=0&&c!=0) {
            //long rem1 = p % a;
            long rem2 = q % b;
            long rem3 = r % c;

            //long pn = p - rem1;
            //pn /= a;
            long qn = q - rem2;
            qn /= b;
            long rn = r - rem3;
            rn /= c;
            if (rn == qn && rem3 == rem2) {
                co = Math.max(co, 2);
            }
        }

        }
    public static long gcd(long a,long b)
    {
        long te=a;
        a=Math.max(a,b);
        b=Math.min(te,b);
        while(b!=0)
        {
            long t=b;
            b=a%b;
            a=t;
        }
        return a;
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

        if(p!=0&&q!=0&&r!=0&&a!=p&&b!=q&&c!=r) {
            long gcd = gcd(gcd(p, q), r);
            long ad = p / gcd;
            long bd = q / gcd;
            long cd = r / gcd;

            long d1=a-ad;
            long d2=b-bd;
            long d3=c-cd;
            if(d1==d2&&d2==d3)
            rec(a+d1,b+d2,c+d3,p,q,r,x+1);
        }
        else if(a!=p&&b!=q&&p!=0&&q!=0) {
            long gcd = gcd(p, q);
            long ad = p / gcd;
            long bd = q / gcd;
            long d1=a-ad;
            long d2=b-bd;
            if(d1==d2)
            rec(a+d1,b+d2,c,p,q,r,x+1);
        }
        else if(a!=p&&c!=r&&p!=0&&r!=0) {
            long gcd = gcd(p, r);
            long ad = p / gcd;
            //long bd = q / gcd;
            long cd = r / gcd;

            long d1=a-ad;
            long d3=r-cd;
            if(d1==d3)
            rec(a+d1,b,c+d3,p,q,r,x+1);
        }
        else if(c!=r&&b!=q&&q!=0&&r!=0) {
            long gcd = gcd(r, q);
            //long ad = p / gcd;
            long bd = q / gcd;
            long cd = r / gcd;

            long d2=b-bd;
            long d3=c-cd;
            if(d3==d2)
            rec(a,b+d2,c+d3,p,q,r,x+1);
        }

        long dif1=p-a;//1
        long dif2=q-b;//1
        long dif3=r-c;//5

        long fac1=0;
        long fac11=0;
        boolean f1=false;
        if(a!=0)
        {
            //long be=p/a;
            //long af=be*a;
            //if(p%a==0&&(p/a)*a==p)
            //{
                fac1=p/a;

            fac11=fac1<0?fac1-1:fac1+1;
            f1=true;
            //}
        }

        long fac2=0;
        long fac21=0;
        boolean f2=false;
        if(b!=0)
        {
            //long be=q/b;
            //long af=be*b;
            // System.out.println(af+"fac2 "+be*b);

            //if(q%b==0&&(q/b)*b==q)
            //{
                //System.out.println("fac2 "+be);
                fac2=q/b;
            fac21=fac2<0?fac2-1:fac2+1;

            f2=true;
        }

        long fac3=0;
        long fac31=0;
        boolean f3=false;
        if(c!=0)
        {
            //long be=r/c;
            //long af=be*c;
            //if(r%c==0&&(r/c)*c==r)
            //{
                fac3=r/c;
            fac31=fac3<0?fac3-1:fac3+1;
            f3=true;

            //}
        }

        if(dif1!=0) {

            long repa = a + dif1;
            long repb = b + dif1;
            long repc =c + dif1;

            rec(repa, repb, repc, p, q, r, x + 1);
            rec(repa, repb, c, p, q, r, x + 1);
            rec(repa, b, repc, p, q, r, x + 1);
            rec(repa, b, c, p, q, r, x + 1);

            if (f1) {
                long faca = a * fac1;
                long facb = b * fac1;
                long facc = c * fac1;

                rec(faca, facb, facc, p, q, r, x + 1);
                rec(faca, facb, c   , p, q, r, x + 1);
                rec(faca, b   , facc, p, q, r, x + 1);
                rec(faca, b   , c   , p, q, r, x + 1);
            }
            if (f1&&fac11!=fac1) {
                long faca = a * fac11;
                long facb = b * fac11;
                long facc = c * fac11;

                rec(faca, facb, facc, p, q, r, x + 1);
                rec(faca, facb, c   , p, q, r, x + 1);
                rec(faca, b   , facc, p, q, r, x + 1);
                rec(faca, b   , c   , p, q, r, x + 1);
            }

        }
        if(dif2!=0) {
            long repa = a + dif2;
            long repb = b + dif2;
            long repc = c + dif2;

            rec(repa, repb   , repc, p, q, r, x + 1);
            rec(repa, repb   , c   , p, q, r, x + 1);
            rec(a   , repb   , repc, p, q, r, x + 1);
            rec(a   , repb   , c   , p, q, r, x + 1);

            if (f2) {

                long faca = a * fac2;
                long facb = b * fac2;
                long facc = c * fac2;

                rec(faca, facb, facc, p, q, r, x + 1);
                rec(faca, facb, c   , p, q, r, x + 1);
                rec(a   , facb, facc, p, q, r, x + 1);
                rec(a   , facb, c   , p, q, r, x + 1);
            }
            if (f2&&fac21!=fac2) {

                long faca = a * fac21;
                long facb = b * fac21;
                long facc = c * fac21;

                rec(faca, facb, facc, p, q, r, x + 1);
                rec(faca, facb, c   , p, q, r, x + 1);
                rec(a   , facb, facc, p, q, r, x + 1);
                rec(a   , facb, c   , p, q, r, x + 1);
            }
        }
        if(dif3!=0) {

            long repa = a + dif3;
            long repb = b + dif3;
            long repc = c + dif3;

            rec(repa, repb  , repc, p, q, r, x + 1);
            rec(repa, b     , repc, p, q, r, x + 1);
            rec(a   , repb  , repc, p, q, r, x + 1);
            rec(a   , b     , repc, p, q, r, x + 1);


            if (f3) {
                long faca = a * fac3;
                long facb = b * fac3;
                long facc = c * fac3;

                rec(faca, facb, facc, p, q, r, x + 1);
                rec(a   , facb, facc, p, q, r, x + 1);
                rec(faca, b   , facc, p, q, r, x + 1);
                rec(a   , b   , facc, p, q, r, x + 1);

            }
            if (f3&&fac31!=fac3) {
                long faca = a * fac31;
                long facb = b * fac31;
                long facc = c * fac31;

                rec(faca, facb, facc, p, q, r, x + 1);
                rec(a   , facb, facc, p, q, r, x + 1);
                rec(faca, b   , facc, p, q, r, x + 1);
                //           rec(faca, facb, c   , p, q, r, x + 1);
                rec(a   , b   , facc, p, q, r, x + 1);

            }

        }
        /////
        if(dif1!=0) {
            dif1*=-1;
            long repa = a + dif1;
            long repb = b + dif1;
            long repc =c + dif1;

            rec(repa, repb, repc, p, q, r, x + 1);
            rec(repa, repb, c, p, q, r, x + 1);
            rec(repa, b, repc, p, q, r, x + 1);
            rec(repa, b, c, p, q, r, x + 1);

            if (f1) {
                fac1*=-1;
                long faca = a * fac1;
                long facb = b * fac1;
                long facc = c * fac1;

                rec(faca, facb, facc, p, q, r, x + 1);
                rec(faca, facb, c   , p, q, r, x + 1);
                rec(faca, b   , facc, p, q, r, x + 1);
                rec(faca, b   , c   , p, q, r, x + 1);
            }
            if (f1&&fac11!=fac1) {
                fac11*=-1;
                long faca = a * fac11;
                long facb = b * fac11;
                long facc = c * fac11;

                rec(faca, facb, facc, p, q, r, x + 1);
                rec(faca, facb, c   , p, q, r, x + 1);
                rec(faca, b   , facc, p, q, r, x + 1);
                rec(faca, b   , c   , p, q, r, x + 1);
            }

        }
        if(dif2!=0) {
            dif2*=-1;
            long repa = a + dif2;
            long repb = b + dif2;
            long repc = c + dif2;

            rec(repa, repb   , repc, p, q, r, x + 1);
            rec(repa, repb   , c   , p, q, r, x + 1);
            rec(a   , repb   , repc, p, q, r, x + 1);
            rec(a   , repb   , c   , p, q, r, x + 1);

            if (f2) {
                fac2*=-1;
                long faca = a * fac2;
                long facb = b * fac2;
                long facc = c * fac2;

                rec(faca, facb, facc, p, q, r, x + 1);
                rec(faca, facb, c   , p, q, r, x + 1);
                rec(a   , facb, facc, p, q, r, x + 1);
                rec(a   , facb, c   , p, q, r, x + 1);
            }
            if (f2&&fac21!=fac2) {
                fac21*=-1;
                long faca = a * fac21;
                long facb = b * fac21;
                long facc = c * fac21;

                rec(faca, facb, facc, p, q, r, x + 1);
                rec(faca, facb, c   , p, q, r, x + 1);
                rec(a   , facb, facc, p, q, r, x + 1);
                rec(a   , facb, c   , p, q, r, x + 1);
            }
        }
        if(dif3!=0) {
            dif3*=-1;
            long repa = a + dif3;
            long repb = b + dif3;
            long repc = c + dif3;

            rec(repa, repb  , repc, p, q, r, x + 1);
            rec(repa, b     , repc, p, q, r, x + 1);
            rec(a   , repb  , repc, p, q, r, x + 1);
            rec(a   , b     , repc, p, q, r, x + 1);


            if (f3) {
                fac3*=-1;
                long faca = a * fac3;
                long facb = b * fac3;
                long facc = c * fac3;

                rec(faca, facb, facc, p, q, r, x + 1);
                rec(a   , facb, facc, p, q, r, x + 1);
                rec(faca, b   , facc, p, q, r, x + 1);
                rec(a   , b   , facc, p, q, r, x + 1);

            }
            if (f3&&fac31!=fac3) {
                fac31*=-1;
                long faca = a * fac31;
                long facb = b * fac31;
                long facc = c * fac31;

                rec(faca, facb, facc, p, q, r, x + 1);
                rec(a   , facb, facc, p, q, r, x + 1);
                rec(faca, b   , facc, p, q, r, x + 1);
                //           rec(faca, facb, c   , p, q, r, x + 1);
                rec(a   , b   , facc, p, q, r, x + 1);

            }

        }
    }
}