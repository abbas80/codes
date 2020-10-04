import java.math.BigInteger;
import java.util.Scanner;

public class primefactor {
        public static void main (String[]args){
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            int ar[]=new int[(int)1e6+1];
            sieve((int)1e6,ar);
            StringBuilder sb=new StringBuilder();
            while (t-- > 0) {
                int n = sc.nextInt();
                sb.append((ar[n]==n?1:ar[n])+"\n");
            }
            System.out.println(sb.toString());
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
