import java.math.BigInteger;
import java.util.Scanner;

public class template1 {
 public static void main (String[]args){
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            StringBuilder sb=new StringBuilder();
            while (t-- > 0) {
                long n = sc.nextLong();
                BigInteger b=new BigInteger(""+n);
                b=b.sqrt();
                System.out.println(b.toString()+" = "+(long)Math.sqrt(n));

            }
        }
    public static void sieve(int n,int ar[])
    {
        for(int i=2;i<=n;i++)
        {
            ar[i]=i;
        }
        for(int i=2;i*i<=n;i++)
        {
            if(ar[i]==i)
            {
                int c=1;
                for(int j=i*i;j<=n;j+=i)
                {
                    if(ar[j]==j)
                    {
                        ar[j]=i;
                        c++;
                    }
                }
                ar[i]=c;
            }
        }
    }
    }
